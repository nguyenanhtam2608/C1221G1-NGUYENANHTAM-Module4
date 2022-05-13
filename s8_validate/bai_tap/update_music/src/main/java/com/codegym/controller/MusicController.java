package com.codegym.controller;

import com.codegym.dto.MusicDto;
import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("music")
@Controller
public class MusicController {

    @Autowired
    private IMusicService IMusicService;


    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("musicList", this.IMusicService.findAll());
        return "list";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute @Validated MusicDto musicDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }else {

            Music music =new Music();
            BeanUtils.copyProperties(musicDto,music);
            IMusicService.save(music);
            redirectAttributes.addFlashAttribute("success", "Save product successfully!");
            return "redirect:/music";
        }
    }

    @GetMapping("/{id}/showEdit")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("showEdit", IMusicService.findById(id));
        return "edit";
    }

    @PostMapping("edit")
    public String edit(Music music, RedirectAttributes redirectAttributes) {
        IMusicService.save(music);
        redirectAttributes.addFlashAttribute("success", "Update product successfully!");
        return "redirect:/music";
    }

    @GetMapping("/{id}/showDelete")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("showDelete", IMusicService.findById(id));
        return "delete";
    }

    @PostMapping("delete")
    public String delete(Music music, RedirectAttributes redirectAttributes) {
        IMusicService.delete(music);
        redirectAttributes.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/music";

    }

    @GetMapping("{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("viewMusic", IMusicService.findById(id));
        return "view";
    }
}



