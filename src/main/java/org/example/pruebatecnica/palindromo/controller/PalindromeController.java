package org.example.pruebatecnica.palindromo.controller;

import org.example.pruebatecnica.palindromo.model.PalindromeRequest;
import org.example.pruebatecnica.palindromo.model.PalindromeResponse;
import org.example.pruebatecnica.palindromo.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeController {
    @Autowired
    private PalindromeService palindromeService;

    @PostMapping("/palindrome")
    public PalindromeResponse checkPalindrome(@RequestBody PalindromeRequest request) {
        return palindromeService.verificarPalindromo(request);
    }
}
