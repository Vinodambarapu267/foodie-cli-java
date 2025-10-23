package com.javaProject.foodiecli.repository;

import com.javaProject.foodiecli.Model.Restaurant;
import com.javaProject.foodiecli.util.Factory;

import java.util.List;
import java.util.Optional;

public class RestaurantsRepository {
   private final List<Restaurant> restaurantList;

    public RestaurantsRepository() {
        this.restaurantList = Factory.getCsvReader().readRestaurantsFromCsv();
    }

    public List<Restaurant> getRestaurantList(){
        return this.restaurantList;
    }

    public Restaurant save(Restaurant restaurant){ this.restaurantList.add(restaurant); return restaurant; }

    public Optional<Restaurant> findRestaurantById(String id) {
        return this.restaurantList.stream().filter(restaurant -> restaurant.getResturantId().equals(id)).findFirst();
    }

    public Restaurant updateRestaurant(Restaurant restaurantToBeUpdated){
        Optional<Restaurant> restaurantOptional = this.restaurantList.stream().filter(restaurant -> restaurant.getResturantId().equals(restaurantToBeUpdated.getResturantId()))
                .findFirst()
                .map(restaurant -> {
                    restaurant
                            .setResturantName(restaurantToBeUpdated.getResturantName())
                            .setAddress(restaurantToBeUpdated.getAddress())
                            .setMenu(restaurantToBeUpdated.getMenu());
                    return restaurant;
                });
        return restaurantOptional.orElse(null);
    }
    public void deleteRestaurant(Restaurant restaurant){
        this.restaurantList.remove(restaurant);
    }
}
