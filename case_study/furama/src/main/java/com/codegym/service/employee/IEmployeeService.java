package com.codegym.service.employee;


import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IEmployeeService {
    Page<Employee> findEmployeeByNameEmployeeContainingAndEmailEmployeeContaining(String searchName, String searchEmail, Pageable pageable);

    void save(Employee employee);


    void delete(Employee employee);

    Employee findById(int id);

    Page<Employee> findAllAndSearch(String searchName, String searchEmail, String searchDivision, String searchEducation, String searchPosition, Pageable pageable);

}
