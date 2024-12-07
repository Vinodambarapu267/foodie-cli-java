package com.javaProject.foodiecli.repository;

import com.javaProject.foodiecli.Model.Customer;
import com.javaProject.foodiecli.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    List<Customer> customerList;

    public CustomerRepository(){
        this.customerList= Factory.getCsvReader().readCustomerFromCsv();
    }

    public List<Customer> getCustomerList(){
        return this.customerList;
    }

    public Customer saveCustomer(Customer customer){
        this.customerList.add(customer);
        return customer;
    }
    public Optional<Customer> getCustomerById(String Id){
        return  this.customerList.stream().filter(customer -> customer.getCustomerId().equals(Id)).findFirst();
    }
    public Optional<Customer> getCustomerByEmailAndPassword(String Email,String passWord){
        return  this.customerList.stream().filter(customer -> customer.getEmail().equals(Email) && customer.getPassword().equals(passWord)).findFirst();
    }
    public Customer updateCustomer(Customer customerToBeUpdated){
        Optional<Customer> customerOptional = this.customerList.stream().filter(customer -> customer.getCustomerId().equals(customerToBeUpdated.getCustomerId()))
                .findFirst()
                .map(customer ->
                {
                    customer.setCustomerName(customerToBeUpdated.getCustomerName())
                            .setEmail(customerToBeUpdated.getEmail())
                            .setPassword(customerToBeUpdated.getPassword());
                    return customer;
                });
        return customerOptional.orElse(null);
    }
    public void deleteCustomer(Customer customer){
        this.customerList.remove(customer);
    }

}
