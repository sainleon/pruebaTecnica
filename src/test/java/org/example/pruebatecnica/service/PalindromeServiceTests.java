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
        request.setPalindromo("anilina");

        PalindromeResponse response = palindromeService.verificarPalindromo(request);

        assertEquals(7, response.getLengthCadena());
        assertEquals(1, response.getIsPalindromo());
        assertEquals(0, response.getLengthCaracteresEspeciales());
    }

    @Test
    public void testPalindromeWithSpacesAndSpecialCharacters() {
        PalindromeRequest request = new PalindromeRequest();
        request.setPalindromo("anita lava la tina!!!");

        PalindromeResponse response = palindromeService.verificarPalindromo(request);

        assertEquals(21, response.getLengthCadena());
        assertEquals(0, response.getIsPalindromo());
        assertEquals(3, response.getLengthCaracteresEspeciales());  // 3 signos de exclamación
    }
}
