package com.javaProject.foodiecli.util;

import com.javaProject.foodiecli.Controller.CustomerController;
import com.javaProject.foodiecli.repository.CustomerRepository;
import com.javaProject.foodiecli.service.CustomerServiceimpl;

public class Factory {
    public  static CustomerRepository getCustomerRepository(){
        return new CustomerRepository();
    }
    public static CustomerServiceimpl getCustomerService(){
        return  new CustomerServiceimpl(getCustomerRepository());
    }
    public static CustomerController getCustomerController(){
        return  new CustomerController(getCustomerService());
    }
}
