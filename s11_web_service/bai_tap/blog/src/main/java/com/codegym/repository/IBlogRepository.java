package com.codegym.repository;

import com.codegym.model.Blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByNameContaining(String name, Pageable pageable);

    @Query(value = "select * from blog where category_id = :category",
            countQuery = "select *  from blog where category_id = :category", nativeQuery = true)
    Page<Blog> findByCategory(String category, Pageable pageable);


}
