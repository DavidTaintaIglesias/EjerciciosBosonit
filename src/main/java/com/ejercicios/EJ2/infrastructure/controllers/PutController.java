package com.ejercicios.EJ2.infrastructure.controllers;

import com.ejercicios.EJ2.application.PersonaService;
import com.ejercicios.EJ2.infrastructure.controllers.dto.input.PersonaInputDTO;
import com.ejercicios.EJ2.infrastructure.controllers.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/EJ2")
public class PutController {

  @Autowired
  PersonaService personaService;

  //Modificar por id (problemas con el autoincrement)
  @PutMapping("/put/{id}")
  public PersonaOutputDTO putById(@PathVariable int id, @RequestBody PersonaInputDTO personaInputDTO) throws EmptyResultDataAccessException {

    return personaService.putById(id, personaInputDTO);
  }

}