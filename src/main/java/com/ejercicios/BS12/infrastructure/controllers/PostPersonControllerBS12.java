package com.ejercicios.BS12.infrastructure.controllers;

import com.ejercicios.BS12.application.service.PostPersonServiceBS12;
import com.ejercicios.BS12.infrastructure.controllers.dto.input.PersonInputDTOBS12;
import com.ejercicios.BS12.infrastructure.controllers.dto.output.PersonOutputDTOBS12;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PostPersonControllerBS12 {

  @Autowired
  PostPersonServiceBS12 postPersonService;

  @PostMapping("/addperson")
  @CrossOrigin("*")
  public PersonOutputDTOBS12 postPerson(@Valid @RequestBody PersonInputDTOBS12 personInputDTO) {

    return postPersonService.postPerson(personInputDTO);
  }

}
