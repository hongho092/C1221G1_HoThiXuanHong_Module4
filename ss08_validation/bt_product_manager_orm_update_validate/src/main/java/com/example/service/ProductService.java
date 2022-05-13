package com.example.service;

import com.example.model.Category;
import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void edit(Product product) {
        productRepository.save(product);
    }

    @Override
    public Page<Product> findAll1(String searchName, String searchDetail, Pageable pageable) {
        return productRepository.findAllByNameContainingAndDetailContaining(searchName, searchDetail, pageable);
    }

    @Override
    public Page<Product> findAll2(String searchName, String searchDetail, int searchCategory, Pageable pageable) {
        return productRepository.findAllByNameContainingAndDetailContainingAndCategory_Id(searchName, searchDetail, searchCategory, pageable);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
