package com.example.ejercicioBS8.infrastructure.controllers;

import com.example.ejercicioBS8.application.services.UpdatePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdatePersonController {

    @Autowired
    UpdatePersonService updatePersonService;
}
