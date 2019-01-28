package by.epam.dmitriysedin.model.entity;

import java.util.ArrayList;
import java.util.List;

public class AssortmentOfMenu {

	private String assortmentID;
    private String assortmentName;
    private String assortmentAnnotation;
    private List<DishOfAssortment> dishes = new ArrayList<>();

    public AssortmentOfMenu(String assortmentID, String assortmentName, String assortmentAnnotation,
                            List<DishOfAssortment> dishes) {
        this.assortmentID = assortmentID;
        this.assortmentName = assortmentName;
        this.assortmentAnnotation = assortmentAnnotation;
        this.dishes = dishes;
    }

    public AssortmentOfMenu() {
    }

    public String getAssortmentID() {
        return assortmentID;
    }

    public void setAssortmentID(String assortmentID) {
        this.assortmentID = assortmentID;
    }

    public String getAssortmentName() {
        return assortmentName;
    }

    public void setAssortmentName(String assortmentName) {
        this.assortmentName = assortmentName;
    }

    public String getAssortmentAnnotation() {
        return assortmentAnnotation;
    }

    public void setAssortmentAnnotation(String assortmentAnnotation) {
        this.assortmentAnnotation = assortmentAnnotation;
    }

    public List<DishOfAssortment> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishOfAssortment> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "AssortmentOfMenu{" +
                "assortmentID='" + assortmentID + '\'' +
                ", assortmentName='" + assortmentName + '\'' +
                ", assortmentAnnotation='" + assortmentAnnotation + '\'' + '\n' +
                ", dishes=" + dishes +
                '}' + '\n';
    }
}
