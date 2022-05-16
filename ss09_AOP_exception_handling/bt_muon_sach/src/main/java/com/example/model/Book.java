package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codeBook;
    private String nameBook;
    private String writer;
    private int quantityTotal;
    private int borrowedTotal;
    private int remainTotal;

    public Book() {
    }

    public Book(int id, String codeBook, String nameBook, String writer, int quantityTotal, int borrowedTotal, int remainTotal) {
        this.id = id;
        this.codeBook = codeBook;
        this.nameBook = nameBook;
        this.writer = writer;
        this.quantityTotal = quantityTotal;
        this.borrowedTotal = borrowedTotal;
        this.remainTotal = remainTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(String codeBook) {
        this.codeBook = codeBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getQuantityTotal() {
        return quantityTotal;
    }

    public void setQuantityTotal(int quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    public int getBorrowedTotal() {
        return borrowedTotal;
    }

    public void setBorrowedTotal(int borrowedTotal) {
        this.borrowedTotal = borrowedTotal;
    }

    public int getRemainTotal() {
        return remainTotal;
    }

    public void setRemainTotal(int remainTotal) {
        this.remainTotal = remainTotal;
    }
}
