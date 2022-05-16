package com.ejercicios.DBA1.infrastructure.controllers;

import com.ejercicios.DBA1.application.services.PersonaServiceDBA1;
import com.ejercicios.DBA1.infrastructure.controllers.dto.input.PersonaInputDTODBA1;
import com.ejercicios.DBA1.infrastructure.controllers.dto.output.PersonaOutputDTODBA1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DBA1")
public class PostControllerDBA1 {

    @Autowired
    PersonaServiceDBA1 personaService;

    //Añadir persona
    @PostMapping("/postperson")// simbolo "|" -> alt+124
    public PersonaOutputDTODBA1 setPersona(@RequestBody PersonaInputDTODBA1 persona) throws Exception{
        return new PersonaOutputDTODBA1(personaService.setPersona(persona));
    }
}