package com.ejercicios.BS12.infrastructure.controllers;

import com.ejercicios.BS12.application.service.GetPersonServiceBS12;
import com.ejercicios.BS12.infrastructure.controllers.dto.output.PersonOutputDTOBS12;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetPersonControllerBS12 {

  @Autowired
  GetPersonServiceBS12 getPersonService;

  @GetMapping("/getall")
  @CrossOrigin("*")
  public List<PersonOutputDTOBS12> getPersons() {

    return getPersonService.getAllPerson();
  }

  @GetMapping("/byId/{id}")
  public PersonOutputDTOBS12 getById(@PathVariable int id) {

    return getPersonService.getPersonById(id);
  }

  @GetMapping("/byUser/{user}")
  public PersonOutputDTOBS12 getByUser(@PathVariable String user) {

    return getPersonService.getPersonByUser(user);
  }

}
