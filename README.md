# Proyecto Spring Boot - Consumo de API Externa y Microservicio de Palíndromos

## Descripción
Este proyecto contiene dos funcionalidades principales:
1. Este proyecto es una aplicación Spring Boot que consume una API externa (JSONPlaceholder) para obtener una lista de usuarios y exponerla mediante un nuevo endpoint. Además, se implementan prácticas de manejo de errores, inyección de dependencias, pruebas unitarias y un sistema de caché.

2. Microservicio de Palíndromos: Este microservicio recibe un JSON con un parámetro palindromo y responde con:
   - lengthCadena: Longitud total de la cadena.
   - isPalindromo: Indica si la cadena es un palíndromo.
   - lengthCaracteresEspeciales: Número de caracteres especiales en la cadena.
   


## Requisitos
- Java 17 o superior
- Maven 3.5+
- IDE de tu preferencia (IntelliJ IDEA, Eclipse, VSCode, etc.)

## Dependencias
Las siguientes dependencias son necesarias para el proyecto:
- Spring Web
- Spring Boot DevTools
- Spring Boot Test
- Spring Boot Cache
- Lombok

**Clonar el repositorio:**
   
   git clone https://github.com/sainleon/pruebaTecnica

## Importar el proyecto en IntelliJ IDEA:
- Abrir IntelliJ IDEA.
Seleccionar File > Open... y elegir la carpeta del proyecto.
IntelliJ IDEA detectará automáticamente el proyecto como un proyecto de Maven y descargará las dependencias necesarias
- Ejecutar la aplicación: En IntelliJ IDEA, navegar a la clase principal com.example.PruebaTecnicaApplication y hacer clic derecho para seleccionar Run 'PruebaTecnicaApplication'.

## Endpoints Disponibles
1. Consumo de API Externa (Usuarios)
- Endpoint: http://localhost:8080/users
- Método HTTP: GET
- Descripción: Obtiene la lista de usuarios desde la API externa de JSONPlaceholder.

2. Microservicio de Palíndromos
- Endpoint: http://localhost:8080/palindrome
- Método HTTP: POST
- Descripción: Recibe una cadena de texto en formato JSON y devuelve si es un palíndromo, su longitud y el conteo de caracteres especiales.

Ejemplo de JSON de entrada:
{
"palindromo": "Anita lava la tina"
}
Respuesta esperada:
{
"lengthCadena": 18,
"isPalindromo": 1,
"lengthCaracteresEspeciales": 0
}






