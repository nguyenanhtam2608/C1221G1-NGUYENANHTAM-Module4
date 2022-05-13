package com.codegym.controller;


import com.codegym.dto.UserDto;
import com.codegym.model.UserApp;
import com.codegym.service.IUserAppService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class UserController {
    @Autowired
    IUserAppService iUserAppService;

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("listUser",this.iUserAppService.findAll());
        return "list";
    }


    @GetMapping("/showCreate")
    public String showCreate(Model model){
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute @Validated UserDto userDto,
                                 BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes,Model model) {
        new UserDto().validate(userDto,bindingResult);
      if(bindingResult.hasFieldErrors()){
          return "create";
      }else {
          UserApp userApp = new UserApp();
          BeanUtils.copyProperties(userDto,userApp);
          iUserAppService.save(userApp);
          redirectAttributes.addFlashAttribute("success","GOOD");
          return "redirect:/list";
      }
    }
}
