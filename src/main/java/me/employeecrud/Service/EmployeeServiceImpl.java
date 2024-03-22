package me.employeecrud.Service;

import jakarta.transaction.Transactional;
import me.employeecrud.Entity.Employee;
import me.employeecrud.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.repository = employeeRepository;
    }
    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(Long employeeId) {
        Optional<Employee> result = repository.findById(employeeId);
        Employee employee;
        if(result.isPresent()){
            employee = result.get();
        }
        else{
            throw new RuntimeException("Employee Id doesn't exist in database");
        }
        return employee;
    }

    @Override
    public void deleteById(Long employeeId) {
        repository.deleteById(employeeId);
    }
}
