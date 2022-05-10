package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void remove(Product product);

    void edit(Product product);

//    List<Product> searchByName(String search);
}
