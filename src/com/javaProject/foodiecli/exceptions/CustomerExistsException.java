package com.javaProject.foodiecli.exceptions;

public class CustomerExistsException  extends Exception{
    public CustomerExistsException(String message) {
        super(message);
    }
}
