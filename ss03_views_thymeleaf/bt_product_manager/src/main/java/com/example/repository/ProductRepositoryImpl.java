package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Fan", "564.000", "black", "China"));
        products.put(2, new Product(2, "Computer", "7.890.000", "yellow and red", "Thailand"));
        products.put(3, new Product(3, "Phone", "20.000.000", "red", "Viet Nam"));
        products.put(4, new Product(4, "Table", "1.433.000", "brown", "Berlin"));
        products.put(5, new Product(5, "Chair", "456.660", "blue", "Miami"));
        products.put(6, new Product(6, "Bike", "989.006.000", "pink", "New york"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        int id = (int) (Math.random() * 100);
        product.setId(id);
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> searchByName(String search) {
        List<Product> productList = findAll();
        List<Product> products = new ArrayList<>();
        for (int i=0; i<productList.size(); i++) {
            if (productList.get(i).getName().contains(search)) {
                products.add(productList.get(i));
            }
        }
        return products;
    }
}
