package com.codegym.controller;


import com.codegym.service.CurrencyService;
import com.codegym.service.Impl.CurrencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversionController {
    @Autowired
    CurrencyServiceImpl currencyService;

    @GetMapping("/")
    public String currencyConversion() {
        return "/home";
    }

    @PostMapping
    public String currency(@RequestParam Integer vnd, Model model) {
        model.addAttribute("usd",this.currencyService.currency(vnd) );
        return "result";
    }


}
