/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pr31_jv37_spring_mvc_relationship.service;

import com.mycompany.pr31_jv37_spring_mvc_relationship.entities.BookDetailEntity;
import com.mycompany.pr31_jv37_spring_mvc_relationship.entities.BookEntity;
import com.mycompany.pr31_jv37_spring_mvc_relationship.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookEntity> getBooks() {
        return (List<BookEntity>) bookRepository.findAll();
    }

    public void save(BookEntity book, String action) {
        if (action.equalsIgnoreCase("add")) {
            BookDetailEntity bookDetail = book.getBookDetail();
            bookDetail.setBook(book);
            book.setBookDetail(bookDetail);
        }
        bookRepository.save(book);
    }

    public BookEntity findBookById(int bookId) {
        Optional<BookEntity> book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            return book.get();
        } else {
            return new BookEntity();
        }
    }

    public boolean deleteBook(int bookId) {
        bookRepository.deleteById(bookId);
        return bookRepository.existsById(bookId);
    }

    public List<BookEntity> searchBook(String strSearch) {
//        return bookRepository.findByAuthorContaining(strSearch);
//        return bookRepository.findBookByCategoryNameOrIsbn(strSearch, strSearch);
        return bookRepository.findByCategory_NameContainingOrBookDetail_IsbnContaining(strSearch, strSearch);
    }
}
