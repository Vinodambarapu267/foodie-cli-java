package com.javaProject.foodiecli.util;

import com.javaProject.foodiecli.Controller.CustomerController;
import com.javaProject.foodiecli.Controller.DishController;
import com.javaProject.foodiecli.Controller.RestaurantController;
import com.javaProject.foodiecli.repository.CustomerRepository;
import com.javaProject.foodiecli.repository.DishRepository;
import com.javaProject.foodiecli.repository.RestaurantsRepository;
import com.javaProject.foodiecli.service.CustomerServiceImpl;
import com.javaProject.foodiecli.service.DishServiceImpl;
import com.javaProject.foodiecli.service.RestaurantServiceImpl;

public class Factory {
    public static CsvReader getCsvReader() {
        return Holder.CSV_READER;
    }

    public static CustomerRepository getCustomerRepository() {
        return Holder.CUSTOMER_REPOSITORY;
    }

    public static CustomerServiceImpl getCustomerService() {
        return Holder.CUSTOMER_SERVICE;
    }

    public static CustomerController getCustomerController() {
        return Holder.CUSTOMER_CONTROLLER;
    }
    public static DishRepository getDishRepository() {
        return Holder.DISH_REPOSITORY;
    }

    public static DishServiceImpl getDishService() {
        return Holder.DISH_SERVICE;
    }

    public static DishController getDishController() {
        return Holder.DISH_CONTROLLER;
    }

    public static RestaurantsRepository getRestaurantRepository() {
        return Holder.RESTAURANT_REPOSITORY;
    }

    public static RestaurantServiceImpl getRestaurantService() {
        return Holder.RESTAURANT_SERVICE;
    }

    public static RestaurantController getRestaurantController() {
        return Holder.RESTAURANT_CONTROLLER;
    }

    private static class Holder{
        private static final CsvReader CSV_READER = new CsvReader();

        private static final CustomerRepository CUSTOMER_REPOSITORY = new CustomerRepository();
        private static final CustomerServiceImpl CUSTOMER_SERVICE = new CustomerServiceImpl(CUSTOMER_REPOSITORY);
        private static final CustomerController CUSTOMER_CONTROLLER = new CustomerController(CUSTOMER_SERVICE);

        private static final DishRepository DISH_REPOSITORY = new DishRepository();
        private static final DishServiceImpl DISH_SERVICE = new DishServiceImpl(DISH_REPOSITORY);
        private static final DishController DISH_CONTROLLER = new DishController(DISH_SERVICE);

        private static final RestaurantsRepository RESTAURANT_REPOSITORY = new RestaurantsRepository();
        private static final RestaurantServiceImpl RESTAURANT_SERVICE = new RestaurantServiceImpl(RESTAURANT_REPOSITORY);
        private static final RestaurantController RESTAURANT_CONTROLLER = new RestaurantController(RESTAURANT_SERVICE);


    }

}
