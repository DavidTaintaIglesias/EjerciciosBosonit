package com.ejercicios.JVA2.infrastructure.controllers;

import com.ejercicios.JVA2.application.services.PersonaServiceJVA2;
import com.ejercicios.JVA2.infrastructure.controllers.dto.input.PersonaInputDTOJVA2;
import com.ejercicios.JVA2.infrastructure.controllers.dto.output.PersonaOutputDTOJVA2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/JVA2")
public class PostControllerJVA2 {

    @Autowired
    PersonaServiceJVA2 personaService;

    //Añadir persona
    @PostMapping("/postperson")// simbolo "|" -> alt+124
    public ResponseEntity<PersonaOutputDTOJVA2> setPersona(@RequestBody PersonaInputDTOJVA2 persona) throws Exception{
        return new ResponseEntity<>(new PersonaOutputDTOJVA2(personaService.setPersona(persona)), HttpStatus.CREATED);
    }
}