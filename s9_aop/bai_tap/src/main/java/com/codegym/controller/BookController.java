package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.User;
import com.codegym.service.IBookService;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    IBookService iBookService;
    @Autowired
    IUserService iUserService;

    @GetMapping("")
    public String showListBook(Model model) {
        model.addAttribute("list", iBookService.findAll());
        return "list";
    }

    @GetMapping("/{id}/boorow")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("list", iBookService.findById(id));
        model.addAttribute("user", iUserService.findAll());
        return "edit";
    }

    @PostMapping("boorow")
    public String edit(Book book, RedirectAttributes redirectAttributes, Model model) {

        redirectAttributes.addFlashAttribute("user", this.iUserService.random(book));
        redirectAttributes.addFlashAttribute("users", book);
        redirectAttributes.addFlashAttribute("success", iBookService.borrow(book));
        return "redirect:/";
    }

    @GetMapping("/{id}/pay")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("list", iBookService.findById(id));
        model.addAttribute("user", iUserService.findAll());
        return "delete";
    }

    @PostMapping("pay")
    public String delete(@RequestParam String pay) {
        User user = this.iUserService.findAllByCode(pay);
        Book book = this.iBookService.findById(user.getBook().getId());
        this.iBookService.plus(book);
        iUserService.delete(user);

        return "redirect:/";
    }


    @ExceptionHandler(NullPointerException.class)
    public String showError() {
        return "error";
    }


}
