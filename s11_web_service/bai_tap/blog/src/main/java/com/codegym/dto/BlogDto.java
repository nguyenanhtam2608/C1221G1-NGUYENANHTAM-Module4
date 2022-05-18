package com.codegym.dto;

import com.codegym.model.Category;

public class BlogDto {
    private int id;
    private String name;
    private String contend;
    private String author;
    private Category category;

    public BlogDto(int id, String name, String contend, String author, Category category) {
        this.id = id;
        this.name = name;
        this.contend = contend;
        this.author = author;
        this.category = category;
    }

    public BlogDto() {
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

    public String getContend() {
        return contend;
    }

    public void setContend(String contend) {
        this.contend = contend;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
