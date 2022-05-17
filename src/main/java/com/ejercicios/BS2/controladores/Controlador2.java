package com.ejercicios.BS2.controladores;

import com.ejercicios.BS2.model.Persona;
import com.ejercicios.BS2.service.PersonaService1;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controlador que devuelve los datos de la persona

@Api(tags = "BS2")
@RestController
@RequestMapping("/BS2")
public class Controlador2 {

    @Autowired
    PersonaService1 personaService;

    @GetMapping("/getpersona")
    public Persona getPersona(){
        return personaService.getPersona();
    }
}
