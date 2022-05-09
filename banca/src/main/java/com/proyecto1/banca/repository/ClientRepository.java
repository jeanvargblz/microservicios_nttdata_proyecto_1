package com.proyecto1.banca.repository;

import com.proyecto1.banca.model.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClientRepository extends ReactiveMongoRepository<Client, Long> {
}
