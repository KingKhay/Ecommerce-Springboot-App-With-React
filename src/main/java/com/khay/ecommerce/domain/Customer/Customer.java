package com.khay.ecommerce.domain.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.FetchType.EAGER;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @NonNull
    private String username;

    private String firstName;

    private String lastName;

    @NonNull
    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @ManyToMany(fetch = EAGER)
    private List<Role> roles;

    private String address;

    private String email;

    private String phone;

    private String country;
}
