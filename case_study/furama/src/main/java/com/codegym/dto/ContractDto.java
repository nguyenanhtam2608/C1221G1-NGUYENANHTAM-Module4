package com.codegym.dto;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.service.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class ContractDto implements Validator {

    private int idContract;
    private String startDateContract;
    private String endDateContract;
    private String depositContract;
    private String totalMoneyContract;
    private Employee employee;
    private Service service;
    private Customer customer;

    public ContractDto() {
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public String getStartDateContract() {
        return startDateContract;
    }

    public void setStartDateContract(String startDateContract) {
        this.startDateContract = startDateContract;
    }

    public String getEndDateContract() {
        return endDateContract;
    }

    public void setEndDateContract(String endDateContract) {
        this.endDateContract = endDateContract;
    }

    public String getDepositContract() {
        return depositContract;
    }

    public void setDepositContract(String depositContract) {
        this.depositContract = depositContract;
    }

    public String getTotalMoneyContract() {
        return totalMoneyContract;
    }

    public void setTotalMoneyContract(String totalMoneyContract) {
        this.totalMoneyContract = totalMoneyContract;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        if("".equals(contractDto.getStartDateContract())) {
            errors.rejectValue("startDateContract", "date.null", "nilnon");
        }else
        if (LocalDate.parse(contractDto.getStartDateContract()).isBefore(LocalDate.now())) {
            errors.rejectValue("startDateContract", "date.start", "Nonnn");
        }

        if("".equals(contractDto.getEndDateContract())) {
            errors.rejectValue("endDateContract", "date.null", "nilnon1");
        }else if("".equals(contractDto.getStartDateContract())) {

        }else
        if (LocalDate.parse(contractDto.getEndDateContract()).isBefore(LocalDate.parse(contractDto.getStartDateContract()))) {
            errors.rejectValue("endDateContract", "date.end", "nonnn");
        }

    }
}
