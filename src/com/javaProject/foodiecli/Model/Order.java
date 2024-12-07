package com.javaProject.foodiecli.Model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Order {
 /*
    add the following properties
    --------------------------------------
    Datatype                  variable
    --------------------------------------
    String                      orderid
    Customer                    customer
    Restaurant                  restaurant
    List<Dish>                  dishes
    double                      price
     */

    /*
    1. All the fields should be private
    2. Create only no-arg constructor
    3. Create Getters and Setter methods
    4. Override hashCode() and equals() methods
    5. Override toString() methods
     */

    private String orderid;
    private Customer customer;
    private Restaurant restaurant;
    private List<Dish> dishList;
    private double totalPrice;
    private LocalDate orderDate;

    // Constructor

    public Order() {
    }

    public String getOrderid() {
        return orderid;
    }

    public Order setOrderid(String orderid) {
        this.orderid = orderid;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Order setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public Order setDishList(List<Dish> dishList) {
        this.dishList = dishList;
        return this;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Order setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Order setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(totalPrice, order.totalPrice) == 0 && Objects.equals(orderid, order.orderid) && Objects.equals(customer, order.customer) && Objects.equals(restaurant, order.restaurant) && Objects.equals(dishList, order.dishList) && Objects.equals(orderDate, order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderid, customer, restaurant, dishList, totalPrice, orderDate);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid='" + orderid + '\'' +
                ", customer=" + customer +
                ", restaurant=" + restaurant +
                ", dishList=" + dishList +
                ", totalPrice=" + totalPrice +
                ", orderDate=" + orderDate +
                '}';
    }
}