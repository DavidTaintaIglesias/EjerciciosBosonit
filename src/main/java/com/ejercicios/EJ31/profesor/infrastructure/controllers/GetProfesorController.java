package com.ejercicios.EJ31.profesor.infrastructure.controllers;

import com.ejercicios.EJ31.profesor.aplication.services.GetProfesorService;
import com.ejercicios.EJ31.profesor.infrastructure.controllers.dto.output.ProfesorOutputDTO;
import com.ejercicios.shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            return getProfesorService.getPofesorById(id);
        } else if(outputType.equals("full")){
            return getProfesorService.getFullProfesorById(id);
        } else throw new NotFoundException("outputType solo puede ser 'simple' o 'full'");
    }
}
