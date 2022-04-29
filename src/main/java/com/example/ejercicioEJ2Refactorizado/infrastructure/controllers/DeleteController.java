package com.example.ejercicioEJ2Refactorizado.infrastructure.controllers;

import com.example.ejercicioEJ2Refactorizado.application.PersonaService;
import com.example.ejercicioEJ2Refactorizado.infrastructure.errorcontroller.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    @Autowired
    PersonaService personaService;

    //Borrar por id
    @DeleteMapping("/delete/{id}")//Problema del autoincrement
    public String deleteById(@PathVariable int id){
        try{
            return personaService.deleteById(id);
        } catch (EmptyResultDataAccessException ex){
            throw new NotFoundException("ID not found");
        }
    }
}
