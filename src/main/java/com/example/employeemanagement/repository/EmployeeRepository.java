package com.example.employeemanagement.repository;

import com.example.employeemanagement.entity.Employee;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    private final Map<Long, Employee> employeeMap = new HashMap<>();

    public Employee save(Employee employee) {
        employeeMap.put(employee.getId(), employee);
        return employee;
    }

    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(employeeMap.get(id));
    }

    public List<Employee> findAll() {
        return employeeMap.values().stream().collect(Collectors.toList());
    }

    public void delete(Long id) {
        employeeMap.remove(id);
    }

    public List<Employee> findByDepartment(String department) {
        return employeeMap.values().stream()
                .filter(emp -> emp.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }
}