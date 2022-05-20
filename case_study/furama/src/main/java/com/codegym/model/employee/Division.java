package com.codegym.model.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table
public class Division {
    @Id
     int idDivision;
     String nameDivision;
    @OneToMany(mappedBy = "division")
    List<Employee> employees;
    public Division() {
    }

    public Division(int idDivision, String nameDivision, List<Employee> employees) {
        this.idDivision = idDivision;
        this.nameDivision = nameDivision;
        this.employees = employees;
    }

    public int getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(int idDivision) {
        this.idDivision = idDivision;
    }

    public String getNameDivision() {
        return nameDivision;
    }

    public void setNameDivision(String nameDivision) {
        this.nameDivision = nameDivision;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
