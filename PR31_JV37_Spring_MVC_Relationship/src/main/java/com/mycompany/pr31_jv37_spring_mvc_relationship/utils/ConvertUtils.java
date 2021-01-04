/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pr31_jv37_spring_mvc_relationship.utils;

import com.mycompany.pr31_jv37_spring_mvc_relationship.entities.BookEntity;
import com.mycompany.pr31_jv37_spring_mvc_relationship.model.Book;
import com.mycompany.pr31_jv37_spring_mvc_relationship.model.BookDetail;
import com.mycompany.pr31_jv37_spring_mvc_relationship.model.Category;

/**
 *
 * @author ASUS
 */
public class ConvertUtils {

    public static Book convertBookFromBookEntity(BookEntity bookEntity) {
        BookDetail bookDetail
                = new BookDetail(bookEntity.getBookDetail().getId(),
                        bookEntity.getBookDetail().getIsbn(),
                        bookEntity.getBookDetail().getNumberOfPages(),
                        bookEntity.getBookDetail().getPrice(),
                        bookEntity.getBookDetail().getPublishDate());

        Category category
                = new Category(bookEntity.getCategory().getId(),
                        bookEntity.getCategory().getName(),
                        bookEntity.getCategory().getDescription());

        return new Book(bookEntity.getId(), bookEntity.getName(),
                bookEntity.getAuthor(), category, bookDetail);
    }
}
