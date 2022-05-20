package com.codegym.service.customer.impl;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.repository.customer.ICustomerRepositoryType;
import com.codegym.service.customer.ICustomerServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceType implements ICustomerServiceType {
    @Autowired
    ICustomerRepositoryType iCustomerRepositoryType;

    @Override
    public List<CustomerType> findAll() {
        return iCustomerRepositoryType.findAll();
    }




//    @Override
//    public Page<CustomerType> findAll(Pageable pageable) {
//        return iCustomerRepositoryType.findAll(pageable);
//    }
}
