package com.codegym.controller;

import com.codegym.dto.CategoryDto;
import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping(value = "/blogDto")
@RestController
public class RestDtoController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Blog>> getPageBlog(
            @RequestParam("search") Optional<String> name,
            @RequestParam Optional<String> sort,
            @PageableDefault(value = 4, sort = {}) Pageable pageable
    ) {
        String nameSearch = name.orElse("");


        Page<Blog> blogPage = this.blogService.findByNameContaining(nameSearch, pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);

    }


    @GetMapping(value = "/listCategory")
    public ResponseEntity<Page<Category>> getPageCategory(
            @PageableDefault(value = 10, sort = {}) Pageable pageable
    ) {
        Page<Category> categoryPage = this.categoryService.findAllPaging(pageable);
        if (!categoryPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryPage, HttpStatus.OK);
    }

    @GetMapping(value = "/listBlogByCate")// sau getMapPing truyền dấu ?đằng sau ? là @RequestParam
    public ResponseEntity<Page<Blog>> getPageBlogByCategory(
            @RequestParam("search") Optional<String> category,
            @RequestParam Optional<String> sort,
            @PageableDefault(value = 2, sort = {}) Pageable pageable

    ) {
        String categorys = category.orElse("");
        Page<Blog> blogPage = this.blogService.findByCategory(categorys, pageable);


        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);

    }


    @GetMapping(value = "/viewBlog")
    public ResponseEntity<Blog> getBlogView(@RequestParam int id) {

        Blog blog = this.blogService.findById(id);

        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
