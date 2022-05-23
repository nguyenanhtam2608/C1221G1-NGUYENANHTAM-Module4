package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerServiceType;
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
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    ICustomerServiceType iCustomerServiceType;

    @GetMapping("")
    public String list(@RequestParam("searchName") Optional<String> nameCustomer,
                       @RequestParam("searchEmail") Optional<String> emailCustomer,
                       @RequestParam("searchType") Optional<String> customerType,
                       @RequestParam Optional<String> sort,
                       @PageableDefault(value = 2, sort = {}) Pageable pageable,
                       Model model) {
        String sortBy = sort.orElse("");
        String searchName = nameCustomer.orElse("");
        String searchEmail = emailCustomer.orElse("");
        String searchType = customerType.orElse("%");
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchEmail", searchEmail);
        model.addAttribute("searchType", searchType);
        model.addAttribute("customerType", this.iCustomerServiceType.findAll());
        model.addAttribute("sortBy", sortBy);
//        model.addAttribute("list", this.iCustomerService.findCustomerByNameCustomerContainingAndEmailCustomerContaining(searchName, searchEmail, pageable));
        model.addAttribute("list",this.iCustomerService.findAllAndSearch(searchName,searchEmail,searchType,pageable));

        return "/customer/list";
    }

    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("customerDto", new Customer());//gióng nhau
        model.addAttribute("customerType", this.iCustomerServiceType.findAll());
        return "/customer/create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute @Validated CustomerDto customerDto,// giống nhau
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerType", this.iCustomerServiceType.findAll());
            return "/customer/create";

        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("success", "update Customer successfully!");
            return "redirect:/customer";
        }

    }

    @PostMapping("delete")
    public String delete(Customer customer, RedirectAttributes redirectAttributes   ) {
        iCustomerService.delete(customer);
        redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer/";
    }

    @GetMapping("/{id}/showEdit")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("customerDto", iCustomerService.findById(id));
        model.addAttribute("customerType", this.iCustomerServiceType.findAll());
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute @Validated CustomerDto customerDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerType", this.iCustomerServiceType.findAll());
            return "/customer/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("success", "Save Customer successfully!");
            return "redirect:/customer/";
        }

    }
}
