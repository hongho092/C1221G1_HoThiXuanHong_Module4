package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void remove(int id);

    void edit(int id, Product product);

    List<Product> searchByName(String search);
}
