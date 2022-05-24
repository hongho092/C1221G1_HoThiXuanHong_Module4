package com.example.service.customer.impl;

import com.example.model.customer.Customer;
import com.example.reposirory.customer.ICustomerRepository;
import com.example.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll1(String searchName, String searchAddress, Pageable pageable) {
        return customerRepository.findAllByCustomerNameContainingAndCustomerAddressContaining(searchName, searchAddress, pageable);
    }

    @Override
    public Page<Customer> findAll2(String searchName, String searchAddress, int searchCategory, Pageable pageable) {
        return customerRepository.findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerType_CustomerTypeId(searchName, searchAddress, searchCategory, pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}
