package com.javaProject.foodiecli;

import com.javaProject.foodiecli.repository.CustomerRepository;
import com.javaProject.foodiecli.repository.DishRepository;
import com.javaProject.foodiecli.repository.RestaurantsRepository;

public class Main {
    public static void main(String[] args) {
//        CustomerRepository customerRepository = new CustomerRepository();
//        System.out.println(customerRepository.getAllCustomers());
//        DishRepository dishRepository = new DishRepository();
//        System.out.println(dishRepository.getDishList());
        RestaurantsRepository restaurantsRepository = new RestaurantsRepository();
        System.out.println(restaurantsRepository.getRestaurantList());
    }
}
