package by.epam.dmitriysedin.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	private String menuID;
    private String menuCurrency;
    private String menuName;
    private String menuAnnotation;
    private List<AssortmentOfMenu> assortments = new ArrayList<>();

    public Menu(String menuID, String menuCurrency, String menuName, String menuAnnotation,
                List<AssortmentOfMenu> assortments) {
        this.menuID = menuID;
        this.menuCurrency = menuCurrency;
        this.menuName = menuName;
        this.menuAnnotation = menuAnnotation;
        this.assortments = assortments;
    }

    public Menu() {
    }

    public String getMenuID() {
        return menuID;
    }

    public void setMenuID(String menuID) {
        this.menuID = menuID;
    }

    public String getMenuCurrency() {
        return menuCurrency;
    }

    public void setMenuCurrency(String menuCurrency) {
        this.menuCurrency = menuCurrency;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuAnnotation() {
        return menuAnnotation;
    }

    public void setMenuAnnotation(String menuAnnotation) {
        this.menuAnnotation = menuAnnotation;
    }

    public List<AssortmentOfMenu> getAssortments() {
        return assortments;
    }

    public void setAssortments(List<AssortmentOfMenu> assortments) {
        this.assortments = assortments;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuID='" + menuID + '\'' +
                ", menuCurrency='" + menuCurrency + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuAnnotation='" + menuAnnotation + '\'' + '\n' +
                ", assortments=" + assortments +
                '}' + '\n';
    }
}
