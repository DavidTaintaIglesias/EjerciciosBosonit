package com.ejercicios.JVA2.infrastructure.controllers;


import com.ejercicios.JVA2.application.services.PersonaServiceJVA2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/JVA2")
public class DeleteControllerJVA2 {

    @Autowired
    PersonaServiceJVA2 personaService;

    //Borrar por id
    @DeleteMapping("/delete/{id}")//Problema del autoincrement
    public String deleteById(@PathVariable int id) {
        return personaService.deleteById(id);
    }
}
