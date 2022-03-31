package com.khay.ecommerce.controllers;

import com.khay.ecommerce.domain.Customer.Customer;
import com.khay.ecommerce.domain.Customer.RoleWithCustomer;
import com.khay.ecommerce.services.CustomerServices.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


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

    @GetMapping("/customer/{username}")
    public Customer getCustomer(@PathVariable String username) {
        return service.getCustomerByUsername(username);
    }


    @GetMapping("/customer")
    public Iterable<Customer> getAllCustomers(){
        return service.getCustomers();
    }

    @PostMapping("/customer/register")
    public ResponseEntity<Customer> saveNewCustomer(@RequestParam("username")String username,
                                                    @RequestParam("firstName")String firstName,
                                                    @RequestParam("lastName")String lastName,
                                                    @RequestParam("password")String password,
                                                    @RequestParam("dob")String dob,
                                                    @RequestParam("address")String address,
                                                    @RequestParam("email")String email,
                                                    @RequestParam("phone")String phone,
                                                    @RequestParam("country")String country){
        Customer customer = new Customer(username,firstName,lastName,password,LocalDate.parse(dob),null,address,email,phone,country);
        service.saveCustomer(customer);
        return ResponseEntity.ok().body(customer);
    }

    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer customer){
        return  service.updateCustomer(customer);
    }


    @DeleteMapping("/customer/{username}")
    public Customer deleteCustomer(@PathVariable String username){
        return service.deleteCustomer(username);
    }

    @PostMapping("/customer/addRole")
    public Customer addRoleToUser(@RequestBody RoleWithCustomer roleWithCustomer){
         service.addRole(roleWithCustomer.getUsername(),roleWithCustomer.getRole());
        return service.getCustomerByUsername(roleWithCustomer.getUsername());
    }
}
