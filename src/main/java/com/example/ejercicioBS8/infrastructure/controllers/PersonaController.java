package com.example.ejercicioBS8.infrastructure.controllers;

import com.example.ejercicioBS8.application.PersonaService;
import com.example.ejercicioBS8.infrastructure.controllers.dto.input.PersonaInputDTO;
import com.example.ejercicioBS8.infrastructure.controllers.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    PersonaService personaService;

    //Añadir persona
    @PostMapping("/postpersona")// simbolo "|" -> alt+124
    public PersonaOutputDTO setPersona(@RequestBody PersonaInputDTO persona){
        try{
            return personaService.setPersona(persona);
        } catch (Exception e){
            throw new UnprocessableException("El usuario debe tener entre 6 y 10 caracteres");
        }
    }

    //Ver todos los valores
    @GetMapping("/getall")
    public List<PersonaOutputDTO> getPersonas(){
        return personaService.getAll();
    }

    //Buscar por id
    @GetMapping("/getbyid/{id}")
    public PersonaOutputDTO getPersonById(@PathVariable int id){
        return personaService.getById(id);
    }

    //Buscar por User
    @GetMapping("/getbyuser/{user}")
    public PersonaOutputDTO getPersonByUser(@PathVariable String user){
        return personaService.getByUser(user);
    }

    //Borrar por id
    @DeleteMapping("/delete/{id}")//Problema del autoincrement
    public String deleteById(@PathVariable int id){
        try{
            return personaService.deleteById(id);
        } catch (EmptyResultDataAccessException ex){
            throw new NotFoundException("ID not found");
        }
    }

    //Modificar por id (problemas con el autoincrement)
    @PutMapping("/put/{id}")
    public PersonaOutputDTO putById(@PathVariable int id, @RequestBody PersonaInputDTO personaInputDTO) throws Exception {
        return personaService.putById(id, personaInputDTO);
    }
}
