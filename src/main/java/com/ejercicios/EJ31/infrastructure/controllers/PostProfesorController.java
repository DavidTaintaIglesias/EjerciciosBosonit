package com.ejercicios.EJ31.infrastructure.controllers;

import com.ejercicios.EJ31.aplication.services.PostProfesorService;
import com.ejercicios.EJ31.infrastructure.controllers.dto.input.ProfesorInputDTO;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EJ31")
public class PostProfesorController {

    @Autowired
    PostProfesorService postProfesorService;

    @PostMapping("/postprofesor")
    public ProfesorOutputDTO postProfesor(@RequestBody ProfesorInputDTO profesorInputDTO){
        return postProfesorService.postProfesor(profesorInputDTO);
    }
}
