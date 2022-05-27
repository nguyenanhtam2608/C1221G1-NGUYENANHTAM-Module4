package com.codegym.repository.customer;

import com.codegym.dto.HaveBooking;
import com.codegym.model.customer.Customer;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAll(Pageable pageable);

    @Query(value ="select h.customer_id as customerID,\n" +
            "       k.name_customer customerName,\n" +
            "       d.id_service idService,\n" +
            "       d.name_service nameService,\n" +
            "       ((quantity * cost_attach_service) + cost_service)  total,\n" +
            "       group_concat(distinct dv.name_attach_service SEPARATOR '-') as nameAttachService\n" +
            "from contract h\n" +
            "         right join customer k on h.customer_id = k.id_customer\n" +
            "         right join service d on h.service_id = d.id_service\n" +
            "         inner join contract_detail ct on ct.contract_id = h.id_contract\n" +
            "         inner join attach_service dv on ct.attach_service_id = dv.id_attach_service\n" +
            "where name_customer like :customer "+
            "group by h.id_contract\n",
            countQuery = "select h.customer_id as customerID,\n" +
            "       k.name_customer customerName,\n" +
            "       d.id_service idService,\n" +
            "       d.name_service nameService,\n" +
            "       ((quantity * cost_attach_service) + cost_service)  total,\n" +
            "       group_concat(distinct dv.name_attach_service SEPARATOR '-') as nameAttachService\n" +
            "from contract h\n" +
            "         right join customer k on h.customer_id = k.id_customer\n" +
            "         right join service d on h.service_id = d.id_service\n" +
            "         inner join contract_detail ct on ct.contract_id = h.id_contract\n" +
            "         inner join attach_service dv on ct.attach_service_id = dv.id_attach_service\n" +
            "where name_customer like :customer "+
            "group by h.id_contract\n",nativeQuery = true

    )
    Page<HaveBooking> findAllBooking(@Param("customer") String customer,Pageable pageable);

    Page<Customer> findCustomerByCustomerTypeContaining(String searchType, Pageable pageable);

    Page<Customer> findCustomerByNameCustomerContainingAndEmailCustomerContaining(String name, String email, Pageable pageable);

    Page<Customer> findCustomerByNameCustomerContainingAndEmailCustomerContainingAndCustomerType(String name, String email, Integer customerType, Pageable pageable);


    @Query(value = "select * from customer where name_customer like :searchName and email_customer like :searchEmail and id_customer_type like:searchType",
            countQuery = "select * from customer where name_customer like :searchName and email_customer like :searchEmail and id_customer_type like:searchType",
            nativeQuery = true)
    Page<Customer> findAllAndSearch(
            @Param("searchName") String searchName,
            @Param("searchEmail") String searchEmail,
            @Param("searchType") String searchType,
            Pageable pageable);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM customer WHERE customer IN(?1)")
    void deleteAllByIdCustomer(List<Integer> asList);


//    void deleteAllByIdCustomer(Integer idCustomer);


    // @Query(value="select * from product where name like :nameVal and price like :price and category_id like :category" ,
    //    countQuery="select * from product where name like :nameVal and price like :price and category_id like :category",nativeQuery=true)
    //    Page<Product> findAndSearch(@Param("nameVal") String nameVal,@Param("category") String categoryFind,@Param("price") String priceFind, Pageable pageable);

}
