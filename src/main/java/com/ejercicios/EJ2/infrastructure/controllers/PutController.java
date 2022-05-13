package com.ejercicios.EJ2.infrastructure.controllers;

import com.ejercicios.EJ2.application.PersonaService;
import com.ejercicios.EJ2.domain.Persona;
import com.ejercicios.EJ2.infrastructure.controllers.dto.input.PersonaInputDTO;
import com.ejercicios.EJ2.infrastructure.controllers.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/EJ2")
public class PutController {

  @Autowired
  PersonaService personaService;

  //Modificar por id (problemas con el autoincrement)
  @PutMapping("{id}")
  public ResponseEntity<PersonaOutputDTO> editPersona(@PathVariable int id, @RequestBody PersonaInputDTO personaInputDTO) throws Exception {

    Persona newPersona = personaService.editPersona(id, personaInputDTO);

    PersonaOutputDTO outputDto = new PersonaOutputDTO(newPersona);

    return new ResponseEntity<>(outputDto, HttpStatus.OK);
  }

}