package com.example.artere.controller;

import com.example.artere.model.Product;
import com.example.artere.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/{productId}/category/{categoryId}")
    public Product linkProductToCategory(@PathVariable Long productId, @PathVariable Long categoryId) {
        return productService.linkProductToCategory(productId, categoryId);
    }

    @PutMapping("/{productId}/remove-category")
    public Product unlinkProductToCategory(@PathVariable Long productId) {
        return productService.unlinkProductToCategory(productId);
    }
}
