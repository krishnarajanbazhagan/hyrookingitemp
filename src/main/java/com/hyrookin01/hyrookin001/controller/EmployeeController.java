package com.hyrookin01.hyrookin001.controller;

import com.hyrookin01.hyrookin001.entity.Employee;
import com.hyrookin01.hyrookin001.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employees") // Changed for simplicity
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/add";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee, RedirectAttributes redirectAttrs) {
        employeeService.addEmployee(employee);
        redirectAttrs.addFlashAttribute("message", "Employee added successfully!");
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employees/edit";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id, @ModelAttribute Employee employee, RedirectAttributes redirectAttrs) {
        employeeService.updateEmployee(employee); // Your service should handle finding by ID and updating
        redirectAttrs.addFlashAttribute("message", "Employee updated successfully!");
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id, RedirectAttributes redirectAttrs) {
        employeeService.deleteEmployee(id);
        redirectAttrs.addFlashAttribute("message", "Employee deleted successfully!");
        return "redirect:/employees";
    }
}
