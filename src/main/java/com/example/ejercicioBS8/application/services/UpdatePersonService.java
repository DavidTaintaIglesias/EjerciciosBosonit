package com.example.ejercicioBS8.application.services;

import com.example.ejercicioBS8.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonService {

    @Autowired
    PersonaRepository personaRepository;
}
