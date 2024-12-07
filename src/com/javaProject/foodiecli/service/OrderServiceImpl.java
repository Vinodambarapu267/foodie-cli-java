package com.javaProject.foodiecli.service;

import com.javaProject.foodiecli.Model.Order;
import com.javaProject.foodiecli.exceptions.OrderExistsException;
import com.javaProject.foodiecli.exceptions.OrderNotFoundException;
import com.javaProject.foodiecli.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getOrdersList() {
        return this.orderRepository.getOrderList();
    }

    @Override
    public Order getOrderById(String id) throws OrderNotFoundException {
        Optional<Order> orderById = this.orderRepository.findOrderById(id);
        if(orderById.isEmpty())
            throw new OrderNotFoundException("Order Not Found with Id : " + id);
        return orderById.get();
    }

    @Override
    public Order save(Order order) throws OrderExistsException {
        Optional<Order> orderById = this.orderRepository.findOrderById(order.getOrderid());
        if(orderById.isPresent())
            throw new OrderExistsException("Order Already Exists with this Id : " + order.getOrderid());
        return this.orderRepository.save(order);
    }
}
