package org.example.pruebatecnica.service;

import org.example.pruebatecnica.model.PalindromeRequest;
import org.example.pruebatecnica.model.PalindromeResponse;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PalindromeService {
    public PalindromeResponse processPalindrome(PalindromeRequest request) {
        String cadena = request.getCadena();
        log.info("INFO: CADENA "+cadena);
        int lengthCadena = cadena.length();
        boolean isPalindromo = new StringBuilder(cadena).reverse().toString().equals(cadena);
        int lengthCaracteresEspeciales = cadena.replaceAll("[a-zA-Z0-9]", "").length();

        PalindromeResponse response = new PalindromeResponse();
        response.setLengthCadena(lengthCadena);
        response.setPalindromo(isPalindromo);
        response.setLengthCaracteresEspeciales(lengthCaracteresEspeciales);

        return response;
    }
}
