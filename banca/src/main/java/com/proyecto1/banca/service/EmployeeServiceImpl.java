package com.proyecto1.banca.service;
import com.proyecto1.banca.model.Employee;
import com.proyecto1.banca.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Mono<Employee> addEmployee(Employee e)
    {
        return employeeRepository.save(e);
    }

    @Override
    public Flux<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Mono<Employee> getById(Long id) {
        return employeeRepository.findById(id);
    }
}