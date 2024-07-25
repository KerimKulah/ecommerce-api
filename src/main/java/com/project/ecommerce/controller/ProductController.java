package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Product;
import com.project.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return "Product added";
    }

    @DeleteMapping("/delete")
    public String deleteProduct(@RequestBody Product product) {
        productService.deleteProduct(product);
        return "Product deleted";
    }

    @PostMapping("/update")
    public String updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return "Product updated";
    }

}
