package com.cours.cours;

import java.util.List;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);

    public Employee deleteEmployee(Employee employee);

    public Employee findEmployee(Employee employee);

    public List<Employee> allEmployee();

}
