package com.proyecto1.banca.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.proyecto1.banca.model.Product;
import org.springframework.http.*;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
@Log4j2
public class ProductImpl implements ProductImf{
    @Autowired
    private RestTemplate restTemplate;

    public Product findByIdCustomer(String id) {
        return this.restTemplate.getForObject("http://localhost:8084/products/findByIdCustomer/"+id, Product.class);
    }

    public Product findById(String id){
        return this.restTemplate.getForObject("http://localhost:8084/products/"+id, Product.class);
    }

    public Product save(Product product){
        long timeStarter = System.currentTimeMillis();
        Product response =new Product();
        ObjectMapper objectMapper = new ObjectMapper();
        String responseJson = null;

        String url = "http://localhost:8084/products/save";
        Integer timeOutConexion= 2;
        Integer timeOutExecution = 3;

        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);

            Gson gson = new Gson();
            String requesGson= gson.toJson(product);
            log.info("reques: {}",requesGson);
            HttpEntity<String> httpEntity = new HttpEntity<>(requesGson,httpHeaders);

            SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
            httpRequestFactory.setConnectTimeout(timeOutConexion);
            httpRequestFactory.setReadTimeout(timeOutExecution);

            RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    url, HttpMethod.POST, httpEntity, String.class);

            responseJson = responseEntity.getBody();
            response = objectMapper.readValue(responseJson, Product.class);

        }catch (HttpClientErrorException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
