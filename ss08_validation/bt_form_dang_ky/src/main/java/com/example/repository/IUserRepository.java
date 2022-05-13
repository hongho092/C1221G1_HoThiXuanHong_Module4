package com.example.repository;

import com.example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

    Page<User> findAllByFirstNameContainingAndLastNameContaining(String firstName, String lastName, Pageable pageable);
}
