package com.codegym.model.service;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRentType;
    private String nameRentType;
    @Column(columnDefinition = "DOUBLE")
    private String costRentType;

    @OneToMany(mappedBy = "rentType")
    List<Service> services;
    public RentType() {
    }

    public int getIdRentType() {
        return idRentType;
    }

    public void setIdRentType(int idRentType) {
        this.idRentType = idRentType;
    }

    public String getNameRentType() {
        return nameRentType;
    }

    public void setNameRentType(String nameRentType) {
        this.nameRentType = nameRentType;
    }

    public String getCostRentType() {
        return costRentType;
    }

    public void setCostRentType(String costRentType) {
        this.costRentType = costRentType;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
