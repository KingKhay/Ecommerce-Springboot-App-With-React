package com.khay.ecommerce.controllers;

import com.khay.ecommerce.models.Customer.Customer;
import com.khay.ecommerce.models.Customer.Role;
import com.khay.ecommerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerResource {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        Customer customer = new Customer();
        model.addAttribute("Customer", customer);
        return "register-page";
    }
//    @PostMapping("/save")
//    public ResponseEntity<Customer> handleRegistration(@RequestBody Customer customer){
//        customer.setPassword(encoder.encode(customer.getPassword()));
//        System.out.println(customer.getPassword());
//        System.out.println(customer.getRole());
////        repository.save(customer);
//        return ResponseEntity.ok().body(customer);

    @PostMapping("/register")
    public String handleRegistration(@ModelAttribute("Customer") Customer customer){
        customer.setRole(Role.ROLE_USER);
        customer.setPassword(encoder.encode(customer.getPassword()));
        repository.save(customer);
        return "index";
    }
    //Method to return the principle
}
