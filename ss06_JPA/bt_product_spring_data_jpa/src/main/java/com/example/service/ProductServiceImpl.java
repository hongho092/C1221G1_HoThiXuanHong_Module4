package com.example.service;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

//    private final ProductRepository productRepository;
//
//    public ProductServiceImpl(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

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

//    @Override
//    public List<Product> searchByName(String search) {
//        List<Product> products = productRepository.searchByName(search);
//        return products;
//    }
}
