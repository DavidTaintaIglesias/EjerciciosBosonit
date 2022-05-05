package com.ejercicios.BS3;

import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service//Necesario para usar @Autowired
public class ClaseInicial {

    @PostConstruct//Se ejecutara al instanciar la clase automaticamente
    public void ejecutarInicial(){
        System.out.println("Hola desde clase inicial");
    }
}
