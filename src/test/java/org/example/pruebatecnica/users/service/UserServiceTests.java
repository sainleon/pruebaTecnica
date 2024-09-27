package org.example.pruebatecnica.users.service;

import org.example.pruebatecnica.users.config.RestTemplateConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.example.pruebatecnica.users.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class UserServiceTests {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ExternalApiService externalApiService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers_Success() {
        // Arrange
        User[] usersArray = {
                new User(1, "John Doe", "", "", null, "", "", null),
                new User(2, "Jane Smith", "", "", null, "", "", null)
        };
        ResponseEntity<User[]> responseEntity = new ResponseEntity<>(usersArray, HttpStatus.OK);
        when(restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class))
                .thenReturn(responseEntity);

        // Act
        List<User> users = externalApiService.getAllUsers();

        // Assert
        assertNotNull(users);
        assertEquals(2, users.size());
        assertEquals("John Doe", users.get(0).getName());
        assertEquals("Jane Smith", users.get(1).getName());
    }

    @Test
    public void testGetAllUsers_RestClientException() {
        // Arrange
        when(restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class))
                .thenThrow(new RestClientException("Service Unavailable"));

        // Act & Assert
        RestClientException thrown = assertThrows(RestClientException.class, () -> {
            externalApiService.getAllUsers();
        });
        assertEquals("Service Unavailable", thrown.getMessage());
    }

    @Test
    public void testGetAllUsers_UnexpectedException() {
        // Arrange
        when(restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class))
                .thenThrow(new RuntimeException("Unexpected Error"));

        // Act & Assert
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            externalApiService.getAllUsers();
        });
        assertEquals("Unexpected Error", thrown.getMessage());
    }
}
