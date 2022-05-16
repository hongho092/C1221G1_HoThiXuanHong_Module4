package com.example.controller;

import com.example.model.Book;
import com.example.model.BorrowedBook;
import com.example.service.IBookService;
import com.example.service.IBorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private IBorrowedBookService borrowedBookService;

    @GetMapping(value = "")
    public String goListBook(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "list_book";
    }

    @GetMapping(value = "/borrow")
    public String showBorrowBook(Model model, @RequestParam int id, RedirectAttributes redirectAttributes) {
        Book book = bookService.findById(id);
        if(book.getRemainTotal() == 0) {
            redirectAttributes.addFlashAttribute("mess", "Ran out of books to borrow");
            return "redirect:/book/";
        }
        bookService.reduceNumberOfBook(book);
        BorrowedBook borrowedBook = new BorrowedBook();
        bookService.copy(book, borrowedBook);
        model.addAttribute("borrowedBook", borrowedBook);
        return "borrow_book";
    }

    @PostMapping(value = "/saveBorrowBook")
    public String saveBB(@ModelAttribute BorrowedBook borrowedBook, RedirectAttributes redirectAttributes) {
        borrowedBookService.save(borrowedBook);
        redirectAttributes.addFlashAttribute("mess", "Borrow Book Success");
        return "redirect:/book/";
    }
}
