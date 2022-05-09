package com.proyecto1.banca.service;

import com.proyecto1.banca.model.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {

    Mono<Client> addClient(Client c);
    Flux<Client> getAllClient();
    Mono<Client> getById(Long id);
}
