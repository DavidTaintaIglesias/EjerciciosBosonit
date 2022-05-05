package com.ejercicios.EJ31.person.infrastructure.controllers;

import com.ejercicios.EJ31.person.application.services.DeletePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deleteperson")
public class DeletePersonController {

    @Autowired
    DeletePersonService deletePersonService;

    @DeleteMapping("/{id}")
    public String deleteById (@PathVariable int id){
        return deletePersonService.deleteById(id);
    }
}
