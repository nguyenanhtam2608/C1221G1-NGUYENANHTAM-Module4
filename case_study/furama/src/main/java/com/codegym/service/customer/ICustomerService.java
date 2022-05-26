package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findCustomerByNameCustomerContainingAndEmailCustomerContaining(String name, String email, Pageable pageable);

    Page<Customer> findAllAndSearch(String searchName, String searchEmail, String searchType, Pageable pageable);

    void save(Customer customer);

//    void delete(Customer customer);
    void delete(Integer[] idCustomer);

//    Page<Customer> findCustomerByNameCustomerContainingAndEmailCustomerContainingAndCustomerType(String name, String email, Integer customerType, Pageable pageable);

    Customer findById(int id);

    List<Customer> findAll();

}
