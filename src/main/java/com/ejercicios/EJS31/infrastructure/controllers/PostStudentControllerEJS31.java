package com.ejercicios.EJS31.infrastructure.controllers;

import com.ejercicios.EJS31.application.services.PostStudentServiceEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.input.StudentInputDTOEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.output.StudentOutputDTOEJS31;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "EJS31")
@RestController
@RequestMapping("/EJS31")
public class PostStudentControllerEJS31 {

    @Autowired
    PostStudentServiceEJS31 postStudentService;

    @PostMapping("/postStudent")
    public StudentOutputDTOEJS31 postStudent(@Valid @RequestBody StudentInputDTOEJS31 studentInputDTO){
        return postStudentService.postStudent(studentInputDTO);
    }
}
