package org.example.spring_training_ground.service;

import org.example.spring_training_ground.model.Product;

import java.util.List;

public interface ProductService {
    public Product geProductById(long id);
    public List<Product> getProducts();
}
