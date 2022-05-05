package com.ejercicios.BS8.infrastructure.controllers;

import com.ejercicios.BS8.aplication.services.UpdatePersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdatePersonaController {

    @Autowired
    UpdatePersonaService updatePersonService;
}
