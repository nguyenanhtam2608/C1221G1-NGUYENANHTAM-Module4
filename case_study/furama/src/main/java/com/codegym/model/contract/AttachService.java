package com.codegym.model.contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAttachService;
    private String nameAttachService;
    @Column(columnDefinition = "DOUBLE")
    private String costAttachService;
    @Column(columnDefinition = "INTEGER")
    private String unitAttachService;
    private String statusAttachService;

    @OneToMany(mappedBy = "attachService")
    List<ContractDetail> ContractDetails;

    public AttachService() {
    }

    public int getIdAttachService() {
        return idAttachService;
    }

    public void setIdAttachService(int idAttachService) {
        this.idAttachService = idAttachService;
    }

    public String getNameAttachService() {
        return nameAttachService;
    }

    public void setNameAttachService(String nameAttachService) {
        this.nameAttachService = nameAttachService;
    }

    public String getCostAttachService() {
        return costAttachService;
    }

    public void setCostAttachService(String costAttachService) {
        this.costAttachService = costAttachService;
    }

    public String getUnitAttachService() {
        return unitAttachService;
    }

    public void setUnitAttachService(String unitAttachService) {
        this.unitAttachService = unitAttachService;
    }

    public String getStatusAttachService() {
        return statusAttachService;
    }

    public void setStatusAttachService(String statusAttachService) {
        this.statusAttachService = statusAttachService;
    }

    public List<ContractDetail> getContractDetails() {
        return ContractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        ContractDetails = contractDetails;
    }
}
