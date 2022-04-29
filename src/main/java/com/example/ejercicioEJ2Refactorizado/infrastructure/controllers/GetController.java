package com.example.ejercicioEJ2Refactorizado.infrastructure.controllers;

import com.example.ejercicioEJ2Refactorizado.application.PersonaService;
import com.example.ejercicioEJ2Refactorizado.infrastructure.controllers.dto.output.PersonaOutputDTO;
import com.example.ejercicioEJ2Refactorizado.infrastructure.errorcontroller.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
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
    public PersonaOutputDTO getPersonById(@PathVariable int id){
        try{
            return personaService.getById(id);
        } catch (Exception ex) {
            throw new NotFoundException("ID not found");
        }
    }

    //Buscar por User
    @GetMapping("/getbyuser/{user}")
    public ArrayList<PersonaOutputDTO> getPersonByUser(@PathVariable String user){
        return personaService.getByUser(user);
    }
}