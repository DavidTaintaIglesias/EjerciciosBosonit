package com.ejercicios.EJ31.infrastructure.controllers;

import com.ejercicios.EJ31.aplication.services.RemoveSubjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EJ31/removeSubjet")
public class RemoveSubjetController {

    @Autowired
    RemoveSubjetService removeSubjetService;

    @DeleteMapping("/{idSubjet}/fromStudent/{idStudent}")
    public String removeSubjet(@PathVariable int idSubjet, @PathVariable int idStudent){
        return removeSubjetService.removeSubjetFromStudent(idStudent, idSubjet);
    }
}
