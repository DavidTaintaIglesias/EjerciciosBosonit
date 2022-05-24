package com.ejercicios.EJS31.infrastructure.controllers;

import com.ejercicios.EJS31.application.services.GetStudentServiceEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.output.FullStudentOutputDTOEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.output.StudentOutputDTOEJS31;
import com.ejercicios.shared.exceptions.Unprocessable;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "EJS31")
@RestController
@RequestMapping("/EJS31/getStudent")
public class GetStudentControllerEJS31 {

    @Autowired
    GetStudentServiceEJS31 getStudentService;

    @GetMapping("/all")
    public ResponseEntity<List<StudentOutputDTOEJS31>> getAll(){
        return new ResponseEntity<>(getStudentService.getAll().stream().map(StudentOutputDTOEJS31::new).toList(), HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id, @RequestParam(defaultValue = "simple") String outputType){
        if (outputType.equals("simple")){
            return new ResponseEntity<>(new StudentOutputDTOEJS31(getStudentService.getById(id)), HttpStatus.OK);
        } else if(outputType.equals("full")){
            return new ResponseEntity<>(new FullStudentOutputDTOEJS31(getStudentService.getById(id)), HttpStatus.OK);
        } else throw new Unprocessable("outputType must be 'simple' or 'full'");
    }
}
