package com.khay.ecommerce.controllers;

import com.khay.ecommerce.models.Customer.Customer;
import com.khay.ecommerce.models.Customer.Role;
import com.khay.ecommerce.services.CustomerServices.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CustomerResource {

    private CustomerService service;
    private PasswordEncoder encoder;

    @Autowired
    public CustomerResource(CustomerService service, PasswordEncoder encoder) {
        this.service = service;
        this.encoder = encoder;
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return service.getCustomer(id);
    }

    @GetMapping("/customer")
    public Iterable<Customer> getAllCustomers(){
        return service.getCustomers();
    }

    @PostMapping("/customer")
    public Customer saveNewCustomer(@RequestBody Customer customer){
        customer.setRole(Role.ROLE_USER);
        customer.setPassword(encoder.encode(customer.getPassword()));
        return service.saveCustomer(customer);
    }
    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer customer){
        customer.setRole(Role.ROLE_USER);
        return  service.updateCustomer(customer);
    }
    @DeleteMapping("/customer/{id}")
    public Customer deleteCustomer(@PathVariable int id){
        return service.deleteCustomer(id);
    }
}
