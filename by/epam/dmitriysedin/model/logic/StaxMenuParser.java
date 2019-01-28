package by.epam.dmitriysedin.model.logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.dmitriysedin.model.entity.AssortmentOfMenu;
import by.epam.dmitriysedin.model.entity.DishOfAssortment;
import by.epam.dmitriysedin.model.entity.Menu;
import by.epam.dmitriysedin.model.entity.SpecificationOfDish;

public class StaxMenuParser {

	public List<Menu> getMenuList(String fileName) throws FileNotFoundException {

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        List<Menu> menuList = new ArrayList<>();

        try {
            InputStream inputStream = new FileInputStream(fileName);
            XMLStreamReader streamReader = inputFactory.createXMLStreamReader(inputStream);
            menuList = process(streamReader);
            } catch (XMLStreamException e){
            e.printStackTrace();//throw new MyException
        }
            return menuList;
    }

    private static List<Menu> process(XMLStreamReader reader) throws XMLStreamException{

        List<Menu> menus = new ArrayList<>();
        Menu menu = null;
        AssortmentOfMenu assortmentOfMenu = null;
        DishOfAssortment dishOfAssortment = null;
        SpecificationOfDish specificationOfDish = null;
        String elementName = null;

        while (reader.hasNext()){

            int type = reader.next();

            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                elementName = reader.getLocalName();
                switch (elementName){
                    case "menu":
                        menu = new Menu();
                        menu.setMenuID(reader.getAttributeValue(null,"id"));
                        menu.setMenuCurrency(reader.getAttributeValue(null, "currency"));
                        break;
                    case "assortment":
                        assortmentOfMenu = new AssortmentOfMenu();
                        assortmentOfMenu.setAssortmentID(reader.getAttributeValue(null,"id"));
                        break;
                    case "dish":
                        dishOfAssortment = new DishOfAssortment();
                        dishOfAssortment.setDishID(reader.getAttributeValue(null,"id"));
                        break;
                    case "dish-specification":
                        specificationOfDish = new SpecificationOfDish();
                        break;
                }
                break;

                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()){
                        break;
                    }
                    switch (elementName){
                        case "menu-name":
                            menu.setMenuName(text);
                            break;
                        case "menu-annotation":
                            menu.setMenuAnnotation(text);
                            break;
                        case "assortment-name":
                            assortmentOfMenu.setAssortmentName(text);
                            break;
                        case "assortment-annotation":
                            assortmentOfMenu.setAssortmentAnnotation(text);
                            break;
                        case "dish-name":
                            dishOfAssortment.setDishName(text);
                            break;
                        case "dish-annotation":
                            dishOfAssortment.setDishAnnotation(text);
                            break;
                        case "dish-extra-description":
                            dishOfAssortment.setDishExtraDescription(text);
                            break;
                        case "dish-description":
                            specificationOfDish.setDishDescription(text);
                            break;
                        case "dish-portion":
                            specificationOfDish.setDishPortion(text);
                            break;
                        case "dish-price":
                            specificationOfDish.setDishPrice(text);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = reader.getLocalName();
                    switch (elementName){
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
                            menus.add(menu);
                            menu = null;
                            break;
                    }
                    break;
            }
        }
        return menus;
    }
}
