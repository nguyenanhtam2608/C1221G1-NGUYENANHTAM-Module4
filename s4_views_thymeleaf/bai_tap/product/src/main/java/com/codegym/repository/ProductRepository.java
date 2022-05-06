package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> findALL();

    void save(Product product);

    List<Product> findByName(String name);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
}
