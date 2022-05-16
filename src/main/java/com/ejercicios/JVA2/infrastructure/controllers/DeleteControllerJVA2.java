package com.ejercicios.JVA2.infrastructure.controllers;


import com.ejercicios.JVA2.application.services.PersonaServiceJVA2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        return new ResponseEntity<>(personaService.deleteById(id), HttpStatus.NO_CONTENT);
    }
}
