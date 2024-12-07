package com.javaProject.foodiecli.service;

import com.javaProject.foodiecli.Model.Order;
import com.javaProject.foodiecli.exceptions.OrderExistsException;
import com.javaProject.foodiecli.exceptions.OrderNotFoundException;

import java.util.List;

public interface OrderService {
    public List<Order> getOrdersList();
    public Order getOrderById(String id) throws OrderNotFoundException;
    public Order save(Order order) throws OrderExistsException;


}