package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("employeeList", employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/add_employee")
    public String showAddEmployeeFrom(Model model) {
        model.addAttribute("employee", new Employee());
        return "newEmployee";
    }

    @PostMapping("/add_employee")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/show_edit_employee/{id}")
    public String showEmployeeUpdate(@PathVariable("id") long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "newEmployee";
    }

    @GetMapping("/delete_employee/{id}")
    public String deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
