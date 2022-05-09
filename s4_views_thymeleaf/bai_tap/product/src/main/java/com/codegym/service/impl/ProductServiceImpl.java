package com.codegym.service.impl;

import com.codegym.model.Product;

import com.codegym.repository.impl.ProductRepositoryImpl;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductServiceImpl implements ProductService {
    ProductRepositoryImpl productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findALL() {
        return productRepository.findALL();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

//    @Override
//    public List<Product> findByName(String name) {
//        return productRepository.findByName(name);
//    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public void remove(Product product) {
        productRepository.remove(product);
    }
}
