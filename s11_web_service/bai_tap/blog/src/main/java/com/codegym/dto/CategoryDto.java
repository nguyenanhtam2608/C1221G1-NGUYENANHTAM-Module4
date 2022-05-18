package com.codegym.dto;

public class CategoryDto {
    private int id;
    private String nameCategory;

    public CategoryDto(int id, String nameCategory) {
        this.id = id;
        this.nameCategory = nameCategory;
    }

    public CategoryDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
