package com.javaProject.foodiecli.service;

import com.javaProject.foodiecli.Model.Dish;
import com.javaProject.foodiecli.exceptions.DishExistsException;
import com.javaProject.foodiecli.exceptions.DishNotFoundException;

import java.util.List;

public interface DishService {
    public List<Dish> getDishesList();

    public Dish save(Dish dish) throws DishExistsException;
    public Dish getDishById(String id) throws DishNotFoundException;
    public Dish update(Dish dish) throws DishNotFoundException;

    public void delete(String id) throws DishNotFoundException;
}