package com.codegym.repository.customer;



import com.codegym.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepositoryType extends JpaRepository<CustomerType,Integer> {
//    Page<CustomerType> findAll(Pageable pageable);

}
