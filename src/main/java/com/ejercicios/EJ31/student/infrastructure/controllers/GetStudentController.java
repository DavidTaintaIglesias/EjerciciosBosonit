package com.ejercicios.EJ31.student.infrastructure.controllers;

import com.ejercicios.shared.exceptions.UnprocessableException;
import com.ejercicios.EJ31.student.application.services.GetStudentService;
import com.ejercicios.EJ31.student.infrastructure.controllers.dto.output.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EJ31/getstudent")
public class GetStudentController {

    @Autowired
    GetStudentService getStudentService;

    @GetMapping("/all")
    public List<StudentOutputDTO> getAllStudent(){
        return getStudentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Object getStudentById (@PathVariable int id, @RequestParam(defaultValue = "simple") String outputType){
        if(outputType.equals("simple")){
            return getStudentService.getStudentById(id);
        } else if (outputType.equals("full")) {
            return getStudentService.getFullStudentById(id);
        } else throw new UnprocessableException("outputType debe ser 'simple' o 'full' no acepta otros valores");
    }
}
