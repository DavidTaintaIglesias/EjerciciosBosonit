package com.example.ejercicioBS8.infrastructure.controllers;

import com.example.ejercicioBS8.application.services.PostPersonService;
import com.example.ejercicioBS8.infrastructure.controllers.dto.input.PersonaInputDTO;
import com.example.ejercicioBS8.infrastructure.controllers.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostPersonController {

    @Autowired
    PostPersonService postPersonService;

    @PostMapping
    public PersonaOutputDTO postPersona(@RequestBody PersonaInputDTO personaInputDTO){
        return postPersonService.addPersona(personaInputDTO);
    }
}
