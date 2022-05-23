package com.codegym.model.contract;

import javax.persistence.*;

@Entity
@Table
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContractDetail;

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "idContract")
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "attach_service_id", referencedColumnName = "idAttachService")
    private AttachService attachService;
    @Column(columnDefinition = "INTEGER")
    private String quantity;

    public ContractDetail() {
    }
}
