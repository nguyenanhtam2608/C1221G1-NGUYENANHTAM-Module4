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
}
