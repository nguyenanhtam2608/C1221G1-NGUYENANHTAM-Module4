package com.codegym.dto;

import com.codegym.model.contract.AttachService;
import com.codegym.model.contract.Contract;

import javax.persistence.*;

public class ContractDetailDto {
    private int idContractDetail;
    private Contract contract;
    private AttachService attachService;
    private String quantity;

    public ContractDetailDto() {
    }

    public int getIdContractDetail() {
        return idContractDetail;
    }

    public void setIdContractDetail(int idContractDetail) {
        this.idContractDetail = idContractDetail;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
