package com.kunu.spring.controller;

import com.kunu.spring.entity.Product;
import com.kunu.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }
    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return productService.getProducts();
    }@GetMapping("/productById/{id}")
    public  Product findProductById(@PathVariable  int id){
        return productService.getProductById(id);
    }
    @GetMapping("/products/{name}")
    public Product findProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
        return productService.deleteProduct(id);
    }
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
}
