package com.proyecto1.banca.controller;

import com.proyecto1.banca.model.Client;
import com.proyecto1.banca.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class ClientController {
    @Autowired
    ClientService clientService;
    @PostMapping("/clients")
    public ResponseEntity<Mono<Client>> createCli(@RequestBody Client client){
        return  new ResponseEntity<>(clientService.addClient(client), HttpStatus.CREATED);
    }

    @GetMapping("/clients")
    public ResponseEntity<Flux<Client>> getAllCli(){
        return new ResponseEntity<>(clientService.getAllClient(), HttpStatus.OK);
    }
    @GetMapping("/clients/{id}")
    public ResponseEntity<Mono<Client>> getAllCLient(@PathVariable("id")Long id){
        return new ResponseEntity<>(clientService.getById(id), HttpStatus.OK);
    }
}
