package by.epam.dmitriysedin.model.entity;

import java.util.ArrayList;
import java.util.List;

public class DishOfAssortment {

	private String dishID;
    private String dishName;
    private String dishAnnotation;
    private String dishExtraDescription;
    private List<SpecificationOfDish> specificationOfDishes = new ArrayList<>();

    public DishOfAssortment(String dishID, String dishName, String dishAnnotation, String dishExtraDescription,
                            List<SpecificationOfDish> specificationOfDishes) {
        this.dishID = dishID;
        this.dishName = dishName;
        this.dishAnnotation = dishAnnotation;
        this.dishExtraDescription = dishExtraDescription;
        this.specificationOfDishes = specificationOfDishes;
    }

    public DishOfAssortment() {
    }

    public String getDishID() {
        return dishID;
    }

    public void setDishID(String dishID) {
        this.dishID = dishID;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishAnnotation() {
        return dishAnnotation;
    }

    public void setDishAnnotation(String dishAnnotation) {
        this.dishAnnotation = dishAnnotation;
    }

    public String getDishExtraDescription() {
        return dishExtraDescription;
    }

    public void setDishExtraDescription(String dishExtraDescription) {
        this.dishExtraDescription = dishExtraDescription;
    }

    public List<SpecificationOfDish> getSpecificationOfDishes() {
        return specificationOfDishes;
    }

    public void setSpecificationOfDishes(List<SpecificationOfDish> specificationOfDishes) {
        this.specificationOfDishes = specificationOfDishes;
    }

    @Override
    public String toString() {
        return "DishOfAssortment{" +
                "dishID='" + dishID + '\'' +
                ", dishName='" + dishName + '\'' +
                ", dishAnnotation='" + dishAnnotation + '\'' +
                ", dishExtraDescription='" + dishExtraDescription + '\'' + '\n' +
                ", specificationOfDishes=" + specificationOfDishes +
                '}' + '\n';
    }
}
