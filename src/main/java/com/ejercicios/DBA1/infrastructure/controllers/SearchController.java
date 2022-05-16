/*package com.ejercicios.DBA1.infrastructure.controllers;

import com.ejercicios.DBA1.infrastructure.controllers.dto.output.PersonaOutputDTODBA1;
import com.ejercicios.DBA1.infrastructure.repository.PersonaRespositoryDBA1Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/DBA1")
public class SearchController {

    @Autowired
    PersonaRespositoryDBA1Impl personaRespositoryDBA1;

    @GetMapping
    public ResponseEntity<List<PersonaOutputDTODBA1>> searchPerson(@RequestParam(required = false) String name, @RequestParam(required = false) String surname, @RequestParam(required = false) String user){
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("name", name);
        hm.put("surname", surname);
        hm.put("user", user);
        return new ResponseEntity<>(personaRespositoryDBA1.getData(hm).stream().map(PersonaOutputDTODBA1::new).toList(), HttpStatus.OK);
    }
}*/
