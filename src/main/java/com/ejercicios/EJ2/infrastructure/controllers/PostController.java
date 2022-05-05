package com.ejercicios.EJ2.infrastructure.controllers;

import com.ejercicios.EJ2.application.PersonaService;
import com.ejercicios.EJ2.infrastructure.controllers.dto.input.PersonaInputDTO;
import com.ejercicios.EJ2.infrastructure.controllers.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EJ2")
public class PostController {

    @Autowired
    PersonaService personaService;

    //Añadir persona
    @PostMapping("/postperson")// simbolo "|" -> alt+124
    public PersonaOutputDTO setPersona(@RequestBody PersonaInputDTO persona) throws Exception{
        return personaService.setPersona(persona);
    }
}