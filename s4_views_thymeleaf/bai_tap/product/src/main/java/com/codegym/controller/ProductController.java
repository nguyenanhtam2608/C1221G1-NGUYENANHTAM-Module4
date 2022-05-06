package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/products")
public class ProductController {


    @Autowired
    ProductServiceImpl productService;


    @GetMapping("")
    public String listProduct(Model model) {
        model.addAttribute("productList", productService.findALL());
        return "list";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("createProduct", new Product());
        return "create";
    }

    @PostMapping("save")
    public String save(Product product,RedirectAttributes redirectAttributes) {

        product.setId((int) (Math.random() * 1000));
        productService.save(product);

        redirectAttributes.addFlashAttribute("success","Save product successfully!");
        return "redirect:/products";
    }

    @GetMapping("search")
    public String search(Model model, @RequestParam String search) {
        model.addAttribute("productList", this.productService.findByName(search));
        return "list";

    }

    @GetMapping("/{id}/edit")
    public String showedit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("update")
    public String edit(Product product ,RedirectAttributes redirectAttributes) {
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("success","Update product successfully!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }
    @PostMapping("delete")
    public String delete(Product product, RedirectAttributes redirectAttributes){
              productService.remove(product.getId());
              redirectAttributes.addFlashAttribute("success","Removed product successfully!");

              return "redirect:/products";

    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }
}