package com.khay.ecommerce.models.Customer;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



public class CustomerUserDetails extends Customer implements UserDetails {

    private final String username;
    private final String password;
    private final List<GrantedAuthority> authorities;


    public CustomerUserDetails(Customer customer){
        this.username = customer.getUsername();
        this.password = customer.getPassword();
        SimpleGrantedAuthority role = new SimpleGrantedAuthority(customer.getRole().name());
        List<GrantedAuthority> listOfAuthorities = new ArrayList<>();
        listOfAuthorities.add(role);
        this.authorities = listOfAuthorities;
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
