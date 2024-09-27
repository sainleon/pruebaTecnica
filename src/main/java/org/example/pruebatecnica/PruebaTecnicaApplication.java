package org.example.pruebatecnica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching // Habilitar el sistema de caché
public class PruebaTecnicaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PruebaTecnicaApplication.class, args);
    }

}
