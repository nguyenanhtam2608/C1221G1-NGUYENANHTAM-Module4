package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name="user_s8")
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// id Primary key và auto tăng
    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private String age;
    private String email;

    public UserApp() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
