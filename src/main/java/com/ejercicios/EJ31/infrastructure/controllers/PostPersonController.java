package com.ejercicios.EJ31.infrastructure.controllers;

import com.ejercicios.EJ31.application.services.PostPersonService;
import com.ejercicios.EJ31.infrastructure.controllers.dto.input.PersonInputDTO;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/EJ31")
public class PostPersonController {

    @Autowired
    PostPersonService postPersonService;

    @PostMapping("/postPerson")
    public PersonOutputDTO postPerson(@Valid @RequestBody PersonInputDTO personInputDTO){
        return postPersonService.postPerson(personInputDTO);
    }
}
