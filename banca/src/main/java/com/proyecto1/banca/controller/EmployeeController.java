package com.proyecto1.banca.controller;

import com.proyecto1.banca.model.Employee;
import com.proyecto1.banca.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<Mono<Employee>> createEmp(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }
    @GetMapping("/employees")
    public ResponseEntity<Flux<Employee>> getAllEmp(){
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Mono<Employee>> getAllEmp(@PathVariable("id" )Long id){
        return new ResponseEntity<>(employeeService.getById(id), HttpStatus.OK);
    }
}
