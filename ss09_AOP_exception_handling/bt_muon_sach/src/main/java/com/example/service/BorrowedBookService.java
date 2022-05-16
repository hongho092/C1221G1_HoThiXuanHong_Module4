package com.example.service;

import com.example.model.BorrowedBook;
import com.example.repository.IBookRepository;
import com.example.repository.IBorrowedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowedBookService implements IBorrowedBookService{

    @Autowired
    private IBorrowedBookRepository borrowedBookRepository;

    @Override
    public void save(BorrowedBook borrowedBook) {
        borrowedBookRepository.save(borrowedBook);
    }

    @Override
    public List<BorrowedBook> findAll() {
        return borrowedBookRepository.findAll();
    }

    @Override
    public BorrowedBook findById(int id) {
        return borrowedBookRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        borrowedBookRepository.deleteById(id);
    }
}
