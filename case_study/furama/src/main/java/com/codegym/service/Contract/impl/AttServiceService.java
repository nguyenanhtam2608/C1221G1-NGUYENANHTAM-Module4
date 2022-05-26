package com.codegym.service.Contract.impl;
import com.codegym.model.contract.AttachService;
import com.codegym.repository.ContractReoisitory.IAttachRepository;
import com.codegym.service.Contract.IAttServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AttServiceService implements IAttServiceService {

    @Autowired
    IAttachRepository iAttachRepository;

    @Override
    public List<AttachService> findAll() {
        return iAttachRepository.findAll();
    }

}
