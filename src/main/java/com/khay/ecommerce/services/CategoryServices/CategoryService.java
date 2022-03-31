package com.khay.ecommerce.services.CategoryServices;

import com.khay.ecommerce.domain.Category.Category;
import com.khay.ecommerce.domain.Product.Product;

public interface CategoryService {
    Iterable<Category> getAllCategories();
    Category getCategory(int id);
    Category getCategoryByProduct(Product product);
    Category deleteCategoryById(int id);
    Category saveCategory(Category category);

}
