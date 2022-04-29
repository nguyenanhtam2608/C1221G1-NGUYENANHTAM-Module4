package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversionController {


    @GetMapping("/")
    public String currencyConversion(){
        return "/home";
    }

    @PostMapping
    public String currency (@RequestParam Integer vnd , Model model){

        int usd = 23000*vnd;
        model.addAttribute("usd",usd);
        return "result";
    }




}
