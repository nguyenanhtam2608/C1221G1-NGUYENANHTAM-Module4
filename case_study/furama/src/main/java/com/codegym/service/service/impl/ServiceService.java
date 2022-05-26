package com.codegym.service.service.impl;

import com.codegym.repository.ServiceRepository.IServiceRepository;
import com.codegym.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements IServiceService {
    @Autowired
    IServiceRepository iServiceRepository;


    @Override
    public Page<com.codegym.model.service.Service> findAllAndSearch(String searchName, String searchRent, String searchType, Pageable pageable) {
        return iServiceRepository.findAllAndSearch("%" + searchName + "%", searchRent, searchType, pageable);
    }

    @Override
    public void save(com.codegym.model.service.Service service) {
        if (service.getPoolArea().equals("1")) {
            service.setPoolArea(null);
        }
        if (service.getNumberOfFloors().equals("1")) {
            service.setNumberOfFloors(null);
        }
        if (service.getServiceType().getIdServiceType() == 1) {
                service.setPoolArea("1");
        }
        iServiceRepository.save(service);
    }

    @Override
    public void delete(com.codegym.model.service.Service service) {
        iServiceRepository.delete(service);
    }

    @Override
    public com.codegym.model.service.Service findById(int id) {
        return iServiceRepository.findById(id).orElse(null);
    }

    @Override
    public Page<com.codegym.model.service.Service> findAll(Pageable pageable) {
        return iServiceRepository.findAll(pageable);
    }

    @Override
    public List<com.codegym.model.service.Service> findAll() {
        return iServiceRepository.findAll();
    }
}
