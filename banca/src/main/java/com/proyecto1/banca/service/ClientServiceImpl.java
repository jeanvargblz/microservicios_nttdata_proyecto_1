package com.proyecto1.banca.service;

import com.proyecto1.banca.model.Client;
import com.proyecto1.banca.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Mono<Client> addClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public Flux<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Mono<Client> getById(Long id) {
        return clientRepository.findById(id);
    }
}
