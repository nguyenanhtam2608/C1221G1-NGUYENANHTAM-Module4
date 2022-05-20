package com.codegym.controller;

import com.codegym.model.customer.Customer;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    ICustomerServiceType iCustomerServiceType;

    @GetMapping("")
    public String list(@RequestParam("searchName") Optional<String> name,
                       @RequestParam("searchEmail") Optional<String> email,
                       @RequestParam("searchType") Optional<String> customerType,
                       @RequestParam Optional<String> sort,
                       @PageableDefault(value = 2, sort = {}) Pageable pageable,
                       Model model) {
        String sortBy = sort.orElse("");
        String searchName = name.orElse("");
        String searchEmail = email.orElse("");
        String searchType = customerType.orElse("");
        model.addAttribute("list", this.iCustomerService.findCustomerByNameCustomerContainingAndEmailCustomerContaining(searchName, searchEmail, pageable));


//        model.addAttribute("searchName",searchName);
//        model.addAttribute("searchEmail",searchEmail);
//        model.addAttribute("searchType  ",searchType);
//        model.addAttribute("list", this.iCustomerService.findCustomerByCustomerType(searchName,searchEmail,searchType, pageable));
        model.addAttribute("sortBy", sortBy);
        return "/customer/list";
    }

    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("create", new Customer());
        model.addAttribute("customerType", this.iCustomerServiceType.findAll());
        return "/customer/create";
    }

    @PostMapping("/save")
    public String create(RedirectAttributes redirectAttributes, Customer customer) {
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Save Customer successfully!");
        return "redirect:/customer/";
    }

    @PostMapping("delete")
    public String delete(Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.delete(customer);
        redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer/";
    }

    @GetMapping("/{id}/showEdit")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("showEdit", iCustomerService.findById(id));
        model.addAttribute("customerType", this.iCustomerServiceType.findAll());
        return "customer/edit";
    }

    @PostMapping("edit")
    public String edit(RedirectAttributes redirectAttributes, Customer customer) {
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Save Customer successfully!");
        return "redirect:/customer/";

    }
}
