package com.codegym.dto;

import com.codegym.model.Category;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class ProductDto {

    private int id;

    @NotBlank(message = "Không được phép để trống")
    @Size(max = 100, message = "Không vượt quá 100 ký tự")
    @Pattern(regexp = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ][\\s\\S]*$", message = "Không được nhật kí tự đặt biệt")
    private String name;

    @Range(min=1,message = "Giá không được bằng 0 hoặc âm")
    private Double price;

    @NotBlank(message = "Không được phép để trống")
    @Size(max = 1000, message = "Không vượt quá 1000 ký tự")
    @Pattern(regexp = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ][\\s\\S]*$", message = "Không được nhật kí tự đặt biệt")
    private String description;

    @NotBlank(message = "Không được phép để trống")
    @Size(max = 1000, message = "Không vượt quá 1000 ký tự")
    private String producer;

    private Category category;

    public ProductDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
