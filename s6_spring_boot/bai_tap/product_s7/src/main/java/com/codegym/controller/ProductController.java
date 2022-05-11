package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.OpenOption;
import java.util.Optional;


@Controller
@RequestMapping("/products")
public class ProductController {


    @Autowired
    private ProductService productService;


    @GetMapping(value = {"search", ""})
    public String listProduct(
            @RequestParam("search") Optional<String> name,
            @RequestParam Optional<String> sort,
            @PageableDefault(value = 2, sort = {}) Pageable pageable,
            Model model
    ) {
        String nameSearch = name.orElse("");
        String sortBy = sort.orElse("");

        model.addAttribute("productList", this.productService.findByNameContaining(nameSearch, pageable));
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("sortBy", sortBy);
        return "list";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("createProduct", new Product());
        return "create";
    }

    @PostMapping("save")
    public String save(Product product, RedirectAttributes redirectAttributes) {

        productService.save(product);

        redirectAttributes.addFlashAttribute("success", "Save product successfully!");
        return "redirect:/products";
    }

//    @GetMapping("search")
//    public String search(Model model, @RequestParam String search) {
//        model.addAttribute("productList", this.productService.findByName(search));
//        return "list";
//
//    }

    @GetMapping("/{id}/edit")
    public String showedit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("update")
    public String edit(Product product, RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("success", "Update product successfully!");
        return "redirect:/products";
    }

    //
//    @GetMapping("/{id}/delete")
//    public String showDelete(@PathVariable int id, Model model) {
//        model.addAttribute("product", productService.findById(id));
//        return "delete";
//    }
    @PostMapping("delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        productService.delete(product);
        redirectAttributes.addFlashAttribute("success", "Removed product successfully!");

        return "redirect:/products";

    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }
}