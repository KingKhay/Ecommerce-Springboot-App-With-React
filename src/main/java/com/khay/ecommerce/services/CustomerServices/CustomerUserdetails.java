package com.khay.ecommerce.services.CustomerServices;

import com.khay.ecommerce.domain.Customer.Customer;
import com.khay.ecommerce.domain.Customer.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerUserdetails implements UserDetails{

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public CustomerUserdetails(Customer customer) {
        this.username = customer.getUsername();
        this.password = customer.getPassword();
        List<String> roles = customer.getRoles().stream().map(Role::getName).collect(Collectors.toList());
        this.authorities = roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
