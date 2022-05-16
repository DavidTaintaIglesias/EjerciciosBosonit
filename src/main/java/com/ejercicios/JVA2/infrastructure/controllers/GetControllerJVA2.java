package com.ejercicios.JVA2.infrastructure.controllers;

import com.ejercicios.JVA2.application.services.PersonaServiceJVA2;
import com.ejercicios.JVA2.infrastructure.controllers.dto.output.PersonaOutputDTOJVA2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/JVA2")
public class GetControllerJVA2 {

    @Autowired
    PersonaServiceJVA2 personaService;

    //Ver todos los valores
    @GetMapping("/getall")
    public List<PersonaOutputDTOJVA2> getPersonas(){
        return personaService.getAll().stream().map(PersonaOutputDTOJVA2::new).toList();
    }

    //Buscar por id
    @GetMapping("/getbyid/{id}")
    public PersonaOutputDTOJVA2 getPersonById(@PathVariable int id) throws Exception{
        return new PersonaOutputDTOJVA2(personaService.getById(id));
    }

    //Buscar por User
    @GetMapping("/getbyuser/{user}")
    public PersonaOutputDTOJVA2 getPersonByUser(@PathVariable String user){
        return new PersonaOutputDTOJVA2(personaService.findByUser(user));
    }
}