package com.javaProject.foodiecli.service;

import com.javaProject.foodiecli.Model.Dish;
import com.javaProject.foodiecli.Model.Restaurant;
import com.javaProject.foodiecli.exceptions.DishNotFoundException;
import com.javaProject.foodiecli.exceptions.RestaurantExistsException;
import com.javaProject.foodiecli.exceptions.RestaurantNotFoundException;
import com.javaProject.foodiecli.repository.RestaurantsRepository;
import com.javaProject.foodiecli.util.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantsRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantsRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getRestaurantList() {
        return this.restaurantRepository.getRestaurantList();
    }

    @Override
    public Restaurant save(Restaurant restaurant) throws RestaurantExistsException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(restaurant.getResturantId());
        if(restaurantById.isPresent())
            throw new RestaurantExistsException("Restaurant Already Exists with this Id  :" + restaurant.getResturantId());
        return this.restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(id);
        if(restaurantById.isEmpty())
            throw new RestaurantNotFoundException("Restaurant Not Found with this Id  :" + id);
        return restaurantById.get();

    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(restaurant.getResturantId());
        if(restaurantById.isEmpty())
            throw new RestaurantNotFoundException("Restaurant Not Found with this Id  :" + restaurant.getResturantId());
        return this.restaurantRepository.updateRestaurant(restaurantById.get());
    }


    @Override
    public void deleteRestaurant(String id) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(id);
        if(restaurantById.isEmpty())
            throw new RestaurantNotFoundException("Restaurant Not Found with this Id  :" + id);
        this.restaurantRepository.deleteRestaurant(restaurantById.get());
    }

    @Override
    public List<Dish> getDishItems(String id) throws RestaurantNotFoundException, DishNotFoundException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(id);
        if(restaurantById.isEmpty())
            throw new RestaurantNotFoundException("Restaurant Not Found with this Id  :" + id);
        List<Dish> dishList = new ArrayList<>();
        Restaurant restaurant = restaurantById.get();
        List<String> dishIds = restaurant.getMenu();
        DishService dishService = Factory.getDishService();
        for(String dishId : dishIds){
            Dish dish = dishService.getDishById(dishId);
            dishList.add(dish);
        }
        return dishList;
    }


}
