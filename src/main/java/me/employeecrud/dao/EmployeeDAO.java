package me.employeecrud.dao;

import me.employeecrud.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
