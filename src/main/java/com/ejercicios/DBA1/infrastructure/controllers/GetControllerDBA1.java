package com.ejercicios.DBA1.infrastructure.controllers;

import com.ejercicios.DBA1.application.services.PersonaServiceDBA1;
import com.ejercicios.DBA1.infrastructure.controllers.dto.output.PersonaOutputDTODBA1;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "DBA1")
@RestController
@RequestMapping("/DBA1")
public class GetControllerDBA1 {

    @Autowired
    PersonaServiceDBA1 personaService;

    //Ver todos los valores
    @GetMapping("/getall")
    public List<PersonaOutputDTODBA1> getPersonas(){
        return personaService.getAll().stream().map(PersonaOutputDTODBA1::new).toList();
    }

    //Buscar por id
    @GetMapping("/getbyid/{id}")
    public PersonaOutputDTODBA1 getPersonById(@PathVariable int id) throws Exception{
        return new PersonaOutputDTODBA1(personaService.getById(id));
    }

    //Buscar por User
    @GetMapping("/getbyuser/{user}")
    public PersonaOutputDTODBA1 getPersonByUser(@PathVariable String user){
        return new PersonaOutputDTODBA1(personaService.findByUser(user));
    }
}