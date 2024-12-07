package com.javaProject.foodiecli.repository;

import com.javaProject.foodiecli.Model.Dish;
import com.javaProject.foodiecli.util.CsvReader;

import java.util.List;

public class DishRepository {
    List<Dish> dishList;

    public DishRepository() {
        CsvReader csvReader = new CsvReader();
        this.dishList = csvReader.readDishesFromCsv();
    }

    public List<Dish> getDishList() {
        return this.dishList;
    }

    public Dish saveDish(Dish dish) {
        this.dishList.add(dish);
        return dish;
    }
}
