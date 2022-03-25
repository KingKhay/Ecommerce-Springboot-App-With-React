package com.khay.ecommerce.services.ProductServices;

import com.khay.ecommerce.models.Product.Product;


public interface ProductService {
     Product saveNewProduct(Product product);

     Product getProduct(int id);

     Iterable<Product> getProducts();

     Product deleteProduct(int id);

     Product updateProduct(Product product);
}
