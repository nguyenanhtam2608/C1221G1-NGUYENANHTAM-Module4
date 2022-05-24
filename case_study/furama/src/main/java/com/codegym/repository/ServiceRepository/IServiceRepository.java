package com.codegym.repository.ServiceRepository;

import com.codegym.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<Service,Integer> {

    @Query(value = "select * from service where name_service like :searchName and id_rent_type like :searchRent and id_service_type like:searchType",
            countQuery = "select * from service where name_service like :searchName and id_rent_type like :searchRent and id_service_type like:searchType",
            nativeQuery = true)
    Page<Service> findAllAndSearch(
            @Param("searchName") String searchName,
            @Param("searchRent") String searchRent,
            @Param("searchType") String searchType,
            Pageable pageable);


}
