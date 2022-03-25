package com.khay.ecommerce.models.Customer;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties("role")
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
}
