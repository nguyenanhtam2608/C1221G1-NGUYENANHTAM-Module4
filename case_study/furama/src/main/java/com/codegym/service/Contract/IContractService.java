package com.codegym.service.Contract;

import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractService {
    Page<Contract> findAllAndSearch(String sCustomer, String sEmployee, String sService, Pageable pageable);

    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    List<Contract> findAll();
}
