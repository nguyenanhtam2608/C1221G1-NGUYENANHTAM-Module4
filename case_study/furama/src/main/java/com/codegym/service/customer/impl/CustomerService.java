package com.codegym.service.customer.impl;

import com.codegym.model.customer.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;


    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

//    @Override
//    public Page<Customer> findCustomerByCustomerType(String searchName, String searchEmail, String searchType, Pageable pageable) {
//        return iCustomerRepository.findCustomerByCustomerType(searchName,searchEmail,searchType,pageable);
//    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        iCustomerRepository.delete(customer);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findCustomerByNameCustomerContainingAndEmailCustomerContaining(String name, String email, Pageable pageable) {
        return iCustomerRepository.findCustomerByNameCustomerContainingAndEmailCustomerContaining(name,email,pageable);
    }




}
