package com.codegym.repository.ServiceRepository;

import com.codegym.model.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
    List<ServiceType> findAll();
}
