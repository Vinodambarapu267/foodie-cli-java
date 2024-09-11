package com.javaProject.foodiecli.service;

import com.javaProject.foodiecli.Model.Customer;
import com.javaProject.foodiecli.exceptions.CustomerExistsException;
import com.javaProject.foodiecli.repository.CustomerRepository;

import java.util.Optional;

public class CustomerServiceimpl implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceimpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) throws CustomerExistsException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getCustomerId());
        if (customerById.isPresent())
        throw new CustomerExistsException("CUSTOMER IS ALREADY EXISTS WITH THIS ID :" + customer.getCustomerId());
        return this.customerRepository.save(customer);
    }
}
