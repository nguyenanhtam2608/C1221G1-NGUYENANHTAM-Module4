package com.codegym.service.Contract.impl;

import com.codegym.model.contract.ContractDetail;
import com.codegym.repository.ContractReoisitory.IContractDetailRepository;
import com.codegym.service.Contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    IContractDetailRepository iContractDetailRepository;

    @Override
    public Page<ContractDetail> findAllContractDetail(Pageable pageable) {
        return iContractDetailRepository.findAll(pageable);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }
}
