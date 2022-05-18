package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;



    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("creteBlog", new Blog());
        model.addAttribute("category", categoryService.findAll());
        return "create";

    }

    @PostMapping("create")
    public String create(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("success", "THÊM MỚI THÀNH CÔNG");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/showEdit")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("showEdit", blogService.findById(id));
        model.addAttribute("category", categoryService.findAll());
        return "edit";
    }

    @PostMapping("edit")
    public String edit(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("success", "Update product successfully!");
        return "redirect:/blog";
    }


    @PostMapping("delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.delete(blog);
        redirectAttributes.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/blog";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("view", blogService.findById(id));
        return "view";
    }


    @GetMapping(value = {"search", ""})
    public String listUpdate(
            @RequestParam("search") Optional<String> name,
            @RequestParam Optional<String> sort,
            @PageableDefault(value = 4 , sort = {}) Pageable pageable,
            Model model
            ) {
        String nameSearch = name.orElse("");
        String sortBy = sort.orElse("");

        model.addAttribute("listBlog", this.blogService.findByNameContaining(nameSearch, pageable));
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("sortBy", sortBy);
        return "list";
    }


}