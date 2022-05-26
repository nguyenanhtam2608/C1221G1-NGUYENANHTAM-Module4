package com.codegym.repository.ContractReoisitory;

import com.codegym.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {

    Page<ContractDetail> findAll(Pageable pageable);
}
