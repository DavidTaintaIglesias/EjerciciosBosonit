package com.ejercicios.EJ31.infrastructure.controllers;

import com.ejercicios.EJ31.application.services.PostSubjetService;
import com.ejercicios.EJ31.infrastructure.controllers.dto.input.SubjetInputDTO;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.SubjetOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/EJ31")
public class PostSubjetController {

  @Autowired
  PostSubjetService postSubjetService;

  @PostMapping("/postSubjet")
  public SubjetOutputDTO postSubjet(@Valid @RequestBody SubjetInputDTO subjetInputDTO) {

    return postSubjetService.postSubjet(subjetInputDTO);
  }

}
