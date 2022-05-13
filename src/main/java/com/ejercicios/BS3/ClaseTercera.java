package com.ejercicios.BS3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration //Comentarios en ClaseSecundaria
public class ClaseTercera implements CommandLineRunner {

  public void run(String... args) throws Exception {

    System.out.println("Soy la tercera clase");
  }

}
