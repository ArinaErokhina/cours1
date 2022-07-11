package com.cours.cours;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam(name = "nameEmployee") String nameEmployee, @RequestParam(name = "surnameEmployee") String surnameEmployee) {
        Employee employee = new Employee(nameEmployee, surnameEmployee);
        return employeeService.addEmployee(employee);
    }

    @GetMapping(path = "/remove")
    public Employee deleteEmployee(@RequestParam(name = "nameEmployee") String nameEmployee, @RequestParam(name = "surnameEmployee") String surnameEmployee) {
        Employee employee = new Employee(nameEmployee, surnameEmployee);
        return employeeService.deleteEmployee(employee);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam(name = "nameEmployee") String nameEmployee, @RequestParam(name = "surnameEmployee") String surnameEmployee) {
        Employee employee = new Employee(nameEmployee, surnameEmployee);
        return employeeService.findEmployee(employee);
    }

    @GetMapping(path = "/all")
    public List<Employee> allEmployee() {
        return employeeService.allEmployee();
    }


}
