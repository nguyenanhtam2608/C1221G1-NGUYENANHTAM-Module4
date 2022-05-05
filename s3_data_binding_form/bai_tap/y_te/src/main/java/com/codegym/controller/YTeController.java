package com.codegym.controller;

import com.codegym.model.YTe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class YTeController {

    @GetMapping("/")
    public String create(Model model) {
        model.addAttribute("yTe",new YTe());
        return "create";
    }
//
//    @PostMapping
//    public String saveYTe(@ModelAttribute YTe yTe){
//    }
    @PostMapping
    public String list(){
        return "list"
    }
}
