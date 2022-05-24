package com.example.service.customer.impl;

import com.example.model.customer.CustomerUsingNow;
import com.example.reposirory.customer.ICustomerUsingRepository;
import com.example.service.customer.ICustomerUsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerUsingService implements ICustomerUsingService {

    @Autowired
    private ICustomerUsingRepository customerUsingRepository;

    @Override
    public List<CustomerUsingNow> get() {
        return customerUsingRepository.get();
    }
}
