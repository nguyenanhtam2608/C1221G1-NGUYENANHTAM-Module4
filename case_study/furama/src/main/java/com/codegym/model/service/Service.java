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
    @Column(columnDefinition = "INTEGER")
    private String maxPeopleService;
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

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getAreaService() {
        return areaService;
    }

    public void setAreaService(String areaService) {
        this.areaService = areaService;
    }

    public String getCostService() {
        return costService;
    }

    public void setCostService(String costService) {
        this.costService = costService;
    }

    public String getMaxPeopleService() {
        return maxPeopleService;
    }

    public void setMaxPeopleService(String maxPeopleService) {
        this.maxPeopleService = maxPeopleService;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
