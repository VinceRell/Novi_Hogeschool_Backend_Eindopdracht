package com.NoviBackend.Autogarage.controllers;

import com.NoviBackend.Autogarage.dto.CustomerDTO;
import com.NoviBackend.Autogarage.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private CustomerService customerService;

    @PostMapping //Adds a customer to DB
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO savedCustomer = customerService.createCustomer(customerDTO);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("{id}") //Retrieves a single customer from DB
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") Long id){
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerDTO);
    }

    @GetMapping //Retrieves all customers from DB
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        List<CustomerDTO> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PutMapping("{id}") //Updates existing customer-data stored in DB
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDTO updatedCustomer){
        CustomerDTO customerDTO = customerService.updateCustomer(id, updatedCustomer);
        return ResponseEntity.ok(customerDTO);
    }

    @DeleteMapping("{id}") //Delete a customer from the DB
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomerById(id);
        return ResponseEntity.ok("Customer has been deleted");
    }
}
