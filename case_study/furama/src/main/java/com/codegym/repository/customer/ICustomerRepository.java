package com.codegym.repository.customer;

import com.codegym.model.customer.Customer;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findCustomerByNameCustomerContainingAndEmailCustomerContaining(String name, String email, Pageable pageable);

//    @Query(value = "select * from customer where name_customer like :searchName and email_customer like :searchEmail and id_customer_type like:searchType",
//            countQuery = "select * from customer where name_customer like :searchName and email_customer like :searchEmail and id_customer_type like:searchType",
//            nativeQuery = true)
//    Page<Customer> findCustomerByCustomerType(
//            @Param("searchName") String searchName,
//            @Param("searchEmail") String searchEmail,
//            @Param("searchType") String searchType,
//            Pageable pageable);

}
