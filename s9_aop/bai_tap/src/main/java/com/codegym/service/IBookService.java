package com.codegym.service;

import com.codegym.model.Book;

import java.util.List;

public interface IBookService {
    List<Book>findAll();

    Book findById(int id);

    String borrow(Book book);

    void plus(Book book);

    String borrowError(Integer id);
}
