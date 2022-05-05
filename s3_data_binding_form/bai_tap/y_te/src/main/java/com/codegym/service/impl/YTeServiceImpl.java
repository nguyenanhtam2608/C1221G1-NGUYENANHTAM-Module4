package com.codegym.service.impl;

import com.codegym.model.YTe;
import com.codegym.repository.YTeRepository;
import com.codegym.repository.impl.YTeRepositoryImpl;
import com.codegym.service.YTeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YTeServiceImpl implements YTeService {
    YTeRepository yTeRepository = new YTeRepositoryImpl();


    @Override
    public List<YTe> listYTe() {
        return yTeRepository.listYTe();
    }

    @Override
    public void save(YTe yTe) {
        yTeRepository.save(yTe);
    }
}
