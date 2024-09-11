package com.javaProject.foodiecli.util;

import com.javaProject.foodiecli.Model.Customer;
import com.javaProject.foodiecli.Model.Dish;
import com.javaProject.foodiecli.Model.Restaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReader {
    private List<Dish> dishesList;

    public List<Dish> readDishesFromCsv() {
        String DISHES_CSV_PATH = "C:\\Users\\ambar\\OneDrive\\Desktop\\my folder\\Java_learnings\\foodie-cli-app-java\\data\\dishes.csv";
        String line;
        List<Dish> dishesList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DISHES_CSV_PATH))) {
            String cvsSplitBy = ",";
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                Dish dish = new Dish();
                dish.setDishId(data[0])
                        .setDishName(data[1])
                        .setDescription(data[2])
                        .setPrice(Double.parseDouble(data[3]));
                dishesList.add(dish);
            }
            this.dishesList = dishesList;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Issues in reading csv file from the path :" + DISHES_CSV_PATH);
            System.exit(0);
        }
        return dishesList;
    }

    public List<Customer> readCustomersFromCsv() {
        String CUSTOMERS_CSV_PATH = "C:\\Users\\ambar\\OneDrive\\Desktop\\my folder\\Java_learnings\\foodie-cli-app-java\\data\\customers.csv";
        String line;
        List<Customer> customersList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CUSTOMERS_CSV_PATH))) {
            String cvsSplitBy = ",";
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                Customer customer = new Customer();
                customer.setCustomerId(data[0])
                        .setCustomerName(data[1])
                        .setEmail(data[2])
                        .setPassword(data[3]);
                customersList.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Issues in reading csv file from the path :" + CUSTOMERS_CSV_PATH);
            System.exit(0);
        }
        return customersList;
    }

    public List<Restaurant> readRestaurantsFromCsv() {
        String RESTAURANTS_CSV_PATH = "C:\\Users\\ambar\\OneDrive\\Desktop\\my folder\\Java_learnings\\foodie-cli-app-java\\data\\restaurants.csv";
        String line;
        List<Restaurant> restaurantsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RESTAURANTS_CSV_PATH))) {
            String cvsSplitBy = ",";
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                Restaurant restaurant = new Restaurant();

                restaurant.setId(data[0])
                        .setName(data[1])
                        .setAddress(data[2])
                        .setMenu(Arrays.asList(data[3].split(":")));
                restaurantsList.add(restaurant);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Issues in reading csv file from the path :" + RESTAURANTS_CSV_PATH);
            System.exit(0);
        }
        return restaurantsList;
    }
}
