package com.proyecto1.banca.customer;

import com.proyecto1.banca.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class ClientImpl implements ClientInf{
    @Autowired
    private RestTemplate restTemplate;

    public Client findById(String id){
        return this.restTemplate.getForObject("http://localhost:8882/customers"+id, Client.class);
    }
}
