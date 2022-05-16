package com.codegym.model;

import javax.persistence.*;


@Entity
@Table(name = "user_aop")

public class User {
    @Id
    private int id;
    private String codeUser;

    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;


    public User() {
    }

    public User(String codeUser, Book book) {
        this.codeUser = codeUser;
        this.book = book;
    }

    public User(int id, String codeUser, Book book) {
        this.id = id;
        this.codeUser = codeUser;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeUser() {
        return codeUser;
    }

    public void setCodeUser(String codeUser) {
        this.codeUser = codeUser;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
