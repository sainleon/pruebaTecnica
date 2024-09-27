package org.example.pruebatecnica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PalindromeResponse {
    private int lengthCadena;
    private boolean isPalindromo;
    private int lengthCaracteresEspeciales;
}
