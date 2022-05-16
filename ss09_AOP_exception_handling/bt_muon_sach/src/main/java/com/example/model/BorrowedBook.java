package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "borrowed_book")
public class BorrowedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codeBook;
    private String nameBook;
    // so luong con lai
    private int quantity;
    private int bookBorrowingCode;

    public BorrowedBook() {
    }

    public BorrowedBook(int id, String codeBook, String nameBook, int quantity, int bookBorrowingCode) {
        this.id = id;
        this.codeBook = codeBook;
        this.nameBook = nameBook;
        this.quantity = quantity;
        this.bookBorrowingCode = bookBorrowingCode;
    }

    public String getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(String codeBook) {
        this.codeBook = codeBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBookBorrowingCode() {
        return bookBorrowingCode;
    }

    public void setBookBorrowingCode(int bookBorrowingCode) {
        this.bookBorrowingCode = bookBorrowingCode;
    }
}
