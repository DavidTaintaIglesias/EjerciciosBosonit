package com.ejercicios.BS8.infrastructure.controllers;

import com.ejercicios.BS8.aplication.services.PostPersonaService;
import com.ejercicios.BS8.infrastructure.controllers.dto.input.PersonaInputDTO;
import com.ejercicios.BS8.infrastructure.controllers.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/BS8/post")
public class PostPersonaController {

  @Autowired
  PostPersonaService postPersonService;

  @PostMapping
  public PersonaOutputDTO postPersona(@RequestBody PersonaInputDTO personaInputDTO) {

    return postPersonService.addPersona(personaInputDTO);
  }

}
