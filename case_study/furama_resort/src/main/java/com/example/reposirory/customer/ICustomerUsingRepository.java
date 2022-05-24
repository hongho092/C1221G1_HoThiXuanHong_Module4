package com.example.reposirory.customer;

import com.example.model.customer.CustomerUsingNow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerUsingRepository extends JpaRepository<CustomerUsingNow, Integer> {

    @Query(value = "select * from customer_service_now", nativeQuery = true)
    List<CustomerUsingNow> get();
}
