package org.example.pruebatecnica.users.service;

import lombok.extern.slf4j.Slf4j;
import org.example.pruebatecnica.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class ExternalApiService {

    @Autowired
    private RestTemplate restTemplate;

    public ExternalApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> getAllUsers() {
        String url = "https://jsonplaceholder.typicode.com/users";
        try{
            ResponseEntity<User[]> response = restTemplate.getForEntity(url, User[].class);
            return Arrays.asList(response.getBody());
        } catch (RestClientException e) {
            log.info("Error al consumir el servicio externo: " + e.getMessage(), e);
            throw e;
        } catch (Exception e){
            log.info("Error inesperado: " + e.getMessage(), e);
            throw e;
        }
    }

}
