package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findALL();

    void save(Product product);

//    List<Product> findByName(String name);

    Product findById(int id);

    void update(Product product);

    void remove(Product product);
}
