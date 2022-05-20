package com.codegym.model.service;

import com.codegym.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idService;
    private String nameService;
    @Column(columnDefinition = "INTEGER")
    private String areaService;
    @Column(columnDefinition = "DOUBLE")
    private String costService;
    @ManyToOne()
    @JoinColumn(name = "id_rent_type",referencedColumnName ="idRentType")
    private RentType rentType;
    @ManyToOne()
    @JoinColumn(name = "id_service_type",referencedColumnName ="idServiceType")
    private ServiceType serviceType;
    @OneToMany(mappedBy = "service")
    List<Contract> contracts;
    private String standardRoom;
    private String descriptionOtherConvenience;
    @Column(columnDefinition = "DOUBLE")
    private String poolArea;
    @Column(columnDefinition = "INTEGER")
    private String numberOfFloors;

    public Service() {
    }
}
