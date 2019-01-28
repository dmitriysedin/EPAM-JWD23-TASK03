package by.epam.dmitriysedin.model.entity;

public class SpecificationOfDish {

	private String dishDescription;
    private String dishPortion;
    private String dishPrice;

    public SpecificationOfDish(String dishDescription, String dishPortion, String dishPrice) {
        this.dishDescription = dishDescription;
        this.dishPortion = dishPortion;
        this.dishPrice = dishPrice;
    }

    public SpecificationOfDish() {
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    public String getDishPortion() {
        return dishPortion;
    }

    public void setDishPortion(String dishPortion) {
        this.dishPortion = dishPortion;
    }

    public String getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(String dishPrice) {
        this.dishPrice = dishPrice;
    }

    @Override
    public String toString() {
        return "SpecificationOfDish{" +
                "dishDescription='" + dishDescription + '\'' +
                ", dishPortion='" + dishPortion + '\'' +
                ", dishPrice='" + dishPrice + '\'' +
                '}' + '\n';
    }
}
