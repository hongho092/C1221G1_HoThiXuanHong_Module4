package com.example.service;

import com.example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {


    void save(User user);

    Page<User> findAll(String firstName, String lastName, Pageable pageable);
}
