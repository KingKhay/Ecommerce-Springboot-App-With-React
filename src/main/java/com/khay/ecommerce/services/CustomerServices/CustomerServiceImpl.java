package com.khay.ecommerce.services.CustomerServices;

import com.khay.ecommerce.domain.Customer.Customer;
import com.khay.ecommerce.domain.Customer.Role;
import com.khay.ecommerce.repository.CustomerRepository;
import com.khay.ecommerce.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repository;
    private PasswordEncoder encoder;
    private RoleRepository repository1;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository, PasswordEncoder encoder,RoleRepository repository1) {
        this.repository = repository;
        this.encoder = encoder;
        this.repository1 = repository1;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setPassword(encoder.encode(customer.getPassword()));
        return repository.save(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return repository.findCustomerByUsername(username).get();
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
    public Customer deleteCustomer(String username) {
        Customer theCustomer = repository.findCustomerByUsername(username).get();
        repository.deleteCustomerByUsername(username);
        return theCustomer;
    }

    @Override
    public void addRole(String username, String role) {
        try {
           Customer customer = repository.findCustomerByUsername(username).get();
            Role role1 = repository1.findRoleByName(role);
            customer.getRoles().add(role1);
            repository.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Role saveRole(Role role) {
        return repository1.save(role);
    }

}
