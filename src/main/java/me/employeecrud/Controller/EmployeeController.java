package me.employeecrud.Controller;


import me.employeecrud.Entity.Employee;
import me.employeecrud.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping({"/"})
    public String showEmployees(Model model){
        List<Employee> list = employeeRepository.findAll();
        model.addAttribute("employees", list);
        return "listEmployees";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employeePage";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee){
        employeeRepository.save(employee);
        return "redirect:/";
    }

    @GetMapping("/updateEmployee")
    public String updateEmployee(@RequestParam Long employeeId, Model model){
        Employee employee = employeeRepository.findById(employeeId).get();
        model.addAttribute("employee", employee);
        return "employeePage";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam Long employeeId){
        employeeRepository.deleteById(employeeId);
        return "redirect:/";
    }

}