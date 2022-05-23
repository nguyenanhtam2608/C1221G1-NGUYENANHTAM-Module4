package com.codegym.repository.employee;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findEmployeeByNameEmployeeContainingAndEmailEmployeeContaining(String searchName, String searchEmail, Pageable pageable);

    @Query(value = "select * from employee where name_employee like :searchName and email_employee like :searchEmail and id_division like :searchDivision and id_education_degree like :searchEducation and id_position like :searchPosition",
            countQuery ="select * from employee where name_employee like :searchName and email_employee like :searchEmail and id_division like :searchDivision and id_education_degree like :searchEducation and id_position like :searchPosition",
            nativeQuery = true)
    Page<Employee> findAllAndSearch(
            @Param("searchName") String searchName,
            @Param("searchEmail") String searchEmail,
            @Param("searchDivision") String searchDivision,
            @Param("searchEducation") String searchEducation,
            @Param("searchPosition") String searchPosition,
            Pageable pageable);


}
