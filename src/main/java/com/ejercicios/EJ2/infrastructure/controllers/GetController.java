package com.ejercicios.EJ2.infrastructure.controllers;

import com.ejercicios.EJ2.application.PersonaService;
import com.ejercicios.EJ2.infrastructure.controllers.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/EJ2")
public class GetController {

    @Autowired
    PersonaService personaService;

    //Ver todos los valores
    @GetMapping("/getall")
    public ArrayList<PersonaOutputDTO> getPersonas(){
        return personaService.getAll();
    }

    //Buscar por id
    @GetMapping("/getbyid/{id}")
    public PersonaOutputDTO getPersonById(@PathVariable int id) throws Exception{
        return personaService.getById(id);
    }

    //Buscar por User
    @GetMapping("/getbyuser/{user}")
    public ArrayList<PersonaOutputDTO> getPersonByUser(@PathVariable String user){
        return personaService.getByUser(user);
    }
}