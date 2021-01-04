/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pr31_jv37_spring_mvc_relationship.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class BookDetail implements Serializable {

    private int id;
    private String isbn;
    private int numberOfPages;
    private double price;
    private Date publishDate;

    public BookDetail(int id, String isbn, int numberOfPages, double price, Date publishDate) {
        this.id = id;
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.publishDate = publishDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

}
