package com.codegym.service.Contract.impl;

import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import com.codegym.repository.ContractReoisitory.IContractRepository;
import com.codegym.service.Contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository iContractRepository;

    @Override
    public Page<Contract> findAllAndSearch(String sCustomer, String sEmployee, String sService, Pageable pageable) {
        return iContractRepository.findAllAndSearch(sCustomer, sEmployee, sService, pageable);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }
}


