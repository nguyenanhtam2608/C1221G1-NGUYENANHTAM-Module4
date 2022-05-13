package com.codegym.dto;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;


public class UserDto implements Validator {
    private Integer id;
    @NotBlank(message = "not null")
    @Size(min = 5, max = 45, message = "min = 5,max = 45")
    private String firstName;
    @NotBlank(message = "not null")
    @Size(min = 5, max = 45, message = "min = 5,max = 45")
    private String lastName;
    @NotBlank(message = "not null")
    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$" ,message = "10 số bất đầu từ 0")
    private String phone;

//    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @NotBlank(message = "not null")
//    @Size(min = 18, message = "Tuổi lớn hơn 18 ")
    private String age;
    @NotBlank(message = "not null")
    @Email
    private String email;

    public UserDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if ("".equals(userDto.getAge())) {
            errors.rejectValue("age", "date.null", "nonnn");
        } else {
            if ((Period.between(LocalDate.parse(userDto.getAge()), LocalDate.now()).getYears()) < 18) {
                errors.rejectValue("age", "date.age", "NONNN");
            }
        }

    }
}

