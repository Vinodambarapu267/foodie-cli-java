package com.javaProject.foodiecli.repository;

import com.javaProject.foodiecli.Model.Restaurant;
import com.javaProject.foodiecli.util.CsvReader;

import java.util.List;

public class RestaurantsRepository {
    private List<Restaurant> restaurantList;

    public RestaurantsRepository() {
        CsvReader csvReader = new CsvReader();
        this.restaurantList = csvReader.readRestaurantsFromCsv();
    }

    public List<Restaurant> getRestaurantList(){
        return this.restaurantList;
    }

    public Restaurant save(Restaurant restaurant){ this.restaurantList.add(restaurant); return restaurant; }
}
