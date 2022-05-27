package com.codegym.service.customer.impl;

import com.codegym.dto.HaveBooking;
import com.codegym.model.customer.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Arrays;
import java.util.List;

@Service
@Transactional
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

//    @Override
//    public void delete(Customer customer) {
//        iCustomerRepository.delete(customer);
//    }
    @Override
    public void delete(Integer[] idCustomer) {
        iCustomerRepository.deleteAllByIdCustomer(Arrays.asList(idCustomer));


    }



    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Page<HaveBooking> findAllBooking(String scustomer, Pageable pageable) {
        return iCustomerRepository.findAllBooking("%"+scustomer+"%",pageable);
    }


    @Override
    public Page<Customer> findCustomerByNameCustomerContainingAndEmailCustomerContaining(String name, String email, Pageable pageable) {
        return iCustomerRepository.findCustomerByNameCustomerContainingAndEmailCustomerContaining(name,email,pageable);
    }

    @Override
    public Page<Customer> findAllAndSearch (String searchName, String searchEmail, String searchType, Pageable pageable) {
        return iCustomerRepository.findAllAndSearch("%"+searchName+"%","%"+searchEmail+"%",searchType,pageable);
    }


}
