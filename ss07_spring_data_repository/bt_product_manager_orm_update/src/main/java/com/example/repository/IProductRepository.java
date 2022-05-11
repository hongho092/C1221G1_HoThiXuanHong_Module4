package com.example.repository;

import com.example.model.Category;
import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {

//    Page<Product> findAll(Pageable pageable);
//    Page<Blog> findAllByNameContaining(String name, Pageable pageable);

    Page<Product> findAllByNameContainingAndDetailContaining(String name, String detail, Pageable pageable);

    Page<Product> findAllByNameContainingAndDetailContainingAndCategory_Id(String name, String detail, int category, Pageable pageable);

}
