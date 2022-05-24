package com.ejercicios.EJS31.infrastructure.controllers;

import com.ejercicios.EJS31.application.services.GetStudentServiceEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.output.StudentOutputDTOEJS31;
import com.ejercicios.shared.exceptions.Unprocessable;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "EJS31")
@RestController
@RequestMapping("/EJS31/getStudent")
public class GetStudentControllerEJS31 {

    @Autowired
    GetStudentServiceEJS31 getStudentService;

    @GetMapping("/all")
    public List<StudentOutputDTOEJS31> getAll(){
        return getStudentService.getAll();
    }

    @GetMapping("/byId/{id}")
    public Object getById(@PathVariable int id, @RequestParam(defaultValue = "simple") String outputType){
        if (outputType.equals("simple")){
            return getStudentService.getById(id);
        } else if(outputType.equals("full")){
            return getStudentService.getFullById(id);
        } else throw new Unprocessable("outputType must be 'simple' or 'full'");
    }
}
