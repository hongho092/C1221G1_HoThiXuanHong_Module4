package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

//    private static final Map<Integer, Product> products;
//
//    static {
//        products = new HashMap<>();
//        products.put(1, new Product(1, "Fan", "564.000", "black", "China"));
//        products.put(2, new Product(2, "Computer", "7.890.000", "yellow and red", "Thailand"));
//        products.put(3, new Product(3, "Phone", "20.000.000", "red", "Viet Nam"));
//        products.put(4, new Product(4, "Table", "1.433.000", "brown", "Berlin"));
//        products.put(5, new Product(5, "Chair", "456.660", "blue", "Miami"));
//        products.put(6, new Product(6, "Bike", "989.006.000", "pink", "New york"));
//    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select p from Product p", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select p from Product p where p.id = :id", Product.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void update(int id, Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
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
