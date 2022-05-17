package com.ejercicios.DBA1.infrastructure.controllers;


import com.ejercicios.DBA1.application.services.PersonaServiceDBA1;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "DBA1")
@RestController
@RequestMapping("/DBA1")
public class DeleteControllerDBA1 {

    @Autowired
    PersonaServiceDBA1 personaService;

    //Borrar por id
    @DeleteMapping("/delete/{id}")//Problema del autoincrement
    public String deleteById(@PathVariable int id) {
        return personaService.deleteById(id);
    }
}
