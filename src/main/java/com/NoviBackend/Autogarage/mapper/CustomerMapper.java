package com.NoviBackend.Autogarage.mapper;

import com.NoviBackend.Autogarage.dto.CustomerDTO;
import com.NoviBackend.Autogarage.models.Customer;

public class CustomerMapper {

    public static CustomerDTO mapToCustomerDTO(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhoneNumber()
        );
    }

    public static Customer mapToCustomer(CustomerDTO customerDTO) {
        return new Customer(
                customerDTO.getId(),
                customerDTO.getFirstName(),
                customerDTO.getLastName(),
                customerDTO.getPhoneNumber()
        );
    }

}
