package com.javaProject.foodiecli.Model;

import java.util.List;
import java.util.Objects;

public class Restaurant {
/*
    add the following properties
    --------------------------------------
    Datatype                  variable
    --------------------------------------
    String                      resturantId
    String                      name
    String                      address
    List<Dish>                  menu
     */

    /*
    1. All the fields should be private
    2. Create only no-arg constructor
    3. Create Getters and Setter methods
    4. Override hashCode() and equals() methods
    5. Override toString() methods
     */

    private String resturantId;
    private String name;
    private String address;
    public List<String> menu;

    // Getter for restaurantId
    public String getResturantId() {
        return resturantId;
    }

    // Setter for restaurantId
    public Restaurant setResturantId(String resturantId) {
        this.resturantId = resturantId;
        return this;
    }

    // Getter for name
    public String getResturantName() {
        return name;
    }

    // Setter for name
    public Restaurant setResturantName(String name) {
        this.name = name;
        return this;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public Restaurant setAddress(String address) {
        this.address = address;
        return this;
    }

    // Getter for menu
    public List<String> getMenu() {
        return this.menu;
    }

    // Setter for menu
    public void setMenu(List<String> menu) {
        this.menu = menu;
    }



    // Overriding hashCode
    @Override
    public int hashCode() {
        return Objects.hash(resturantId, name, address, menu);
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
        Restaurant restaurant = (Restaurant) obj;
        return Objects.equals(resturantId, restaurant.resturantId) &&
                Objects.equals(name, restaurant.name) &&
                Objects.equals(address, restaurant.address) &&
                Objects.equals(menu, restaurant.menu);
    }

    // Overriding toString
    @Override
    public String toString() {
        return "Restaurant{" +
                "resturantId='" + resturantId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", menu=" + menu +
                '}';
    }
}

