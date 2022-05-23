package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.EmployeeDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.service.employee.IDivisionService;
import com.codegym.service.employee.IEducationDegreeService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.employee.IPositionService;
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
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    IEducationDegreeService iEducationDegreeService;

    @Autowired
    IDivisionService iDivisionService;

    @Autowired
    IPositionService iPositionService;


    @GetMapping("")

    public String list(@RequestParam("searchName") Optional<String> nameEmployee,
                       @RequestParam("searchEmail") Optional<String> emailEmployee,
                       @RequestParam("searchDivision") Optional<String> division,
                       @RequestParam("searchEducation") Optional<String> education,
                       @RequestParam("searchPosition") Optional<String> position,
                       @RequestParam Optional<String> sort,
                       @PageableDefault(value = 2, sort = {}) Pageable pageable,
                       Model model) {
        String sortBy = sort.orElse("");
        String searchName = nameEmployee.orElse("");
        String searchEmail = emailEmployee.orElse("");
        String searchDivision = division.orElse("%");
        String searchEducation = education.orElse("%");
        String searchPosition = position.orElse("%");
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchEmail", searchEmail);
        model.addAttribute("searchDivision", searchDivision);
        model.addAttribute("searchEducation", searchEducation);
        model.addAttribute("searchPosition", searchPosition);
        model.addAttribute("division", this.iDivisionService.findAll());
        model.addAttribute("position", this.iPositionService.findAll());
        model.addAttribute("educationDegree", this.iEducationDegreeService.findAll());
//        model.addAttribute("list", this.iEmployeeService.findEmployeeByNameEmployeeContainingAndEmailEmployeeContaining(searchName, searchEmail, pageable));
        model.addAttribute("list",this.iEmployeeService.findAllAndSearch(searchName,searchEmail,searchDivision,searchEducation,searchPosition,pageable));
        model.addAttribute("sortBy", sortBy);
        return "/employee/list";
    }

    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());//gióng nhau
        model.addAttribute("division", this.iDivisionService.findAll());
        model.addAttribute("position", this.iPositionService.findAll());
        model.addAttribute("educationDegree", this.iEducationDegreeService.findAll());
        return "/employee/create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute @Validated EmployeeDto employeeDto,// giống nhau
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("division", this.iDivisionService.findAll());
            model.addAttribute("position", this.iPositionService.findAll());
            model.addAttribute("educationDegree", this.iEducationDegreeService.findAll());
            return "/employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            this.iEmployeeService.save(employee);
            redirectAttributes.addFlashAttribute("success", "Save Employee successfully!");
            return "redirect:/employee";
        }

    }

    @PostMapping("delete")
    public String delete(Employee employee, RedirectAttributes redirectAttributes) {
        iEmployeeService.delete(employee);
        redirectAttributes.addFlashAttribute("success", "Removed Employee successfully!");
        return "redirect:/employee/";
    }

    @GetMapping("/{id}/showEdit")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("employeeDto", iEmployeeService.findById(id));
        model.addAttribute("division", this.iDivisionService.findAll());
        model.addAttribute("position", this.iPositionService.findAll());
        model.addAttribute("educationDegree", this.iEducationDegreeService.findAll());
        return "employee/edit";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute @Validated EmployeeDto employeeDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("division", this.iDivisionService.findAll());
            model.addAttribute("position", this.iPositionService.findAll());
            model.addAttribute("educationDegree", this.iEducationDegreeService.findAll());
            return "/employee/edit";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            iEmployeeService.save(employee);
            redirectAttributes.addFlashAttribute("success", "Save employee successfully!");
            return "redirect:/employee/";
        }

    }
}
