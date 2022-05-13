package com.ejercicios.EJ2.infrastructure.controllers;

import com.ejercicios.EJ2.application.PersonaService;
import com.ejercicios.EJ2.infrastructure.controllers.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/EJ2")
public class GetController {

  @Autowired
  PersonaService personaService;

  //Ver todos los valores
  @GetMapping
  public List<PersonaOutputDTO> getPersonas() {

    return personaService.getAll().stream().map(PersonaOutputDTO::new).toList();
  }

  //Buscar por id
  @GetMapping("/{id}")
  public PersonaOutputDTO getPersonById(@PathVariable int id) throws Exception {

    return new PersonaOutputDTO(personaService.getById(id));
  }

  //Buscar por User
  @GetMapping("/getbyuser/{user}")
  public List<PersonaOutputDTO> getPersonByUser(@PathVariable String user) {

    return personaService.getByUser(user).stream().map(PersonaOutputDTO::new).toList();
  }

}