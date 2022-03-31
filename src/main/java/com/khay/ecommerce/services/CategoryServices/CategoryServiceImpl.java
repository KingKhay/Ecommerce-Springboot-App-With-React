package com.khay.ecommerce.services.CategoryServices;

import com.khay.ecommerce.domain.Category.Category;
import com.khay.ecommerce.domain.Product.Product;
import com.khay.ecommerce.repository.CategoryRepository;
import com.khay.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository repository;
    private ProductRepository productRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public Category getCategory(int id) {
        return repository.getById(id);
    }

    @Override
    public Category getCategoryByProduct(Product product) {
        return product.getCategory();
    }

    @Override
    public Category deleteCategoryById(int id) {
        Category theCat = repository.findById(id).orElseThrow(RuntimeException::new);
        repository.deleteById(id);
        return  theCat;
    }

    @Override
    public Category saveCategory(Category category) {
        return repository.save(category);
    }
}
