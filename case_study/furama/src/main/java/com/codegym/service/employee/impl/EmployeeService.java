package com.codegym.service.employee.impl;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.repository.employee.IEmployeeRepository;
import com.codegym.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findEmployeeByNameEmployeeContainingAndEmailEmployeeContaining(String searchName, String searchEmail, Pageable pageable) {
        return iEmployeeRepository.findEmployeeByNameEmployeeContainingAndEmailEmployeeContaining(searchName,searchEmail,pageable);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        iEmployeeRepository.delete(employee);
    }

    @Override
    public Employee findById(int id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Employee> findAllAndSearch(String searchName, String searchEmail, String searchDivision, String searchEducation, String searchPosition, Pageable pageable) {
        return iEmployeeRepository.findAllAndSearch("%"+searchName+"%","%"+searchEmail+"%",searchDivision,searchEducation,searchPosition,pageable);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }


}
