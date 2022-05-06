package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    static public Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "bánh", 20000.0, "Ngon", "Cosy"));
        productMap.put(2, new Product(2, "Kẹo", 2000.0, "Ngon", "Socola"));
        productMap.put(3, new Product(3, "Nước", 25000.0, "Ngon", "Dừa xiêm"));
    }

    @Override
    public List<Product> findALL() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }


    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Integer key : productMap.keySet()) {
            if (productMap.get(key).getName().toLowerCase(Locale.ROOT).contains(name)) {
                productList.add(productMap.get(key));
            }
        }
        return productList;
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}