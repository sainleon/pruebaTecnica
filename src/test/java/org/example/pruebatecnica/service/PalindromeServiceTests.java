package org.example.pruebatecnica.service;

import org.example.pruebatecnica.model.PalindromeRequest;
import org.example.pruebatecnica.model.PalindromeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PalindromeServiceTests {
    private final PalindromeService palindromeService = new PalindromeService();

    @Test
    public void testProcessPalindrome() {
        PalindromeRequest request = new PalindromeRequest();
        request.setCadena("anilina");

        PalindromeResponse response = palindromeService.processPalindrome(request);

        assertEquals(7, response.getLengthCadena());
        assertTrue(response.isPalindromo());
        assertEquals(0, response.getLengthCaracteresEspeciales());
    }
}
