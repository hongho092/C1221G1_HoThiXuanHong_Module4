package com.example.service;

import com.example.model.Book;
import com.example.model.BorrowedBook;
import com.example.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookService implements IBookService{

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void reduceNumberOfBook(Book book) {
        int borrowedTotalNew = book.getBorrowedTotal() + 1;
        int remainTotalNew = book.getQuantityTotal() - borrowedTotalNew;
        book.setBorrowedTotal(borrowedTotalNew);
        book.setRemainTotal(remainTotalNew);
        bookRepository.save(book);
    }

    @Override
    public void copy(Book book, BorrowedBook borrowedBook) {
        borrowedBook.setCodeBook(book.getCodeBook());
        borrowedBook.setNameBook(book.getNameBook());
        borrowedBook.setQuantity(book.getRemainTotal());
        borrowedBook.setBookBorrowingCode((int) (10000 + (Math.random() * 99999)));
    }

    @Override
    public Book findByCodeBook(String codeBook) {
        return bookRepository.findByCodeBook(codeBook);
    }

    @Override
    public void edit(Book book) {
        int abc = book.getBorrowedTotal() - 1;
        book.setBorrowedTotal(abc);
        book.setRemainTotal(book.getQuantityTotal() - book.getBorrowedTotal());
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }
}
