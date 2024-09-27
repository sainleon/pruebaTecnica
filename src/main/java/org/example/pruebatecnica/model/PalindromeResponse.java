package org.example.pruebatecnica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PalindromeResponse {
    private int lengthCadena;                   // Longitud total de la cadena
    private int isPalindromo;                   // 1 si es palíndromo, 0 si no lo es
    private int lengthCaracteresEspeciales;     // Cantidad de caracteres especiales
}
