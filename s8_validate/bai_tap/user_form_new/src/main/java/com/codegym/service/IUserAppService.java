package com.codegym.service;


import com.codegym.model.UserApp;

import java.util.List;

public interface IUserAppService {
    List<UserApp> findAll();
    void save(UserApp user);
}
