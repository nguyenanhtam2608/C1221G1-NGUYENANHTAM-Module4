package com.codegym.repository.ContractReoisitory;

import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Integer> {

    @Query(value = "select * from contract where customer_id like :sCustomer and employee_id like :sEmployee and service_id like :sService",
            countQuery ="select * from contract where customer_id like :sCustomer and employee_id like :sEmployee and service_id like :sService",
            nativeQuery = true)
    Page<Contract> findAllAndSearch(
            @Param("sCustomer") String sCustomer,
            @Param("sEmployee") String sEmployee,
            @Param("sService") String sService,
            Pageable pageable);

    Page<Contract> findAll(Pageable pageable);


}
