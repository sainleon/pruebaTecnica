package org.example.pruebatecnica.controller;

import org.example.pruebatecnica.model.PalindromeRequest;
import org.example.pruebatecnica.model.PalindromeResponse;
import org.example.pruebatecnica.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
public class PalindromeController {
    @Autowired
    private PalindromeService palindromeService;

    @PostMapping("/palindrome")
    public PalindromeResponse checkPalindrome(@RequestBody PalindromeRequest request) {
        return palindromeService.verificarPalindromo(request);
    }
}
