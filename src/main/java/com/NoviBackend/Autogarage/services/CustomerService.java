package com.NoviBackend.Autogarage.services;

import com.NoviBackend.Autogarage.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    //Service for creating a customer
    CustomerDTO createCustomer(CustomerDTO customerDTO);

    //Service for getting a single customer
    CustomerDTO getCustomerById(Long id);

    //Service for getting all customers
    List<CustomerDTO> getAllCustomers();

    //Service to update a customer
    CustomerDTO updateCustomer(Long id, CustomerDTO updatedCustomer);

    //Service to delete a customer
    void deleteCustomerById(Long id);
}
