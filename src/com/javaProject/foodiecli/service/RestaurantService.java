package com.javaProject.foodiecli.service;

import com.javaProject.foodiecli.Model.Dish;
import com.javaProject.foodiecli.Model.Restaurant;
import com.javaProject.foodiecli.exceptions.DishNotFoundException;
import com.javaProject.foodiecli.exceptions.RestaurantExistsException;
import com.javaProject.foodiecli.exceptions.RestaurantNotFoundException;

import java.util.List;

public interface RestaurantService {

    public List<Restaurant> getRestaurantList();
    public Restaurant save(Restaurant restaurant) throws RestaurantExistsException;

    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException;

    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException;

    public void deleteRestaurant(String id) throws RestaurantNotFoundException;

    public List<Dish> getDishItems(String id) throws RestaurantNotFoundException, DishNotFoundException;
}
