package com.project.ecommerce.service;

import com.project.ecommerce.entity.Product;
import java.util.List;

public interface ProductService
{
    void createProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Product product);
    List<Product> getAllProducts();
    Product getProduct(Long id);
}
