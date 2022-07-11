package com.cours.cours;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("Иван", "Федоров"),
            new Employee("Алина", "Смирнова"),
            new Employee("Егор", "Прохоров"),
            new Employee("Роман", "Григорьев"),
            new Employee("Вера", "Кузнецова"),
            new Employee("Максим", "Сидоров"),
            new Employee("Андрей", "Васильев"),
            new Employee("Валерия", "Коровина"),
            new Employee("Ivan", "Ivanov"),
            new Employee("Дмитрий", "Дробков")
    ));
    private static int maxEmployeeCount = 11;

    public Employee addEmployee(Employee employee) {
        if (employee.getNameEmployee() == null || employee.getSurnameEmployee() == null) {
            throw new EmployeeDataEnteredIncorrectlyException();
        }
        if (maxEmployeeCount == employees.size()) {
            throw new EmployeeStorageIsFullException();
        }
        for (int i = 0; i < employees.size(); i++) {
            if (employee.equals(employees.get(i))) {
                throw new EmployeeAlreadyAddedException();
            }
        }
        employees.add(employee);
        return employee;
    }

    public Employee deleteEmployee(Employee employee) {
        if (employee.getNameEmployee() == null || employee.getSurnameEmployee() == null) {
            throw new EmployeeDataEnteredIncorrectlyException();
        }
        for (int i = 0; i < employees.size(); i++) {
            if (employee.equals(employees.get(i)))
                return employees.remove(i);
        }
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(Employee employee) {
        if (employee.getNameEmployee() == null || employee.getSurnameEmployee() == null) {
            throw new EmployeeDataEnteredIncorrectlyException();
        }
        for (int i = 0; i < employees.size(); i++) {
            if (employee.equals(employees.get(i))) {
                return employees.get(i);
            }
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> allEmployee() {
        return employees;
    }


}

