package com.codegym.controller;

import com.codegym.service.impl.CaculatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {

    @Autowired
    CaculatorServiceImpl caculatorService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping()
    public String result(@RequestParam double first, @RequestParam double second, @RequestParam String operator, Model model) {

        model.addAttribute("result", this.caculatorService.caculatorService(first,second,operator));
        return "result";


    }


}

