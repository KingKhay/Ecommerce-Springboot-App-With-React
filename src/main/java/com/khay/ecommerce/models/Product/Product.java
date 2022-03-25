package com.khay.ecommerce.models.Product;

import com.khay.ecommerce.models.Category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;
    private String description;
    private Double price;

    @ManyToOne
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    private ProductImage imageContent;
}
