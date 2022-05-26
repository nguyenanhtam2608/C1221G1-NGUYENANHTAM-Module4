package com.codegym.service.Contract;

import com.codegym.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractDetailService {

    Page<ContractDetail> findAllContractDetail(Pageable pageable);


    void save(ContractDetail contractDetail);
}
