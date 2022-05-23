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
}
