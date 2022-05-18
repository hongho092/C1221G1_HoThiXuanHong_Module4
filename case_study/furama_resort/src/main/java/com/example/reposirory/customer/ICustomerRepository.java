package com.example.reposirory.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContaining(String searchName, String searchAddress, Pageable pageable);

    Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerType_CustomerTypeId(String searchName, String searchAddress, int searchCategory, Pageable pageable);
}
