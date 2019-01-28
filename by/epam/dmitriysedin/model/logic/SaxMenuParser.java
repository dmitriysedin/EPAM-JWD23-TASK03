package by.epam.dmitriysedin.model.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import by.epam.dmitriysedin.model.entity.AssortmentOfMenu;
import by.epam.dmitriysedin.model.entity.DishOfAssortment;
import by.epam.dmitriysedin.model.entity.Menu;
import by.epam.dmitriysedin.model.entity.SpecificationOfDish;

public class SaxMenuParser extends DefaultHandler {

	private List<Menu> menuList = new ArrayList<>();
    private Menu menu;
    private AssortmentOfMenu assortmentOfMenu;
    private DishOfAssortment dishOfAssortment;
    private SpecificationOfDish specificationOfDish;
    private StringBuilder text;

    public List<Menu> getMenuList(String faileName) throws IOException {
        
        try {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        
        reader.setContentHandler(this);
        
        reader.parse(new InputSource(faileName));

        reader.setFeature("http://xml.org/sax/features/validation", true);

        reader.setFeature("http://xml.org/sax/features/namespaces", true);

        reader.setFeature("http://xml.org/sax/features/string-interning", true);

        reader.setFeature("http://apache.org/xml/features/validation/schema", false);
        } catch(SAXException e){
        	e.printStackTrace();//throw new MyException
        }
        
        return menuList;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element -->" + "uri: " + uri + ", localName:" + localName + ", qName:" + qName);

        text = new StringBuilder();
        switch (qName){
            case "menu":
                menu = new Menu();
                menu.setMenuID(attributes.getValue("id"));
                menu.setMenuCurrency(attributes.getValue("currency"));
                break;
            case "assortment":
                assortmentOfMenu = new AssortmentOfMenu();
                assortmentOfMenu.setAssortmentID(attributes.getValue("id"));
                break;
            case "dish":
                dishOfAssortment = new DishOfAssortment();
                dishOfAssortment.setDishID(attributes.getValue("id"));
                break;
            case "dish-specification":
                specificationOfDish = new SpecificationOfDish();
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        switch (qName){
            case "menu-name":
                menu.setMenuName(text.toString());
                break;
            case "menu-annotation":
                menu.setMenuAnnotation(text.toString());
                break;
            case "assortment-name":
                assortmentOfMenu.setAssortmentName(text.toString());
                break;
            case "assortment-annotation":
                assortmentOfMenu.setAssortmentAnnotation(text.toString());
                break;
            case "dish-name":
                dishOfAssortment.setDishName(text.toString());
                break;
            case "dish-annotation":
                dishOfAssortment.setDishAnnotation(text.toString());
                break;
            case "dish-extra-description":
                dishOfAssortment.setDishExtraDescription(text.toString());
                break;
            case "dish-description":
                specificationOfDish.setDishDescription(text.toString());
                break;
            case "dish-portion":
                specificationOfDish.setDishPortion(text.toString());
                break;
            case "dish-price":
                specificationOfDish.setDishPrice(text.toString());
                break;
            case "dish-specification":
                dishOfAssortment.getSpecificationOfDishes().add(specificationOfDish);
                specificationOfDish = null;
                break;
            case "dish":
                assortmentOfMenu.getDishes().add(dishOfAssortment);
                dishOfAssortment = null;
                break;
            case "assortment":
                menu.getAssortments().add(assortmentOfMenu);
                assortmentOfMenu = null;
                break;
            case "menu":
                menuList.add(menu);
                menu = null;
                break;
        }
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("warn" + e.getLineNumber() + " " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.out.println("err" + e.getLineNumber() + " " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("fatal" + e.getLineNumber() + " " + e.getMessage());
    }
}
