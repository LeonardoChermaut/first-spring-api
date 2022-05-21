package com.dev.firstapi.resources;

import com.dev.firstapi.models.Employee;
import com.dev.firstapi.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeResource {

    @Autowired
    EmployeeRepository employeeRepository;


    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> list = employeeRepository.findAll();
        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
       Employee employee = employeeRepository.findById(id).get();
        return ResponseEntity.ok().body(employee);

    }
}
