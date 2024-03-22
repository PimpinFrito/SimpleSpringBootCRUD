package me.employeecrud.Service;

import me.employeecrud.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> findAll();

    Employee findById(Long employeeId);

    void deleteById(Long employeeId);
}
