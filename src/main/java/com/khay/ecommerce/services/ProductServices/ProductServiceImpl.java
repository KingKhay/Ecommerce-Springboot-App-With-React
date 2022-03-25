package com.khay.ecommerce.services.ProductServices;

import com.khay.ecommerce.models.Product.Product;
import com.khay.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    private ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product saveNewProduct(Product product){
        return repository.save(product);
    }

    @Override
    public Product getProduct(int id) {
        return repository.getById(id);
    }

    @Override
    public Iterable<Product> getProducts() {
        return repository.findAll();
    }

    @Override
    public Product deleteProduct(int id) {
        Product product = repository.getById(id);
        repository.deleteById(id);
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        return repository.save(product);
    }
}
