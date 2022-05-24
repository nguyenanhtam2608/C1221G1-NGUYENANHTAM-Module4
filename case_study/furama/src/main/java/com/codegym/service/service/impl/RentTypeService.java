package com.codegym.service.service.impl;

import com.codegym.model.service.RentType;
import com.codegym.repository.ServiceRepository.IRentTypeRepository;
import com.codegym.service.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    IRentTypeRepository iRentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}
