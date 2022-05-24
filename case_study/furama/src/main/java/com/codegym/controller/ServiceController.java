package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.ServiceDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.service.Service;
import com.codegym.service.service.IRentTypeService;
import com.codegym.service.service.IServiceService;
import com.codegym.service.service.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("service")
public class ServiceController {
    @Autowired
    IServiceService iServiceService;
    @Autowired
    IServiceTypeService iServiceTypeService;
    @Autowired
    IRentTypeService iRentTypeService;

    @GetMapping("")
    public String list(@RequestParam("searchName") Optional<String> nameService,
                       @RequestParam("searchRent") Optional<String> rentService,
                       @RequestParam("searchType") Optional<String> typeService,
                       @RequestParam Optional<String> sort,
                       @PageableDefault(value = 2, sort = {}) Pageable pageable,
                       Model model) {
        String sortBy = sort.orElse("");
        String searchName = nameService.orElse("");
        String searchRent = rentService.orElse("%");
        String searchType = typeService.orElse("%");
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchRent", searchRent);
        model.addAttribute("searchType", searchType);
        model.addAttribute("rentType", this.iRentTypeService.findAll());
        model.addAttribute("serviceType", this.iServiceTypeService.findAll());
        model.addAttribute("sortBy", sortBy);
//        model.addAttribute("list", this.iCustomerService.findCustomerByNameCustomerContainingAndEmailCustomerContaining(searchName, searchEmail, pageable));
        model.addAttribute("list", this.iServiceService.findAllAndSearch(searchName, searchRent, searchType, pageable));

        return "/service/list";
    }

    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("serviceDto", new Service());//gióng nhau
        model.addAttribute("rentType", this.iRentTypeService.findAll());
        model.addAttribute("serviceType", this.iServiceTypeService.findAll());
        return "/service/create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute @Validated ServiceDto serviceDto,// giống nhau
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("rentType", this.iRentTypeService.findAll());
            model.addAttribute("serviceType", this.iServiceTypeService.findAll());
            return "/service/create";

        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            iServiceService.save(service);
            redirectAttributes.addFlashAttribute("success", "Save Service successfully!");
            return "redirect:/service";
        }

    }

    @PostMapping("delete")
    public String delete(Service service, RedirectAttributes redirectAttributes) {
        iServiceService.delete(service);
        redirectAttributes.addFlashAttribute("success", "Removed service successfully!");
        return "redirect:/service/";
    }

    @GetMapping("/{id}/showEdit")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("serviceDto", iServiceService.findById(id));//gióng nhau
        model.addAttribute("rentType", this.iRentTypeService.findAll());
        model.addAttribute("serviceType", this.iServiceTypeService.findAll());

        return "service/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute @Validated ServiceDto serviceDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("rentType", this.iRentTypeService.findAll());
            model.addAttribute("serviceType", this.iServiceTypeService.findAll());
            return "/service/create";
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            iServiceService.save(service);
            redirectAttributes.addFlashAttribute("success", "Update Service successfully!");
            return "redirect:/service";
        }

    }
}
