package com.javaProject.foodiecli.repository;

import com.javaProject.foodiecli.Model.Customer;
import com.javaProject.foodiecli.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
   private List<Customer> customersList;

    public CustomerRepository() {
        CsvReader csvReader = new CsvReader();
        this.customersList =csvReader.readCustomersFromCsv();
    }

    public List<Customer> getAllCustomers() {
        return this.customersList;
    }

    public Customer save(Customer customer) {
        this.customersList.add(customer);
        return customer;
    }

}
