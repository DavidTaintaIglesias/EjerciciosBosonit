package com.ejercicios.EJ31.infrastructure.controllers;

import com.ejercicios.EJ31.application.exceptions.UnprocessableException;
import com.ejercicios.EJ31.application.services.GetStudentService;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EJ31/getStudent")
public class GetStudentController {

    @Autowired
    GetStudentService getStudentService;

    @GetMapping("/all")
    public List<StudentOutputDTO> getAll(){
        return getStudentService.getAll();
    }

    @GetMapping("/byId/{id}")
    public Object getById(@PathVariable int id, @RequestParam(defaultValue = "simple") String outputType){
        if (outputType.equals("simple")){
            return getStudentService.getById(id);
        } else if(outputType.equals("full")){
            return getStudentService.getFullById(id);
        } else throw new UnprocessableException("outputType must be 'simple' or 'full'");
    }
}
