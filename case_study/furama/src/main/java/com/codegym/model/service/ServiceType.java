package com.codegym.model.service;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service_type")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServiceType;
    private String nameServiceType;

    @OneToMany(mappedBy = "serviceType")
    List<Service> services;
    public ServiceType() {
    }

}
