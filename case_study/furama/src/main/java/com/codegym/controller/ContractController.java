package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.dto.CustomerDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import com.codegym.service.Contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.service.IServiceService;
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
@RequestMapping("contract")
public class ContractController {
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IServiceService iServiceService;
    @Autowired
    IContractService iContractService;

    @GetMapping("")
    public String list(@RequestParam("searchCustomer") Optional<String> searchCustomer,
                       @RequestParam("searchEmployee") Optional<String> searchEmployee,
                       @RequestParam("searchService") Optional<String> searchService,
                       @RequestParam Optional<String> sort,
                       @PageableDefault(value = 2, sort = {}) Pageable pageable,
                       Model model) {
        String sortBy = sort.orElse("");
        String sCustomer = searchCustomer.orElse("%");
        String sEmployee = searchEmployee.orElse("%");
        String sService = searchService.orElse("%");
        model.addAttribute("sCustomer", sCustomer);
        model.addAttribute("sEmployee", sEmployee);
        model.addAttribute("sService", sService);
        model.addAttribute("customer", this.iCustomerService.findAll());
        model.addAttribute("employee", this.iEmployeeService.findAll());
        model.addAttribute("service", this.iServiceService.findAll());
        model.addAttribute("sortBy", sortBy);
//        model.addAttribute("list", this.iCustomerService.findCustomerByNameCustomerContainingAndEmailCustomerContaining(searchName, searchEmail, pageable));
        model.addAttribute("list", this.iContractService.findAllAndSearch(sCustomer, sEmployee, sService, pageable));
//        model.addAttribute("list", this.iContractService.findAll(pageable));
        return "/contract/list";
    }

    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("contractDto", new Contract());//gióng nhau
        model.addAttribute("customer", this.iCustomerService.findAll());
        model.addAttribute("employee", this.iEmployeeService.findAll());
        model.addAttribute("service", this.iServiceService.findAll());
        return "/contract/create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute @Validated ContractDto contractDto,// giống nhau
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customer", this.iCustomerService.findAll());
            model.addAttribute("employee", this.iEmployeeService.findAll());
            model.addAttribute("service", this.iServiceService.findAll());
            return "/contract/create";

        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            iContractService.save(contract);
            redirectAttributes.addFlashAttribute("success", "Save Contract successfully!");
            return "redirect:/contract";
        }

    }

}
