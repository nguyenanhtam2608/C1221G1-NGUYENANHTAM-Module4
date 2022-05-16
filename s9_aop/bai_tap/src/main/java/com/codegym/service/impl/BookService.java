package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.repository.IBookRepository;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository iBookRepository;


    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public void borrow(Book book) {
        book.setQuantity(book.getQuantity()-1);
        iBookRepository.save(book);
    }

    @Override
    public void pay(Book book) {
        book.setQuantity(book.getQuantity()+1);
        iBookRepository.save(book);
    }

    @Override
    public void plus(Book book) {
        book.setQuantity(book.getQuantity()+1);
        iBookRepository.save(book);
    }
}
