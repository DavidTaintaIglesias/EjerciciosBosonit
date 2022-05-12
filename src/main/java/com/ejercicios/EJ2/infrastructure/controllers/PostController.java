package com.ejercicios.EJ2.infrastructure.controllers;

import com.ejercicios.EJ2.application.PersonaService;
import com.ejercicios.EJ2.domain.Persona;
import com.ejercicios.EJ2.infrastructure.controllers.dto.input.PersonaInputDTO;
import com.ejercicios.EJ2.infrastructure.controllers.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/EJ2")
public class PostController {

  @Autowired
  PersonaService personaService;

  //Añadir persona
  @PostMapping // simbolo "|" -> alt+124
  public ResponseEntity<PersonaOutputDTO> createPersona(@Valid @RequestBody PersonaInputDTO inputDto) {

    Persona newPersona = personaService.createPersona(inputDto);

    PersonaOutputDTO outputDTO = new PersonaOutputDTO(newPersona);

    return new ResponseEntity<>(outputDTO, HttpStatus.CREATED);
  }

}