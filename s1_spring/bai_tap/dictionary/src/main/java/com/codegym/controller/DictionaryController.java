package com.codegym.controller;

import com.codegym.service.DictionaryService;
import com.codegym.service.impl.DictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;



@Controller
public class DictionaryController {
    @Autowired
    private DictionaryServiceImpl dictionaryService;

        @GetMapping("/")
    public String home() {
        return "home";
    }


    @PostMapping
    public String result(@RequestParam String nuocngoai, Model model) {


        model.addAttribute("result",this.dictionaryService.stringMap(nuocngoai));

        return "result";



    }

}
