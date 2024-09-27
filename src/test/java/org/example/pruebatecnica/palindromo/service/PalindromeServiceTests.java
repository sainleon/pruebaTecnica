package org.example.pruebatecnica.palindromo.service;

import org.example.pruebatecnica.palindromo.model.PalindromeRequest;
import org.example.pruebatecnica.palindromo.model.PalindromeResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PalindromeServiceTests {
    private PalindromeService palindromeService;

    @BeforeEach
    public void setUp() {
        palindromeService = new PalindromeService();
    }

    @Test
    public void testVerificarPalindromo_True() {
        // Arrange
        PalindromeRequest request = new PalindromeRequest();
        request.setPalindromo("Anita lava la tina");

        // Act
        PalindromeResponse response = palindromeService.verificarPalindromo(request);

        // Assert
        assertNotNull(response);
        assertEquals(18, response.getLengthCadena());  // Longitud total de la cadena
        assertEquals(1, response.getIsPalindromo());    // Es palíndromo
        assertEquals(0, response.getLengthCaracteresEspeciales()); // No tiene caracteres especiales
    }

    @Test
    public void testVerificarPalindromo_False() {
        // Arrange
        PalindromeRequest request = new PalindromeRequest();
        request.setPalindromo("Hola mundo");

        // Act
        PalindromeResponse response = palindromeService.verificarPalindromo(request);

        // Assert
        assertNotNull(response);
        assertEquals(10, response.getLengthCadena());  // Longitud total de la cadena
        assertEquals(0, response.getIsPalindromo());    // No es palíndromo
        assertEquals(0, response.getLengthCaracteresEspeciales()); // No tiene caracteres especiales
    }

    @Test
    public void testVerificarPalindromo_WithSpecialCharacters() {
        // Arrange
        PalindromeRequest request = new PalindromeRequest();
        request.setPalindromo("A man, a plan, a canal: Panama!");

        // Act
        PalindromeResponse response = palindromeService.verificarPalindromo(request);

        // Assert
        assertNotNull(response);
        assertEquals(31, response.getLengthCadena());  // Longitud total de la cadena
        assertEquals(1, response.getIsPalindromo());    // Es palíndromo
        assertEquals(4, response.getLengthCaracteresEspeciales()); // 5 caracteres especiales (',', ':', '!')
    }

    @Test
    public void testVerificarPalindromo_EmptyString() {
        // Arrange
        PalindromeRequest request = new PalindromeRequest();
        request.setPalindromo("");

        // Act
        PalindromeResponse response = palindromeService.verificarPalindromo(request);

        // Assert
        assertNotNull(response);
        assertEquals(0, response.getLengthCadena());  // Longitud total de la cadena
        assertEquals(1, response.getIsPalindromo());    // Vacío es considerado palíndromo
        assertEquals(0, response.getLengthCaracteresEspeciales()); // No tiene caracteres especiales
    }
}
