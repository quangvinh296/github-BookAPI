/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pr31_jv37_spring_mvc_relationship.controller;

import com.mycompany.pr31_jv37_spring_mvc_relationship.entities.BookEntity;
import com.mycompany.pr31_jv37_spring_mvc_relationship.service.BookService;
import com.mycompany.pr31_jv37_spring_mvc_relationship.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ASUS
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Model model,
            @RequestParam(name = "type", required = false) String type,
            @RequestParam(name = "message", required = false) String message) {

        model.addAttribute("books", bookService.getBooks());
        model.addAttribute("type", type);
        model.addAttribute("message", message);
        return "home";
    }

    @RequestMapping("/add-book")
    public String addBook(Model model) {
        model.addAttribute("book", new BookEntity());
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("action", "add");
        return "book-form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createBook(Model model,
            @ModelAttribute("book") BookEntity book) {
        bookService.save(book, "add");
        return "redirect:/home";
    }

    @RequestMapping("/update-book/{bookId}")
    public String updateBook(Model model,
            @PathVariable("bookId") int bookId) {
        BookEntity book = bookService.findBookById(bookId);
        if (book.getId() > 0) {
            model.addAttribute("book", book);
            model.addAttribute("categories", categoryService.getCategories());
            model.addAttribute("action", "update");
            return "book-form";
        } else {
            return "redirect:/home?type=error&message=Not found book id: " + bookId;
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateBook(Model model,
            @ModelAttribute("book") BookEntity book) {
        bookService.save(book, "update");
        return "redirect:/home";
    }

    @RequestMapping("/delete-book/{bookId}")
    public String deleteBook(Model model,
            @PathVariable("bookId") int bookId) {
        BookEntity book = bookService.findBookById(bookId);
        if (book.getId() > 0) {
            if (!bookService.deleteBook(bookId)) {
                return "redirect:/home?type=success&message=Delete book id: " + bookId + " success";
            } else {
                return "redirect:/home?type=error&message=Delete book id: " + bookId + " fail";
            }
        } else {
            return "redirect:/home?type=error&message=Not found book id: " + bookId;
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchBook(Model model,
            @ModelAttribute("strSearch") String strSearch) {
        model.addAttribute("books", bookService.searchBook(strSearch));
        return "home";
    }

}
