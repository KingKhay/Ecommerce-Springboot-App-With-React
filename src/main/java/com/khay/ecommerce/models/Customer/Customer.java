package com.khay.ecommerce.models.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String username;
    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;


    @Enumerated(EnumType.STRING)
    private Role role;

    private String address;

    private String email;

    private String phone;

    private String country;

    public Customer(String firstName, String lastName, String username,
                    String password, LocalDate dob, Role role, String address, String email, String phone, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.role = role;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.country = country;
    }
}
