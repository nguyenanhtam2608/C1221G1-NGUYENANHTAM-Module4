package com.codegym.controller;

import com.codegym.model.YTe;
import com.codegym.service.YTeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class YTeController {

    @Autowired
    YTeService yTeService;

    @GetMapping("/")
    public String create(Model model) {
        model.addAttribute("yTe", new YTe());
        return "create";
    }

    @GetMapping("/list")
    public String listYte(Model model) {
        model.addAttribute("list", this.yTeService.listYTe());
        return "list";
    }


    @PostMapping
    public String list(@ModelAttribute YTe yTe, Model model) {
        this.yTeService.save(yTe);
        return "redirect:/list";
    }
}
