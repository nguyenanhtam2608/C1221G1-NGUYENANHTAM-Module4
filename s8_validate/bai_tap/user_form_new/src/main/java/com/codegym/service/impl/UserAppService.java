package com.codegym.service.impl;



import com.codegym.model.UserApp;
import com.codegym.repository.IUserAppRepository;
import com.codegym.service.IUserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAppService implements IUserAppService {
    @Autowired
    IUserAppRepository userAppRepository;

    @Override
    public List<UserApp> findAll() {
        return userAppRepository.findAll();
    }

    @Override
    public void save(UserApp user) {

        userAppRepository.save(user);
    }
}
