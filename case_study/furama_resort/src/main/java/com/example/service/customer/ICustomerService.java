package com.example.service.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAll1(String searchName, String searchAddress, Pageable pageable);

    Page<Customer> findAll2(String searchName, String searchAddress, int searchCategory, Pageable pageable);

    void save(Customer customer);

    void deleteById(int id);

    Customer findById(int id);
}
