package com.khay.ecommerce.services.CustomerServices;

import com.khay.ecommerce.models.Customer.Customer;
import com.khay.ecommerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository repository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Iterable<Customer> getCustomers() {
        return repository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer deleteCustomer(int id) {
        Customer customer = repository.getById(id);
        repository.deleteById(id);
        return customer;
    }
}
