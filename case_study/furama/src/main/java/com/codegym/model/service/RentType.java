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


}
