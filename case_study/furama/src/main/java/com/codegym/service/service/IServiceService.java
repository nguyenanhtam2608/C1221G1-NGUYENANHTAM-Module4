package com.codegym.service.service;

import com.codegym.model.customer.Customer;
import com.codegym.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IServiceService {
    Page<Service> findAllAndSearch(
            String searchName,
            String searchRent,
            String searchType,
            Pageable pageable);

    void save(Service service);

    void delete(Service service);

    Service findById(int id);

    Page<Service> findAll(Pageable pageable);

    List<Service> findAll();
}
