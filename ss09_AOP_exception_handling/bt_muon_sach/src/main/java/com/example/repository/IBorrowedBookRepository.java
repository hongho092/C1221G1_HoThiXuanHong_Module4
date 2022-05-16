package com.example.repository;

import com.example.model.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowedBookRepository extends JpaRepository<BorrowedBook, Integer> {

}
