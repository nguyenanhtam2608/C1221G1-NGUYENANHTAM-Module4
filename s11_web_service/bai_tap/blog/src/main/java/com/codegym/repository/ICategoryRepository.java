package com.codegym.repository;

import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findAll();
//    Page<Category> findAllCategory(Pageable pageable);

}
