package com.khay.ecommerce.controllers;

import com.khay.ecommerce.domain.Category.Category;
import com.khay.ecommerce.domain.Product.Product;
import com.khay.ecommerce.domain.Product.ProductImage;
import com.khay.ecommerce.services.CategoryServices.CategoryService;
import com.khay.ecommerce.services.ProductServices.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1")
public class ProductResource {

    private ProductService service;
    private CategoryService categoryService;

    @Autowired
    public ProductResource(ProductService service,CategoryService categoryService) {
        this.categoryService = categoryService;
        this.service = service;
    }

    @CrossOrigin
    @GetMapping("/product")
    public Iterable<Product> getAllProducts(){
        return service.getProducts();
    }


    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id){
        return service.getProduct(id);
    }


    @PostMapping("/product")
    public Product saveNewProduct(@RequestParam("name")String name,
                                  @RequestParam("quantity") int quantity,
                                  @RequestParam("description") String description,
                                  @RequestParam("price") double price,
                                  @RequestParam("category") String cate,
                                  @RequestParam("file")MultipartFile file){
        ProductImage image = new ProductImage();
        try {
            image.setImageData(file.getBytes());
            image.setImageName(file.getOriginalFilename());
            image.setCreatedAt(LocalDate.now());
            image.setImageType(file.getContentType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Category category = new Category(cate);
        categoryService.saveCategory(category);
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCategory(category);
        product.setImageContent(image);
        return service.saveNewProduct(product);
    }

    @DeleteMapping("/product/{id}")
    public Product deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }
}
