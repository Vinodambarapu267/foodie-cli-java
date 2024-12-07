package com.javaProject.foodiecli.Controller;

import com.javaProject.foodiecli.Model.Customer;
import com.javaProject.foodiecli.exceptions.CustomerExistsException;
import com.javaProject.foodiecli.service.CustomerService;

public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    public Customer save(Customer customer) throws CustomerExistsException {
        return  this.customerService.save(customer);
    }
}
