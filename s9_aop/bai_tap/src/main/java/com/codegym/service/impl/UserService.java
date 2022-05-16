package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public String random(Book book) {
        double ramDomDou = Math.random();
        ramDomDou = ramDomDou * 10000 + 1;
        String ranDom = Double.toString(ramDomDou);
        User user = new User(ranDom, book);
        iUserRepository.save(user);
        return user.getCodeUser();
    }

    @Override
    public User findAllByCode(String codeUser) {
        return iUserRepository.findAllByCode(codeUser);
    }

    @Override
    public void delete(User user) {
        iUserRepository.delete(user);
    }


}
