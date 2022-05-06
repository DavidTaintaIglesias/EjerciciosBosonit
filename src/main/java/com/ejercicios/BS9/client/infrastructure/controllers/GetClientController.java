package com.ejercicios.BS9.client.infrastructure.controllers;

import com.ejercicios.BS9.client.aplication.services.GetClientService;
import com.ejercicios.BS9.client.infrastructure.controllers.dto.output.ClientOutputDTO;
import com.ejercicios.shared.exceptions.UnprocessableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BS9/getclient")
public class GetClientController {

    @Autowired
    GetClientService getClientService;

    @GetMapping("/all")
    public List<ClientOutputDTO> getAll(){
        return getClientService.getAll();
    }

    @GetMapping("/byid/{id}")
    public Object getById(@PathVariable int id, @RequestParam(defaultValue = "simple") String outputType){
        if(outputType.equals("simple")){
            return getClientService.getById(id);
        } else if(outputType.equals("full")){
            return getClientService.getFullById(id);
        } else return new UnprocessableException("outputType debe ser 'simple' o 'full");
    }
}
