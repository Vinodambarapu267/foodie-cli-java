package com.javaProject.foodiecli.repository;

import com.javaProject.foodiecli.Model.Dish;
import com.javaProject.foodiecli.util.CsvReader;

import java.util.List;
import java.util.Optional;

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
    public Dish updateDish(Dish dishToBeUpdated) throws DishNotFoundException{
        Optional<Dish> optionalDish = this.dishList.stream().filter(dish -> dish.getDishId().equals(dishToBeUpdated.getDishId()))
                .findFirst()
                .map(Dish -> {
                    Dish.setDishName(dishToBeUpdated.getDishName())
                            .setDescription(dishToBeUpdated.getDescription())
                            .setPrice(dishToBeUpdated.getPrice());
                    return Dish;
                });
        return optionalDish.orElse(null);
    }
    public void deleteDish(Dish dish){
        this.dishList.remove(dish);
    }
}
