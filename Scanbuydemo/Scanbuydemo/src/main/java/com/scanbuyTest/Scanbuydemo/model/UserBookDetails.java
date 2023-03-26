package com.scanbuyTest.Scanbuydemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "user_book_details")
public class UserBookDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "notes")
    private String notes;

    @Column(name = "finished")
    private boolean finished;

    public void setUser(User user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getNotes() {
        return this.notes;
    }

    public boolean getFinished() {
        return this.finished;
    }

    public User getUser() {
        return this.user;

    }

    public Book getBook() {
        return this.book;
    }

    public Long getId() {
        return this.id;
    }

}
