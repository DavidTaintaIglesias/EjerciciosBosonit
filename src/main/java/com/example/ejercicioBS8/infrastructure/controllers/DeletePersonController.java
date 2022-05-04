package com.example.ejercicioBS8.infrastructure.controllers;

import com.example.ejercicioBS8.application.services.DeletePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delete")
public class DeletePersonController {

    @Autowired
    DeletePersonService deletePersonService;

    @DeleteMapping("/{id}")
    public String deleteById (@PathVariable int id){
        return deletePersonService.deleteById(id);
    }
}
