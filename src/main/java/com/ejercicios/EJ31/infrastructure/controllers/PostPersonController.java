package com.ejercicios.EJ31.infrastructure.controllers;

import com.ejercicios.EJ31.aplication.services.PostPersonService;
import com.ejercicios.EJ31.infrastructure.controllers.dto.input.PersonInputDTO;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EJ31/postperson")
public class PostPersonController {

    @Autowired
    PostPersonService postPersonService;

    @PostMapping
    public PersonOutputDTO postPersona(@RequestBody PersonInputDTO personaInputDTO){
        return postPersonService.addPersona(personaInputDTO);
    }
}
