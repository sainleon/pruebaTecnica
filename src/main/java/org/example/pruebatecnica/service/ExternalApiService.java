package org.example.pruebatecnica.service;

import org.example.pruebatecnica.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ExternalApiService {

    private final RestTemplate restTemplate;

    public ExternalApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> getAllUsers() {
        String url = "https://jsonplaceholder.typicode.com/users";
        try{
            ResponseEntity<User[]> response = restTemplate.getForEntity(url, User[].class);
            return Arrays.asList(response.getBody());
        } catch (HttpClientErrorException e){
            throw new RuntimeException("Error al obtener el usuario" + e.getMessage());
        }
    }

}
