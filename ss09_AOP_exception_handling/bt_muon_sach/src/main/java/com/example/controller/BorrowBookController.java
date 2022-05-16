package com.example.controller;

import com.example.model.Book;
import com.example.model.BorrowedBook;
import com.example.service.IBookService;
import com.example.service.IBorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/borrow_book")
public class BorrowBookController {

    @Autowired
    private IBorrowedBookService borrowedBookService;

    @Autowired
    private IBookService bookService;

    @GetMapping(value = "")
    public String goListBorrowBook(Model model) {
        List<BorrowedBook> borrowedBookList = borrowedBookService.findAll();
        model.addAttribute("borrowedBookList", borrowedBookList);
        return "list_borrow_book";
    }

    @GetMapping(value = "give_back")
    public String goGiveBack() {
        return "give_book_back";
    }

    @PostMapping(value = "give_back")
    public String giveBackBook(@RequestParam int bookBorrowingCode, Model model) {
        List<BorrowedBook> borrowedBookList = borrowedBookService.findAll();
        int check = -1;
        int id = -1;
        String codeBook = null;
        for (int i=0; i<borrowedBookList.size(); i++) {
            if (borrowedBookList.get(i).getBookBorrowingCode() == bookBorrowingCode) {
                id = borrowedBookList.get(i).getId();
                codeBook = borrowedBookList.get(i).getCodeBook();
                check = 0;
            }
        }
        if (check == 0) {
            borrowedBookService.deleteById(id);
            Book book = bookService.findByCodeBook(codeBook);
            bookService.edit(book);
            bookService.save(book);
            return "redirect:/book/";
        } else {
            model.addAttribute("mess", "Code does not exist");
            return "give_book_back";
        }
    }
}
