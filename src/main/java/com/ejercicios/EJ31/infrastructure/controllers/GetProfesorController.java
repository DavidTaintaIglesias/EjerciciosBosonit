package com.ejercicios.EJ31.infrastructure.controllers;

import com.ejercicios.EJ31.aplication.services.GetProfesorService;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.ProfesorOutputDTO;
import com.ejercicios.shared.exceptions.UnprocessableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/EJ31/getprofesor")
public class GetProfesorController {

    @Autowired
    GetProfesorService getProfesorService;

    @GetMapping("/all")
    public List<ProfesorOutputDTO> getAll(){
        return getProfesorService.getAllProfesor();
    }

    @GetMapping("/byid/{id}")
    public Object getProfesorById(@PathVariable int id, @RequestParam(defaultValue = "simple") String outputType){
        if(outputType.equals("simple")){
            return getProfesorService.getProfesorById(id);
        } else if(outputType.equals("full")){
            System.out.println(getProfesorService.getFullProfesorById(id));
            return getProfesorService.getFullProfesorById(id);
        } else throw new UnprocessableException("outputType solo puede ser 'simple' o 'full'");
    }
}
