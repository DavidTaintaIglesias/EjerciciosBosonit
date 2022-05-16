package com.ejercicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableFeignClients//Etiqueta para activar las interfaces Feign
//Puedo play varios main a la vez y cambiando en Enviroments Variables server.port=8081 y levantar tantos servers en diferentes puertos como quiera.
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
