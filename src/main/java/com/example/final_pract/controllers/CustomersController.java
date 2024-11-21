package com.example.final_pract.controllers;

import com.example.final_pract.models.Customers;
import com.example.final_pract.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CustomersController {

    @Autowired
    private CustomersRepository customersRepository;

    @GetMapping
    public List<Customers> getAllCustomers() {
        return customersRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable Integer id) {
        Optional<Customers> customer = customersRepository.findById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Customers createCustomer(@RequestBody Customers customer) {
        return customersRepository.save(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customers> updateCustomer(@PathVariable Integer id, @RequestBody Customers customerDetails) {
        Optional<Customers> existingCustomer = customersRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customers customer = existingCustomer.get();
            customer.setFirstName(customerDetails.getFirstName());
            customer.setLastName(customerDetails.getLastName());
            customer.setPhoneNumber(customerDetails.getPhoneNumber());
            customer.setEmail(customerDetails.getEmail());
            return ResponseEntity.ok(customersRepository.save(customer));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        Optional<Customers> customer = customersRepository.findById(id);
        if (customer.isPresent()) {
            customersRepository.delete(customer.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

