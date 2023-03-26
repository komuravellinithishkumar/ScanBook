package com.scanbuyTest.Scanbuydemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "BookDetails")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "pages")
    private int pages;

    @Column(name = "ISBN", unique = true, nullable = false)
    private String ISBN;

    public Book() {
    }

    Book(String Title, String Author, int pages, String ISBN) {
        this.title = Title;
        this.pages = pages;
        this.author = Author;
        this.ISBN = ISBN;
    }

    public String getBookTitle() {
        return this.title;
    }

    public String getBookAuthor() {
        return this.author;
    }

    public int getBookPages() {
        return this.pages;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setBookName(String Name) {
        this.title = Name;

    }

    public String setBookAuthor(String author) {
        return this.author = author;

    }

    public void setBookpage(int pages) {
        this.pages = pages;

    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;

    }

    @Override
    public String toString() {
        return "Book[Title=" + title + ",Pages=" + pages + ",ISBN=" + ISBN + ",BookAuthor =" + author
                + ",]";
    }

}
