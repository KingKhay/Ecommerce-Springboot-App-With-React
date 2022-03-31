package com.khay.ecommerce.domain.Category;

import com.khay.ecommerce.domain.Product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    public Category(String name) {
        this.name = name;
    }

    @OneToMany()
    private List<Product> products;
}
