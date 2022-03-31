package com.khay.ecommerce.services.CustomerServices;

import com.khay.ecommerce.domain.Customer.Customer;
import com.khay.ecommerce.domain.Customer.Role;

public interface CustomerService {
    Customer saveCustomer(Customer customer);

    Customer getCustomer(int id);

    Customer getCustomerByUsername(String username);

    Iterable<Customer> getCustomers();

    Customer updateCustomer(Customer customer);

    Customer deleteCustomer(String username);


    void addRole(String username, String role);

    Role saveRole(Role role);

}
