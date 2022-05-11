package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    void save(Product product);

    Product findById(int id);

    void remove(Product product);

    void edit(Product product);
}
