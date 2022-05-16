package com.codegym.service;

import com.codegym.model.Book;

import java.util.List;

public interface IBookService {
    List<Book>findAll();

    Book findById(int id);

    void borrow(Book book);
    void pay(Book book);

    void plus(Book book);
}
