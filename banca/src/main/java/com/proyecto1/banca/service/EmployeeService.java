package com.proyecto1.banca.service;
import com.proyecto1.banca.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface EmployeeService {
    Mono<Employee> addEmployee(Employee e);
    Flux<Employee> getAllEmployee();

    Mono<Employee> getById(Long id);
}
