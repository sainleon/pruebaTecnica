package org.example.pruebatecnica.service;

import org.example.pruebatecnica.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private ExternalApiService externalApiService;

    @Cacheable("users")
    public List<User> getUsers(){
        return externalApiService.getAllUsers();
    }
}
