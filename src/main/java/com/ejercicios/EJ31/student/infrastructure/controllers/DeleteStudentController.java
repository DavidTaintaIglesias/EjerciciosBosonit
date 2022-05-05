package com.ejercicios.EJ31.student.infrastructure.controllers;

import com.ejercicios.EJ31.student.application.services.DeleteStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deletestudent")
public class DeleteStudentController {

    @Autowired
    DeleteStudentService deleteStudentService;

    @DeleteMapping("/{id}")
    public String deleteStudent (@PathVariable int id){
        return deleteStudentService.deleteStudent(id);
    }
}
