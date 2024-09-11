package com.javaProject.foodiecli.service;

import com.javaProject.foodiecli.Model.Customer;
import com.javaProject.foodiecli.exceptions.CustomerExistsException;

public interface CustomerService {
    public Customer save(Customer customer) throws CustomerExistsException;

}
