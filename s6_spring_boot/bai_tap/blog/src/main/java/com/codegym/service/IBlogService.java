package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IBlogService {

    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void update(Blog blog);

    void delete(Blog blog);

    Page<Blog> findByNameContaining(String name, Pageable pageable);
//    List<Blog> findByOrderByNameAsc();


}
