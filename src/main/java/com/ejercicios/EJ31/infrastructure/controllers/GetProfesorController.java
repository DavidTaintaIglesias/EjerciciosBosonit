package com.ejercicios.EJ31.infrastructure.controllers;

import com.ejercicios.EJ31.application.exceptions.UnprocessableException;
import com.ejercicios.EJ31.application.services.GetProfesorService;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.ProfesorOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "EJ31")
@RestController
@RequestMapping("/EJ31/getProfesor")
public class GetProfesorController {

    @Autowired
    GetProfesorService getProfesorService;

    @GetMapping("/all")
    public List<ProfesorOutputDTO> getAll(){
        return getProfesorService.getAll();
    }

    @GetMapping("/byId/{id}")
    public Object getById(@PathVariable int id, @RequestParam(defaultValue = "simple") String outputType){
        if(outputType.equals("simple")){
            return getProfesorService.getById(id);
        } else if(outputType.equals("full")){
            return getProfesorService.getFullById(id);
        } else throw new UnprocessableException("outputType must be 'simple' or 'full'");

    }
}
