package com.project.ecommerce.service;

import com.project.ecommerce.entity.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomer(Long id);
}
