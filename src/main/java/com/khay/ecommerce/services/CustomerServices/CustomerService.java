package com.khay.ecommerce.services.CustomerServices;

import com.khay.ecommerce.models.Customer.Customer;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    Customer getCustomer(int id);
    Iterable<Customer> getCustomers();
    Customer updateCustomer(Customer customer);
    Customer deleteCustomer(int id);

}
