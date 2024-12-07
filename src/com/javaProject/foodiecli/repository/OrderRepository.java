package com.javaProject.foodiecli.repository;

import com.javaProject.foodiecli.Model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository {
    private List<Order> orderList;

    public OrderRepository() {
        this.orderList = new ArrayList<>();
    }

    public Order save(Order order){
        this.orderList.add(order);
        return order;
    }

    public List<Order> getOrderList(){
        return this.orderList;
    }

    public Optional<Order> findOrderById(String id){
        return this.orderList.stream().filter(order -> order.getOrderid().equals(id)).findFirst();
    }
}
