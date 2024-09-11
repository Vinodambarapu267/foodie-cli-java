package model;

import java.util.Objects;

public class Dish {
 /*
    add the following properties
    --------------------------------------
    Datatype                  variable
    --------------------------------------
    String                      dishId
    String                      dishName
    String                      description
    double                      price
     */

    /*
    1. All the fields should be private
    2. Create only no-arg constructor
    3. Create Getters and Setter methods
    4. Override hashCode() and equals() methods
    5. Override toString() methods
     */

    private String dishId;
    private String dishName;
    private String description;
    private double price;

    public Dish() {
    }

    // Getter for dishId
    public String getDishId() {
        return dishId;
    }

    // Setter for dishId
    public Dish setDishId(String dishId) {
        this.dishId = dishId;
        return this;
    }

    // Getter for dishName
    public String getDishName() {
        return dishName;
    }

    // Setter for dishName
    public Dish setDishName(String dishName) {
        this.dishName = dishName;
        return this;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public Dish setDescription(String description) {
        this.description = description;
        return this;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Setter for price
    public Dish setPrice(double price) {
        this.price = price;
        return this;
    }

    // Overriding hashCode
    @Override
    public int hashCode() {
        return Objects.hash(dishId, dishName, description, price);
    }

    // Overriding equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Dish dish = (Dish) obj;
        return Double.compare(dish.price, price) == 0 &&
                Objects.equals(dishId, dish.dishId) &&
                Objects.equals(dishName, dish.dishName) &&
                Objects.equals(description, dish.description);
    }

    // Overriding toString
    @Override
    public String toString() {
        return "Dish{" +
                " dishId='" + dishId + '\'' +
                ", dishName='" + dishName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
