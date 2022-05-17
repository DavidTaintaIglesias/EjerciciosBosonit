package com.ejercicios.BS2.controladores;

import com.ejercicios.BS2.model.Persona;
import com.ejercicios.BS2.service.PersonaService1;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controlagor que recoge los datos de la persona

@Api(tags = "BS2")
@RestController//Ponerlo siempre
@RequestMapping("/BS2") //Poniendo esto todo lo que haga en la pagina ocurre en esta ruta, luego puedo añadir subrutas
public class Controlador1 {

    @Autowired
    PersonaService1 personaService;

    @PostMapping ("/postpersona")
    public Persona postPersona(@RequestBody Persona p){
        personaService.postPersona(p);
        return p;
    }
}
