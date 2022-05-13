package com.ejercicios.EJ2.infrastructure.controllers;

import com.ejercicios.EJ2.application.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EJ2")
public class DeleteController {

  @Autowired
  PersonaService personaService;

  //Borrar por id
  @DeleteMapping("/{id}")//Problema del autoincrement
  public ResponseEntity<Void> deleteById(@PathVariable int id) throws Exception {

    personaService.deleteById(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
