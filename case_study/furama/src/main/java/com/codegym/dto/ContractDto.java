package com.codegym.dto;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.service.Service;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ContractDto {
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
}
