package com.example.final_pract.controllers;

import com.example.final_pract.models.Employees;
import com.example.final_pract.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class EmployeesController {

    @Autowired
    private EmployeesRepository employeesRepository;

    @GetMapping
    public List<Employees> getAllEmployees() {
        return employeesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employees> getEmployeeById(@PathVariable Integer id) {
        Optional<Employees> employee = employeesRepository.findById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Employees createEmployee(@RequestBody Employees employee) {
        return employeesRepository.save(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employees> updateEmployee(@PathVariable Integer id, @RequestBody Employees employeeDetails) {
        Optional<Employees> existingEmployee = employeesRepository.findById(id);
        if (existingEmployee.isPresent()) {
            Employees employee = existingEmployee.get();
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setSecondName(employeeDetails.getSecondName());
            employee.setThirdName(employeeDetails.getThirdName());
            employee.setRole(employeeDetails.getRole());
            employee.setDealer(employeeDetails.getDealer());
            return ResponseEntity.ok(employeesRepository.save(employee));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        Optional<Employees> employee = employeesRepository.findById(id);
        if (employee.isPresent()) {
            employeesRepository.delete(employee.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
