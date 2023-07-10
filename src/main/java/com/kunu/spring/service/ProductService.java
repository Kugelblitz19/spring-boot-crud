package com.kunu.spring.service;

import com.kunu.spring.entity.Product;
import com.kunu.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    public List<Product> saveProducts(List<Product>products){
        return productRepository.saveAll(products);
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Product getProductById(int id){
        return productRepository.findById(id).orElseThrow(null);
    }
    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }
    public String deleteProduct(int id){
         productRepository.deleteById(id);
        return "Product Removed" + id;
    }
    public Product updateProduct(Product product){
        Product existingProduct =productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }
}
