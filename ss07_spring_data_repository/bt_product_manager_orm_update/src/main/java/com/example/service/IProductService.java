package com.example.service;

import com.example.model.Category;
import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
//    Page<Product> findAll(Pageable pageable);

    void save(Product product);

    Product findById(int id);

    void remove(Product product);

    void edit(Product product);

    Page<Product> findAll1(String searchName, String searchDetail, Pageable pageable);

//    Page<Product> findAll2(String searchName, String searchDetail, int searchCategory, Pageable pageable);

    Page<Product> findAll2(String searchName, String searchDetail, int searchCategory, Pageable pageable);
}
