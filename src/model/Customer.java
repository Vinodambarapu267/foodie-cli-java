package model;

import java.util.Objects;

public class Customer {
    private String customerId;
    private String customerName;
    private String email;
    private String password;

    public Customer() {
    }

    // Getter for customerId
    public String getCustomerId() {
        return customerId;
    }

    // Setter for customerId
    public Customer setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    // Getter for customerName
    public String getCustomerName() {
        return customerName;
    }

    // Setter for customerName
    public Customer setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public Customer setPassword(String password) {
        this.password = password;
        return this;
    }

    public int hashCode() {
        return Objects.hash(customerId, customerName, email, password);
    }

    // Overriding equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Customer customer = (Customer) obj;
        return Objects.equals(customerId, customer.customerId) &&
                Objects.equals(customerName, customer.customerName) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(password, customer.password);
    }

    // Overriding toString
    @Override
    public String toString() {
        return "Customer{" +
                " customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
