package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.BaseRepository;
import com.codegym.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> findALL() {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select s from Product s", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }


//    @Override
//    public List<Product> findByName(String name) {
//        List<Product> productList = new ArrayList<>();
//        for (Integer key : productMap.keySet()) {
//            if (productMap.get(key).getName().toLowerCase(Locale.ROOT).contains(name)) {
//                productList.add(productMap.get(key));
//            }
//        }
//        return productList;
//    }

    @Override
    public Product findById(int id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
//        Product productUpdate = findById(product.getId());
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Product productDelete = findById(product.getId());
        BaseRepository.entityManager.remove(productDelete);
        entityTransaction.commit();
    }
}