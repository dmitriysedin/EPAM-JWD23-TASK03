package by.epam.dmitriysedin.model.logic;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

import by.epam.dmitriysedin.model.entity.AssortmentOfMenu;
import by.epam.dmitriysedin.model.entity.DishOfAssortment;
import by.epam.dmitriysedin.model.entity.Menu;
import by.epam.dmitriysedin.model.entity.SpecificationOfDish;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomMenuParser {

	public List<Menu> getMenuList(String fileName) throws IOException {

        DOMParser parser = new DOMParser();
        
        try {
        parser.parse(fileName);
        } catch( SAXException e) {
        e.printStackTrace();//throw new MyException
        }

        Document document = parser.getDocument();

        Element root = document.getDocumentElement();

        List<Menu> menuList = new ArrayList<>();

        NodeList menuNode = root.getElementsByTagName("menu");

        Menu menu = null;

        for (int i = 0; i < menuNode.getLength(); i++) {

            Element temp = null;

            menu = new Menu();

            Element menuElement = (Element) menuNode.item(i);

            menu.setMenuID(menuElement.getAttribute("id"));
            menu.setMenuCurrency(menuElement.getAttribute("currency"));

            menu.setMenuName(getSingleChild(menuElement, "menu-name").getTextContent().trim());
            if((temp = getSingleChild(menuElement, "menu-annotation")) != null) {
                menu.setMenuAnnotation(temp.getTextContent().trim());
            }

            menu.setAssortments(getAssortmentOfMenuList(menuElement.getElementsByTagName("assortment")));
            menuList.add(menu);
        }
        return menuList;
    }
	

    private static Element getSingleChild(Element element, String childName) {
        return (Element) element.getElementsByTagName(childName).item(0);
    }

    private static List<AssortmentOfMenu> getAssortmentOfMenuList(NodeList list) {

        AssortmentOfMenu assortmentOfMenu = null;
        List<AssortmentOfMenu> assortmentOfMenuList = new ArrayList<>();

        for (int i = 0; i < list.getLength(); i++) {

            Element temp = null;

            assortmentOfMenu = new AssortmentOfMenu();

            Element assortmentElement = (Element) list.item(i);

            assortmentOfMenu.setAssortmentID(assortmentElement.getAttribute("id"));

            assortmentOfMenu.setAssortmentName(getSingleChild(assortmentElement,
                    "assortment-name").getTextContent().trim());
            if((temp = getSingleChild(assortmentElement,"assortment-annotation")) != null){
            assortmentOfMenu.setAssortmentAnnotation(temp.getTextContent().trim());
            }
            assortmentOfMenu.setDishes(getDishOfAssortmentList(assortmentElement.getElementsByTagName("dish")));

            assortmentOfMenuList.add(assortmentOfMenu);
        }
        return assortmentOfMenuList;
    }

    private static List<DishOfAssortment> getDishOfAssortmentList(NodeList list) {

        DishOfAssortment dishOfAssortment = null;
        List<DishOfAssortment> dishOfAssortmentList = new ArrayList<>();

        for (int i = 0; i < list.getLength(); i++) {

            Element temp = null;

            dishOfAssortment = new DishOfAssortment();

            Element dishElement = (Element) list.item(i);

            dishOfAssortment.setDishID(dishElement.getAttribute("id"));
            dishOfAssortment.setDishName(getSingleChild(dishElement,
                    "dish-name").getTextContent().trim());
            if ((temp = getSingleChild(dishElement, "dish-annotation")) != null) {
                dishOfAssortment.setDishAnnotation(temp.getTextContent().trim());
            }
            if ((temp = getSingleChild(dishElement, "dish-extra-description")) != null) {
                dishOfAssortment.setDishAnnotation(temp.getTextContent().trim());
            }
            dishOfAssortment.setSpecificationOfDishes(getSpecificationOfDishList(
                    dishElement.getElementsByTagName("dish-specification")));

            dishOfAssortmentList.add(dishOfAssortment);
        }
        return dishOfAssortmentList;
    }

    private static List<SpecificationOfDish> getSpecificationOfDishList(NodeList list) {

        SpecificationOfDish specificationOfDish = null;

        List<SpecificationOfDish> specificationOfDishList = new ArrayList<>();

        for (int i = 0; i < list.getLength(); i++) {

            specificationOfDish = new SpecificationOfDish();

            Element temp = null;

            Element specificationElement = (Element) list.item(i);

            if((temp = getSingleChild(specificationElement,"dish-description")) != null) {
                specificationOfDish.setDishDescription(temp.getTextContent().trim());
            }
            specificationOfDish.setDishPortion(getSingleChild(specificationElement,
                    "dish-portion").getTextContent().trim());
            specificationOfDish.setDishPrice(getSingleChild(specificationElement,
                    "dish-price").getTextContent().trim());

            specificationOfDishList.add(specificationOfDish);
        }
        return specificationOfDishList;
    }
}
