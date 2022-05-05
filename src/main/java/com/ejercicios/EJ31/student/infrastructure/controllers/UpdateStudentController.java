package com.ejercicios.EJ31.student.infrastructure.controllers;

import com.ejercicios.EJ31.student.application.services.UpdateStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateStudentController {

    @Autowired
    UpdateStudentService updateStudentService;
}
