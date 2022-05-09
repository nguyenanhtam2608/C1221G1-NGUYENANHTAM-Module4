package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@RequestMapping("music")
@Controller
public class MusicController {

    @Autowired
    private MusicService musicService;


    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("musicList", this.musicService.findAll());
        return "list";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("createMusic", new Music());
        return "create";
    }

    @PostMapping("create")
    public String create(Music music, RedirectAttributes redirectAttributes) {
        musicService.save(music);
        redirectAttributes.addFlashAttribute("success", "Save product successfully!");
        return "redirect:/music";
    }

    @GetMapping("/{id}/showEdit")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("showEdit", musicService.findById(id));
        return "edit";
    }

    @PostMapping("edit")
    public String edit(Music music, RedirectAttributes redirectAttributes) {
        musicService.update(music);
        redirectAttributes.addFlashAttribute("success", "Update product successfully!");
        return "redirect:/music";
    }

    @GetMapping("/{id}/showDelete")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("showDelete", musicService.findById(id));
        return "delete";
    }

    @PostMapping("delete")
    public String delete(Music music, RedirectAttributes redirectAttributes) {
        musicService.remove(music);
        redirectAttributes.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/music";

    }

    @GetMapping("{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("viewMusic", musicService.findById(id));
        return "view";
    }
}



