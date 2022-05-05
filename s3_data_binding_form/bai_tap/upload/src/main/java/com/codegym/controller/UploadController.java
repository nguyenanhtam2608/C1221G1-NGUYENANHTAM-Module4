package com.codegym.controller;

import com.codegym.model.Upload;
import com.codegym.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UploadController {

    @Autowired
    UploadService uploadService;

    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("list", this.uploadService.listUpload());
        return "list";
    }

    @GetMapping("/upload")
    public String upload(Model model) {
        model.addAttribute("upload", new Upload());
        return "upload";
    }



    @PostMapping("/result")
    public String result(Model model, @ModelAttribute Upload upload) {
                this.uploadService.save(upload);
        return "redirect:/";
    }


}
