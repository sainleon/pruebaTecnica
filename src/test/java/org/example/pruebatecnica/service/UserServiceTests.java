package org.example.pruebatecnica.service;

import org.example.pruebatecnica.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTests {
    @Mock
    private ExternalApiService externalApiService;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUsers() {
        MockitoAnnotations.openMocks(this);
        List<User> mockUsers = List.of(new User());
        when(externalApiService.getAllUsers()).thenReturn(mockUsers);

        List<User> users = userService.getUsers();
        assertEquals(1, users.size());
    }
}
