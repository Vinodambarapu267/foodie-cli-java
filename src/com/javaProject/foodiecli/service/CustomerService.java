package com.javaProject.foodiecli.service;

import com.javaProject.foodiecli.Model.Customer;
import com.javaProject.foodiecli.exceptions.CustomerExistsException;
import com.javaProject.foodiecli.exceptions.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    public Customer save(Customer customer) throws CustomerExistsException;
    public List<Customer> getAllCustomers();

    public Customer getCustomerById(String id) throws CustomerNotFoundException;

    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;

    public void deleteCustomer(String id) throws CustomerNotFoundException;

    public Customer validateCustomerLogin(String email, String password) throws CustomerNotFoundException;

    public void setCurrentLoggedInCustomer(Customer customer);
    public Customer getCurrentLoggedInCustomer();
}
