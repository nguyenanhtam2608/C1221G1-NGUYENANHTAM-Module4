package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MailController {

    @GetMapping("/")
    public String goUpdate(Model model) {
        model.addAttribute("mail", new Mail());
        return "update";
    }

    @PostMapping()
    public String update(@ModelAttribute Mail mail, RedirectAttributes redirectAttributes,Model model) {
        model.addAttribute("mail",mail);


        redirectAttributes.addFlashAttribute("msg", "Thành công");
        return "result";
    }


}
