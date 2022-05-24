package com.example.service.customer;

import com.example.model.customer.CustomerUsingNow;

import java.util.List;

public interface ICustomerUsingService {
    List<CustomerUsingNow> get();
}
