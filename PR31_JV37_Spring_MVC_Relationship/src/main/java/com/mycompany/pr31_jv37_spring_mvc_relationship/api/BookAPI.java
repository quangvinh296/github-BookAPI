/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pr31_jv37_spring_mvc_relationship.api;

import com.mycompany.pr31_jv37_spring_mvc_relationship.entities.BookEntity;
import com.mycompany.pr31_jv37_spring_mvc_relationship.model.Book;
import com.mycompany.pr31_jv37_spring_mvc_relationship.service.BookService;
import com.mycompany.pr31_jv37_spring_mvc_relationship.utils.ConvertUtils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api")
public class BookAPI {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getBooks() {
        List<BookEntity> bookEntities = bookService.getBooks();
        if (CollectionUtils.isEmpty(bookEntities)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            List<Book> books = new ArrayList<>();
            for (BookEntity bookEntity : bookEntities) {
                books.add(
                        ConvertUtils.convertBookFromBookEntity(bookEntity));
            }

            return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> getBook(
            @PathVariable("id") int id) {
        BookEntity bookEntity = bookService.findBookById(id);
        if (bookEntity.getId() > 0) {
            Book book = ConvertUtils.convertBookFromBookEntity(bookEntity);
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

}
