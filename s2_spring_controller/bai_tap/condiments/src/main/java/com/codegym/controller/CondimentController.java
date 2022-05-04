package com.codegym.controller;

import com.codegym.service.impl.CondimentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CondimentController {

//    @Autowired
//    CondimentServiceImpl condimentService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@RequestParam(value = "condiment", defaultValue = "NULL") String[] condiment , Model model) {
        model.addAttribute("result", condiment);
        return "result";
    }


}






