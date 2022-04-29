package com.example.ejercicioEJ2Refactorizado.infrastructure.controllers;

import com.example.ejercicioEJ2Refactorizado.application.PersonaService;
import com.example.ejercicioEJ2Refactorizado.infrastructure.controllers.dto.input.PersonaInputDTO;
import com.example.ejercicioEJ2Refactorizado.infrastructure.controllers.dto.output.PersonaOutputDTO;
import com.example.ejercicioEJ2Refactorizado.infrastructure.errorcontroller.UnprocessableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    PersonaService personaService;

    //Añadir persona
    @PostMapping("/postperson")// simbolo "|" -> alt+124
    public PersonaOutputDTO setPersona(@RequestBody PersonaInputDTO persona){
        try{
            return personaService.setPersona(persona);
        } catch (Exception e){
            throw new UnprocessableException("El usuario debe tener entre 6 y 10 caracteres");
        }
    }
}