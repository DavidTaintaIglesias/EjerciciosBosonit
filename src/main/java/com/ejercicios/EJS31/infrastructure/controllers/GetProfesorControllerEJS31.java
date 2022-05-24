package com.ejercicios.EJS31.infrastructure.controllers;

import com.ejercicios.EJS31.application.services.GetProfesorServiceEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.output.FullProfesorOutputDTOEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.output.ProfesorOutputDTOEJS31;
import com.ejercicios.shared.exceptions.Unprocessable;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "EJS31")
@RestController
@RequestMapping("/EJS31/getProfesor")
public class GetProfesorControllerEJS31 {

    @Autowired
    GetProfesorServiceEJS31 getProfesorService;

    @GetMapping("/all")
    public ResponseEntity<List<ProfesorOutputDTOEJS31>> getAll(){
        return new ResponseEntity<>(getProfesorService.getAll().stream().map(ProfesorOutputDTOEJS31::new).toList(), HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id, @RequestParam(defaultValue = "simple") String outputType){
        if(outputType.equals("simple")){
            return new ResponseEntity<>(new ProfesorOutputDTOEJS31(getProfesorService.getById(id)),HttpStatus.OK);
        } else if(outputType.equals("full")){
            return new ResponseEntity<>(new FullProfesorOutputDTOEJS31(getProfesorService.getById(id)),HttpStatus.OK);
        } else throw new Unprocessable("outputType must be 'simple' or 'full'");

    }
}
