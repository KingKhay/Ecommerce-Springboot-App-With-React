package com.khay.ecommerce.services.CustomerServices;

import com.khay.ecommerce.models.Customer.Customer;
import com.khay.ecommerce.models.Customer.CustomerUserDetails;
import com.khay.ecommerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private CustomerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> customer = repository.findCustomerByUsername(username);
        return customer.map(CustomerUserDetails::new).get();
    }
}
