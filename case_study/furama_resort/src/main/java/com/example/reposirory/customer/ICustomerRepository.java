package com.example.reposirory.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContaining(String searchName, String searchAddress, Pageable pageable);

    Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerType_CustomerTypeId(String searchName, String searchAddress, int searchCategory, Pageable pageable);

//    @Query(value = "update customer set flag = 0 where customer_id = ?", nativeQuery = true)
//    void updateFlag(int id);

}
//    @Query (value = "select * from blog Where name_blog like :name",
//            countQuery = "select * from blog Where name_blog like :name" ,nativeQuery = true)
//    Page<Blog> searchByName (@Param("name") String name, Pageable pageable);