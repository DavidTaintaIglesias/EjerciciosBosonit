package com.ejercicios.EJ31.student.infrastructure.controllers;

import com.ejercicios.EJ31.student.application.services.PostStudentService;
import com.ejercicios.EJ31.student.infrastructure.controllers.dto.input.StudentInputDTO;
import com.ejercicios.EJ31.student.infrastructure.controllers.dto.output.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EJ31/poststudent")
public class PostStudentController {

    @Autowired
    PostStudentService postStudentService;

    @PostMapping
    public StudentOutputDTO postStudent(@RequestBody StudentInputDTO studentInputDTO){
        return postStudentService.postStudent(studentInputDTO);
    }
}
