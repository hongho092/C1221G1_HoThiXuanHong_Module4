package com.example.service;

import com.example.model.BorrowedBook;

import java.util.List;

public interface IBorrowedBookService {
    void save(BorrowedBook borrowedBook);

    List<BorrowedBook> findAll();

    BorrowedBook findById(int id);

    void deleteById(int id);
}
