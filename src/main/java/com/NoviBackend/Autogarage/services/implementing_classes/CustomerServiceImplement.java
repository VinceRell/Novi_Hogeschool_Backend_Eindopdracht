package com.NoviBackend.Autogarage.services.implementing_classes;

import com.NoviBackend.Autogarage.dto.CustomerDTO;
import com.NoviBackend.Autogarage.exception.ResourceNotFoundException;
import com.NoviBackend.Autogarage.mapper.CustomerMapper;
import com.NoviBackend.Autogarage.models.Customer;
import com.NoviBackend.Autogarage.repositories.CustomerRepository;
import com.NoviBackend.Autogarage.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImplement implements CustomerService {

    private CustomerRepository customerRepository;

    @Override //Method to add a customer
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDTO(savedCustomer);
    }

    @Override //Method to get a singular customer by id
    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The customer with id:" + id + ", does not exist"));

        return CustomerMapper.mapToCustomerDTO(customer);
    }

    @Override //Method to get all customers
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map((customer) ->CustomerMapper.mapToCustomerDTO(customer)).collect(Collectors.toList());
    }

    @Override //Method to update a single customer
    public CustomerDTO updateCustomer(Long id, CustomerDTO updatedCustomer) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The customer with id: " + id + ", does not exist"));

        customer.setFirstName(updatedCustomer.getFirstName());
        customer.setLastName(updatedCustomer.getLastName());
        customer.setPhoneNumber(updatedCustomer.getPhoneNumber());

        Customer updatedCustomerOBJ = customerRepository.save(customer);

        return CustomerMapper.mapToCustomerDTO(updatedCustomerOBJ);
    }

    @Override //Method to delete a customer
    public void deleteCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The customer with id: " + id + ", does not exist"));

        customerRepository.deleteById(id);
    }
}
