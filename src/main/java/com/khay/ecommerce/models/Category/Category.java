package com.khay.ecommerce.models.Category;

import com.khay.ecommerce.models.Product.Product;
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

    @Column(unique = true,nullable = false)
    private String name;

    public Category(String name) {
        this.name = name;
    }

    @OneToMany()
    private List<Product> products;
}
