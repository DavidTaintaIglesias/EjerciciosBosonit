package com.ejercicios.EJ31.person.infrastructure.controllers;

import com.ejercicios.EJ31.person.application.services.GetPersonsService;
import com.ejercicios.shared.exceptions.UnprocessableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/EJ31/getperson")
public class GetPersonController {

    @Autowired
    GetPersonsService getPersonsService;

    //getAll
    @GetMapping("/all")
    public Object getPersonas(@RequestParam(defaultValue = "simple") String outputType){
        if(outputType.equals("simple")){
            return getPersonsService.getAll();
        } else if(outputType.equals("full")){
            return getPersonsService.getFullAll();
        } else throw new UnprocessableException("outputType debe ser 'simple' o 'full'");
    }

    //getByID
    @GetMapping("/byid/{id}")
    public Object getById(@PathVariable int id, @RequestParam(defaultValue = "simple") String outputType){
        if(outputType.equals("simple")){
            return getPersonsService.getById(id);
        } else if(outputType.equals("full")){
            return getPersonsService.getFullById(id);
        } else throw new UnprocessableException("outputType debe ser 'simple' o 'full'");
    }

    //getByUser
    @GetMapping("/byuser/{user}")
    public Object getByUser(@PathVariable String user, @RequestParam(defaultValue = "simple") String outputType){
        if(outputType.equals("simple")){
            return getPersonsService.getByUser(user);
        } else if(outputType.equals("full")){
            return getPersonsService.getFullByUser(user);
        } else throw new UnprocessableException("outputType debe ser 'simple' o 'full'");
    }




}
