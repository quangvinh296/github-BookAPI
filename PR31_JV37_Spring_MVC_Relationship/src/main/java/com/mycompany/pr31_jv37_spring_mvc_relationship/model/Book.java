/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pr31_jv37_spring_mvc_relationship.model;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class Book implements Serializable {

    private int id;
    private String name;
    private String author;
    private Category category;
    private BookDetail bookDetail;

    public Book(int id, String name, String author, Category category, BookDetail bookDetail) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.bookDetail = bookDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BookDetail getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetail bookDetail) {
        this.bookDetail = bookDetail;
    }

}
