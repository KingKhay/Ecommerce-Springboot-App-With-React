package com.khay.ecommerce.repository;

import com.khay.ecommerce.domain.Category.Category;
import com.khay.ecommerce.domain.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findCategoryByProducts(Product product);
}
