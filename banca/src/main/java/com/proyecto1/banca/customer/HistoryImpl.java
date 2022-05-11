package com.proyecto1.banca.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto1.banca.model.History;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
public class HistoryImpl implements HistoryInf{
    private static final Logger log = LoggerFactory.getLogger(HistoryImpl.class);

    public History save(History history) {
        long timeStart = System.currentTimeMillis();
        History resp = new History();
        ObjectMapper objectMapper = new ObjectMapper();
        String respJson = null;

        String url = "http://localhost:8087/history";
        Integer timeOutConexion=2;
        Integer timeOutExecution=3;

        try{
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);

            log.info("URL history: {}",url);
            log.info("Type: {}", HttpMethod.POST);

            Gson gson = new Gson();
            String requestGson= gson.toJson(history);
            log.info("request: {}",requestGson);
            HttpEntity<String> httpEntity = new HttpEntity<>(requestGson,httpHeaders);
            SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();

            RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);

            respJson = responseEntity.getBody();
            resp = objectMapper.readValue(respJson, History.class);

        }catch (HttpClientErrorException e){
            e.printStackTrace();

        }catch (Exception e){
            e.printStackTrace();
        }

        return resp;
    }
}
