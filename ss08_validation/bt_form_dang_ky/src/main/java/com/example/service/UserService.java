package com.example.service;

import com.example.model.User;
import com.example.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Page<User> findAll(String firstName, String lastName, Pageable pageable) {
        return userRepository.findAllByFirstNameContainingAndLastNameContaining(firstName, lastName, pageable);
    }
}
