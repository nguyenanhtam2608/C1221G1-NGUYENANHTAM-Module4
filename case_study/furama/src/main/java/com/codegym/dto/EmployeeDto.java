package com.codegym.dto;

import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Position;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeDto {
    Integer idEmployee;

    @NotBlank(message = "Không được phép để trống")
    @Size(max = 100, message = "Không vượt quá 100 ký tự")
    @Pattern(regexp = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ][\\s\\S]*$", message = "Không được nhập kí tự đặt biệt")
    String nameEmployee;
    String birthdayEmployee;
    @Pattern(regexp = "[0-9]{9}", message = "Chứng minh nhân dân có định dạng 9 số")
    String idCardEmployee;
    @Pattern(regexp = "(?!0$)[0-9]+(?:\\\\.[0-9]+)?",message = "Nhập số")
    String salaryEmployee;
    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$",
            message = "Nhập đúng định dạng số điện thoại gôm 10 số")
    String phoneEmployee;
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$",message = "Nhập sai định dạng email, Xin nhập lại")
    @NotBlank(message = "Không được phép để trống")
    String emailEmployee;
    @NotBlank(message = "Không được phép để trống")
    @Size(max = 100, message = "Không vượt quá 100 ký tự")
    @Pattern(regexp = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ][\\s\\S]*$", message = "Không được nhật kí tự đặt biệt")
    String addressEmployee;
    Position position;
    EducationDegree educationDegree;
    Division division;

    public EmployeeDto() {
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getBirthdayEmployee() {
        return birthdayEmployee;
    }

    public void setBirthdayEmployee(String birthdayEmployee) {
        this.birthdayEmployee = birthdayEmployee;
    }

    public String getIdCardEmployee() {
        return idCardEmployee;
    }

    public void setIdCardEmployee(String idCardEmployee) {
        this.idCardEmployee = idCardEmployee;
    }

    public String getSalaryEmployee() {
        return salaryEmployee;
    }

    public void setSalaryEmployee(String salaryEmployee) {
        this.salaryEmployee = salaryEmployee;
    }

    public String getPhoneEmployee() {
        return phoneEmployee;
    }

    public void setPhoneEmployee(String phoneEmployee) {
        this.phoneEmployee = phoneEmployee;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
