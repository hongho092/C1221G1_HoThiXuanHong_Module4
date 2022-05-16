package com.example.service;

import com.example.model.Book;
import com.example.model.BorrowedBook;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(int id);

    void reduceNumberOfBook(Book book);

    void copy(Book book, BorrowedBook borrowedBook);
    
    Book findByCodeBook(String codeBook);

    void edit(Book book);

    void save(Book book);
}
