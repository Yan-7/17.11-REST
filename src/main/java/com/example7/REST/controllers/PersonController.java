package com.example7.REST.controllers;

import com.example7.REST.entity.Employee;
import com.example7.REST.exceptions.EmployeeSystemException;
import com.example7.REST.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

// TODO: 08/12/2022 not wroking

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return service.create(employee);
    }

//	@GetMapping("/x/{employeeId}")
//	public ResponseEntity<?> read1(@PathVariable int employeeId) {
//		try {
//			Employee emp = service.read(employeeId);
//			return ResponseEntity.ok(emp);
//		} catch (EmployeeSystemException e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//		}
//	}

    @GetMapping("/{employeeId}")
    public Employee read(@PathVariable int employeeId) {
        try {
            Employee emp = service.read(employeeId);
            return emp;
        } catch (EmployeeSystemException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @GetMapping
    public List<Employee> readAll() {
        return service.readAll();
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee) {
        return service.update(employee);
    }

    @DeleteMapping
    public void delete(int employeeId) {
        service.delete(employeeId);
    }

}

