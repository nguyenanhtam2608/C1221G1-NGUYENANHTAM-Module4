package com.codegym.model.customer;

import com.codegym.model.contract.Contract;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCustomer;
    @ManyToOne
    @JoinColumn(name = "id_customer_type", referencedColumnName = "idCustomerType")// id bên class CustomerType

    private CustomerType customerType;
    private String nameCustomer;
    @Column(columnDefinition = "Date")
    private String birthdayCustomer;
    private Integer genderCustomer;
    private String idCardCustomer;
    private String phoneCustomer;
    private String emailCustomer;
    private String addressCustomer;

    @OneToMany(mappedBy = "customer")
    List<Contract> contracts;

    public Customer() {
    }

    public Customer(Integer idCustomer, CustomerType customerType, String nameCustomer, String birthdayCustomer, Integer genderCustomer, String idCardCustomer, String phoneCustomer, String emailCustomer, String addressCustomer, List<Contract> contracts) {
        this.idCustomer = idCustomer;
        this.customerType = customerType;
        this.nameCustomer = nameCustomer;
        this.birthdayCustomer = birthdayCustomer;
        this.genderCustomer = genderCustomer;
        this.idCardCustomer = idCardCustomer;
        this.phoneCustomer = phoneCustomer;
        this.emailCustomer = emailCustomer;
        this.addressCustomer = addressCustomer;
        this.contracts = contracts;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getBirthdayCustomer() {
        return birthdayCustomer;
    }

    public void setBirthdayCustomer(String birthdayCustomer) {
        this.birthdayCustomer = birthdayCustomer;
    }

    public Integer getGenderCustomer() {
        return genderCustomer;
    }

    public void setGenderCustomer(Integer genderCustomer) {
        this.genderCustomer = genderCustomer;
    }

    public String getIdCardCustomer() {
        return idCardCustomer;
    }

    public void setIdCardCustomer(String idCardCustomer) {
        this.idCardCustomer = idCardCustomer;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

}
