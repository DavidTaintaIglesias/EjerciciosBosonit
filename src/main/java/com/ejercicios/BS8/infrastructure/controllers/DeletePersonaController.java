package com.ejercicios.BS8.infrastructure.controllers;

import com.ejercicios.BS8.aplication.services.DeletePersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/BS8/delete")
public class DeletePersonaController {

  @Autowired
  DeletePersonaService deletePersonService;

  @DeleteMapping("/{id}")
  public String deleteById(@PathVariable int id) {

    return deletePersonService.deleteById(id);
  }

}
