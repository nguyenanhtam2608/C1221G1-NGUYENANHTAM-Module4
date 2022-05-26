package com.codegym.dto;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class CustomerDto implements Validator {
    private Integer idCustomer;
    private CustomerType customerType;
    @NotBlank(message = "Không được phép để trống")
    @Size(max = 100, message = "Không vượt quá 100 ký tự")
    @Pattern(regexp = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ][\\s\\S]*$", message = "Không được nhập kí tự đặt biệt")
    private String nameCustomer;
    @NotBlank(message = "Không được phép để trống")
    private String birthdayCustomer;
    private Integer genderCustomer;
    @Pattern(regexp = "[0-9]{9}", message = "Chứng minh nhân dân có định dạng 9 số")
    private String idCardCustomer;

    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$",
            message = "Nhập đúng định dạng số điện thoại gôm 10 số")
    private String phoneCustomer;

    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", message = "Nhập sai định dạng email, Xin nhập lại")
    @NotBlank(message = "Không được phép để trống")

    private String emailCustomer;
    @NotBlank(message = "Không được phép để trống")
    @Size(max = 100, message = "Không vượt quá 100 ký tự")
    @Pattern(regexp = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ][\\s\\S]*$", message = "Không được nhật kí tự đặt biệt")
    private String addressCustomer;
    private List<Customer> customerList;

    public CustomerDto() {
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
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

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        for (int i = 0; i < customerDto.getCustomerList().size();i++){
            if(customerDto.getEmailCustomer().equals(customerDto.getCustomerList().get(i).getEmailCustomer())){
                errors.rejectValue("emailCustomer","email.error","non");
                break;

            }
        }
    }
}
