package com.example7.REST.service;

import java.util.List;
import java.util.Optional;

import com.example7.REST.entity.Employee;
import com.example7.REST.exceptions.EmployeeSystemException;
import com.example7.REST.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public Employee create(Employee employee) throws EmployeeSystemException {
        if (!repo.existsById(employee.getId())) {
            return repo.save(employee);
        } else {
            throw new EmployeeSystemException("create employee failed - already exists");
        }
    }

    public Employee read(int employeeId) throws EmployeeSystemException {
        Optional<Employee> opt = repo.findById(employeeId);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new EmployeeSystemException("read employee failed - not found");
        }
    }

    public List<Employee> readAll() {
        return repo.findAll();
    }

    public Employee update(Employee employee) throws EmployeeSystemException {
        if (repo.existsById(employee.getId())) {
            return repo.save(employee);
        } else {
            throw new EmployeeSystemException("update employee failed - not found");
        }
    }

    public void delete(int employeeId) throws EmployeeSystemException {
        Optional<Employee> opt = repo.findById(employeeId);
        if (opt.isPresent()) {
            repo.deleteById(employeeId);
        } else {
            throw new EmployeeSystemException("delete employee failed - not found");
        }
    }
}