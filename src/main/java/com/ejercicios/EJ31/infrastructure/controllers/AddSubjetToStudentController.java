package com.ejercicios.EJ31.infrastructure.controllers;

import com.ejercicios.EJ31.aplication.services.AddSubjetToStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EJ31/addSubjet")
public class AddSubjetToStudentController {

    @Autowired
    AddSubjetToStudentService addSubjetToStudentService;

    @PostMapping("/{idSubjet}/intostudent/{idStudent}")
    public String addSubjetToStudent(@PathVariable int idSubjet, @PathVariable int idStudent){
        return addSubjetToStudentService.addSubjetToStudent(idStudent,idSubjet);
    }
}
