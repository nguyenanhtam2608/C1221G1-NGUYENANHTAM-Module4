package com.codegym.model.contract;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.service.Service;
import org.hibernate.annotations.OnDelete;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContract;
    @Column(columnDefinition = "DATETIME")
    private String startDateContract;
    @Column(columnDefinition = "DATETIME")
    private String endDateContract;
    @Column(columnDefinition = "DOUBLE")
    private String depositContract;
    @Column(columnDefinition = "DOUBLE")
    private String totalMoneyContract;
    @ManyToOne

    @JoinColumn(name = "employee_id", referencedColumnName = "idEmployee")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "idService")
    private Service service;
    @ManyToOne

    @JoinColumn(name = "customer_id", referencedColumnName = "idCustomer")
    private Customer customer;

    @OneToMany(mappedBy = "contract")
    List<ContractDetail> ContractDetails;
    public Contract() {
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

    public List<ContractDetail> getContractDetails() {
        return ContractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        ContractDetails = contractDetails;
    }
}
