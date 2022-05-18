package com.ejercicios.EJ2.infrastructure.controllers;

import com.ejercicios.EJ2.application.PersonaService;
import com.ejercicios.EJ2.domain.Persona;
import com.ejercicios.EJ2.infrastructure.controllers.dto.output.PersonaOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "EJ2")
@RestController
@RequestMapping("/EJ2")
public class PatchController {

    @Autowired
    PersonaService personaService;

    @PatchMapping("/{id}")
    public PersonaOutputDTO patchPerson(@PathVariable Integer id, @RequestBody Map<Object, Object> personaInputDTO) {
        Persona p = personaService.patchPersona(id, personaInputDTO);
        return new PersonaOutputDTO(p);
    }
}
