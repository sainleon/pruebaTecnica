package org.example.pruebatecnica.service;

import org.example.pruebatecnica.model.PalindromeRequest;
import org.example.pruebatecnica.model.PalindromeResponse;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PalindromeService {

    public PalindromeResponse verificarPalindromo(PalindromeRequest request) {
        String cadena = request.getPalindromo().replaceAll("\\s", "").toLowerCase();  // Remover espacios y caracteres especiales
        String reversa = new StringBuilder(cadena).reverse().toString();

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
