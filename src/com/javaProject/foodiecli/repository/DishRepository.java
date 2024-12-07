package com.javaProject.foodiecli.repository;

import com.javaProject.foodiecli.Model.Dish;
import com.javaProject.foodiecli.exceptions.DishNotFoundException;
import com.javaProject.foodiecli.util.CsvReader;
import com.javaProject.foodiecli.util.Factory;

import java.util.List;
import java.util.Optional;

public class DishRepository {
    List<Dish> dishList;


    public DishRepository() {
        this.dishList = Factory.getCsvReader().readDishesFromCsv();
    }

    public List<Dish> getDishList() {
        return this.dishList;
    }

    public Dish saveDish(Dish dish) {
        this.dishList.add(dish);
        return dish;
    }

    public Optional<Dish> findDishById(String id) {
        return this.dishList.stream().filter(dish -> dish.getDishId().equals(id)).findFirst();
    }

    public Dish updateDish(Dish dishToBeUpdated) {
        Optional<Dish> dishOptional = this.dishList.stream().filter(dish -> dish.getDishId().equals(dishToBeUpdated.getDishId()))
                .findFirst()
                .map(dish -> {
                    dish.setDishName(dishToBeUpdated.getDishName())
                            .setPrice(dishToBeUpdated.getPrice())
                            .setDescription(dishToBeUpdated.getDescription());
                    return dish;
                });
        return dishOptional.orElse(null);
    }

    public void deleteDish(Dish dish){
        this.dishList.remove(dish);
    }
}
