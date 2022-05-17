package com.ejercicios.EJ31.infrastructure.controllers;

import com.ejercicios.EJ31.application.services.PostStudentService;
import com.ejercicios.EJ31.infrastructure.controllers.dto.input.StudentInputDTO;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.StudentOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "EJ31")
@RestController
@RequestMapping("/EJ31")
public class PostStudentController {

    @Autowired
    PostStudentService postStudentService;

    @PostMapping("/postStudent")
    public StudentOutputDTO postStudent(@Valid @RequestBody StudentInputDTO studentInputDTO){
        return postStudentService.postStudent(studentInputDTO);
    }
}
