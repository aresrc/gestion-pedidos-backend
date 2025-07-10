package com.gestionpedidos.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Encoders;
import javax.crypto.SecretKey;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SecretKey key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS512);
		String base64Key = Encoders.BASE64.encode(key.getEncoded());
		System.out.println(base64Key);
		SpringApplication.run(BackendApplication.class, args);
	}
}
