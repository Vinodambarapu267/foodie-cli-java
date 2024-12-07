package com.javaProject.foodiecli.service;

import com.javaProject.foodiecli.Model.Dish;
import com.javaProject.foodiecli.exceptions.DishExistsException;
import com.javaProject.foodiecli.exceptions.DishNotFoundException;
import com.javaProject.foodiecli.repository.DishRepository;

import java.util.List;
import java.util.Optional;

public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> getDishesList() {
        return this.dishRepository.getDishList();
    }

    @Override
    public Dish save(Dish dish) throws DishExistsException {
        Optional<Dish> dishById = this.dishRepository.findDishById(dish.getDishId());
        if(dishById.isPresent())
            throw new DishExistsException("Dish Already Exists with this Id  :" + dish.getDishId());
        return this.dishRepository.saveDish(dish);
    }

    @Override
    public Dish getDishById(String id) throws DishNotFoundException {
        Optional<Dish> dishById = this.dishRepository.findDishById(id);
        if(dishById.isEmpty())
            throw new DishNotFoundException("Dish Not Found With This Id  :" + id);
        return dishById.get();
    }

    @Override
    public Dish update(Dish dish) throws DishNotFoundException {
        Optional<Dish> dishById = this.dishRepository.findDishById(dish.getDishId());
        if(dishById.isEmpty())
            throw new DishNotFoundException("Dish Not Found with Id : " + dish.getDishId());
        return this.dishRepository.updateDish(dish);
    }

    @Override
    public void delete(String id) throws DishNotFoundException{
        Optional<Dish> dishById = this.dishRepository.findDishById(id);
        if(dishById.isEmpty())
            throw new DishNotFoundException("Dish Not Found with Id : " + id);
        this.dishRepository.deleteDish(dishById.get());
    }
}
