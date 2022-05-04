package com.example.ejercicioBS8.infrastructure.controllers;

import com.example.ejercicioBS8.application.services.GetPersonsService;
import com.example.ejercicioBS8.infrastructure.controllers.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/get")
public class GetPersonController {

    @Autowired
    GetPersonsService getPersonsService;

    //getAll
    @GetMapping("/all")
    public List<PersonaOutputDTO> getPersonas(){
        return getPersonsService.getAll();
    }

    //getByID
    @GetMapping("/byid/{id}")
    public PersonaOutputDTO getById(@PathVariable int id){
        return getPersonsService.getById(id);
    }

    //getByUser
    @GetMapping("/byuser/{user}")
    public PersonaOutputDTO getByUser(@PathVariable String user){
        return getPersonsService.getByUser(user);
    }




}
