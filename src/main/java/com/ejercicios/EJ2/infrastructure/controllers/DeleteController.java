package com.ejercicios.EJ2.infrastructure.controllers;

import com.ejercicios.EJ2.application.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
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
  @DeleteMapping("/delete/{id}")//Problema del autoincrement
  public String deleteById(@PathVariable int id) throws Exception {

    return personaService.deleteById(id);
  }

}
