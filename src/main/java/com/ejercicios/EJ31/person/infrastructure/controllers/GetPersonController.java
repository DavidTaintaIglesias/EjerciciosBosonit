package com.ejercicios.EJ31.person.infrastructure.controllers;

import com.ejercicios.EJ31.person.application.services.GetPersonsService;
import com.ejercicios.EJ31.person.infrastructure.controllers.dto.output.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/getperson")
public class GetPersonController {

    @Autowired
    GetPersonsService getPersonsService;

    //getAll
    @GetMapping("/all")
    public List<PersonOutputDTO> getPersonas(){
        return getPersonsService.getAll();
    }

    //getByID
    @GetMapping("/byid/{id}")
    public PersonOutputDTO getById(@PathVariable int id){
        return getPersonsService.getById(id);
    }

    //getByUser
    @GetMapping("/byuser/{user}")
    public PersonOutputDTO getByUser(@PathVariable String user){
        return getPersonsService.getByUser(user);
    }




}
