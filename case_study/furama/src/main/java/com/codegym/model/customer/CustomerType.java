package com.codegym.model.customer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int idCustomerType;
    private String nameCustomerType;

    @OneToMany(mappedBy = "customerType")// thuộc tính bên class customer
    private List<Customer> customers;

    public CustomerType(int idCustomerType, String nameCustomerType, List<Customer> customers) {
        this.idCustomerType = idCustomerType;
        this.nameCustomerType = nameCustomerType;
        this.customers = customers;
    }

    public CustomerType() {
    }

    public int getIdCustomerType() {
        return idCustomerType;
    }

    public void setIdCustomerType(int idCustomerType) {
        this.idCustomerType = idCustomerType;
    }

    public String getNameCustomerType() {
        return nameCustomerType;
    }

    public void setNameCustomerType(String nameCustomerType) {
        this.nameCustomerType = nameCustomerType;
    }
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
