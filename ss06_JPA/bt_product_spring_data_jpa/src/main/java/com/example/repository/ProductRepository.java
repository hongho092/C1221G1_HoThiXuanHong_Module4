package com.example.repository;

import com.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
//    List<Product> findAll();
//
//    void save(Product product);
//
//    Product findById(int id);
//
//    void update(int id, Product product);
//
//    void remove(Product product);
//
//    List<Product> searchByName(String search);
}
