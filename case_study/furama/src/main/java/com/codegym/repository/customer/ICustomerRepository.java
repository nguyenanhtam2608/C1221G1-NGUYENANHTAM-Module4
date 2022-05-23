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


    Page<Customer> findCustomerByCustomerTypeContaining(String searchType,Pageable pageable);

    Page<Customer> findCustomerByNameCustomerContainingAndEmailCustomerContaining(String name, String email, Pageable pageable);
    Page<Customer> findCustomerByNameCustomerContainingAndEmailCustomerContainingAndCustomerType(String name, String email,Integer customerType, Pageable pageable);


    @Query(value = "select * from customer where name_customer like :searchName and email_customer like :searchEmail and id_customer_type like:searchType",
            countQuery = "select * from customer where name_customer like :searchName and email_customer like :searchEmail and id_customer_type like:searchType",
            nativeQuery = true)
    Page<Customer> findAllAndSearch(
            @Param("searchName") String searchName,
            @Param("searchEmail") String searchEmail,
            @Param("searchType") String searchType,
            Pageable pageable);

    // @Query(value="select * from product where name like :nameVal and price like :price and category_id like :category" ,
    //    countQuery="select * from product where name like :nameVal and price like :price and category_id like :category",nativeQuery=true)
    //    Page<Product> findAndSearch(@Param("nameVal") String nameVal,@Param("category") String categoryFind,@Param("price") String priceFind, Pageable pageable);

}
