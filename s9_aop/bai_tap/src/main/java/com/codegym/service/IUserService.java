package com.codegym.service;

import com.codegym.model.Book;
import com.codegym.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    String random(Book book);
    User findAllByCode(String codeUser);
    void delete(User user);
}
