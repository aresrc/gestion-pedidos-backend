package com.gestionpedidos.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("123456")); // Imprime la contraseña cifrada para uso en pruebas
		SpringApplication.run(BackendApplication.class, args);
	}
}
