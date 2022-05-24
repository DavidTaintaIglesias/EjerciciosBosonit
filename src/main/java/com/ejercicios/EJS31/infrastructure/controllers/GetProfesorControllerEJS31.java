package com.ejercicios.EJS31.infrastructure.controllers;

import com.ejercicios.EJS31.application.services.GetProfesorServiceEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.output.ProfesorOutputDTOEJS31;
import com.ejercicios.shared.exceptions.Unprocessable;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "EJS31")
@RestController
@RequestMapping("/EJS31/getProfesor")
public class GetProfesorControllerEJS31 {

    @Autowired
    GetProfesorServiceEJS31 getProfesorService;

    @GetMapping("/all")
    public List<ProfesorOutputDTOEJS31> getAll(){
        return getProfesorService.getAll();
    }

    @GetMapping("/byId/{id}")
    public Object getById(@PathVariable int id, @RequestParam(defaultValue = "simple") String outputType){
        if(outputType.equals("simple")){
            return getProfesorService.getById(id);
        } else if(outputType.equals("full")){
            return getProfesorService.getFullById(id);
        } else throw new Unprocessable("outputType must be 'simple' or 'full'");

    }
}
