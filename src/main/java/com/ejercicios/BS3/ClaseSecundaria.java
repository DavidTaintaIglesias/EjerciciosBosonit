package com.ejercicios.BS3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration //Etiqueta necesaria para CommandLineRunner
public class ClaseSecundaria implements CommandLineRunner {

  public void run(String... args) throws Exception {//metodo que se va a iniciar al instanciar la clase
    System.out.println("Hola desde clase secundaria");
  }

}
