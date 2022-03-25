package com.khay.ecommerce.repository;

import com.khay.ecommerce.models.Customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
    Optional<Customer> findCustomerByUsername(String username);
}