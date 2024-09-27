package org.example.pruebatecnica.palindromo.service;

import org.example.pruebatecnica.palindromo.model.PalindromeRequest;
import org.example.pruebatecnica.palindromo.model.PalindromeResponse;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PalindromeService {

    public PalindromeResponse verificarPalindromo(PalindromeRequest request) {
        String cadena = request.getPalindromo().replaceAll("[^a-zA-Z]", "").toLowerCase();  // Remover espacios y caracteres especiales
        String reversa = new StringBuilder(cadena).reverse().toString().toLowerCase();

        boolean esPalindromo = cadena.equals(reversa);

        int totalCaracteresEspeciales = request.getPalindromo().replaceAll("[a-zA-Z\\s]", "").length();
        int longitudCadena = request.getPalindromo().length();

        PalindromeResponse response = new PalindromeResponse();
        response.setLengthCadena(longitudCadena);
        response.setIsPalindromo(esPalindromo ? 1 : 0);
        response.setLengthCaracteresEspeciales(totalCaracteresEspeciales);

        return response;
    }
}
