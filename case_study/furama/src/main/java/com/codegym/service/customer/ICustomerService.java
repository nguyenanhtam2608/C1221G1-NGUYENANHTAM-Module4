package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findCustomerByNameCustomerContainingAndEmailCustomerContaining(String name, String email, Pageable pageable);
//
//    Page<Customer> findCustomerByCustomerType(
//            @Param("searchName") String searchName,
//            @Param("searchEmail") String searchEmail,
//            @Param("searchType") String searchType,
//            Pageable pageable);

    void save(Customer customer);

    void delete(Customer customer);

    Customer findById(int id);
}
