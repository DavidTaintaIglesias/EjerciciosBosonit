package com.ejercicios.BS2.service;

//Servicio que realiza las funciones de recogida y llamada de persona

import com.ejercicios.BS2.model.Persona;
import org.springframework.stereotype.Service;

@Service
public class PersonaService1 {

  Persona personaFinal;

  public Persona postPersona(Persona p) {

    personaFinal = p;
    personaFinal.setEdad(p.getEdad() + 10);
    return personaFinal;
  }

  public Persona getPersona() {

    return personaFinal;
  }

}
