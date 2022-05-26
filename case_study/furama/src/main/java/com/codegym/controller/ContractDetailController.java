package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.dto.ContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.service.Contract.IAttServiceService;
import com.codegym.service.Contract.IContractDetailService;
import com.codegym.service.Contract.IContractService;
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
@RequestMapping("detail")
public class ContractDetailController {
    @Autowired
    IContractService iContractService;
    @Autowired
    IAttServiceService iAttServiceService;
    @Autowired
    IContractDetailService iContractDetailService;


    @GetMapping("")
    public String list(@RequestParam Optional<String> sort,
                       @PageableDefault(value = 2, sort = {}) Pageable pageable, Model model) {
        String sortBy = sort.orElse("");
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("contract", this.iContractService.findAll());
        model.addAttribute("attService", this.iAttServiceService.findAll());
        model.addAttribute("list", this.iContractDetailService.findAllContractDetail(pageable));

//        model.addAttribute("list", this.iCustomerService.findCustomerByNameCustomerContainingAndEmailCustomerContaining(searchName, searchEmail, pageable));
        return "/detail/list";
    }


    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("contractDetailDto", new ContractDetailDto());//gióng nhau
        model.addAttribute("contract", this.iContractService.findAll());
        model.addAttribute("attService", this.iAttServiceService.findAll());
        return "/detail/create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute @Validated ContractDetailDto contractDetailDto,// giống nhau
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("contract", this.iContractService.findAll());
            model.addAttribute("attService", this.iAttServiceService.findAll());
            return "/detail/create";

        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            iContractDetailService.save(contractDetail);
            redirectAttributes.addFlashAttribute("success", "Save Contract successfully!");
            return "redirect:/detail";
        }

    }


}
