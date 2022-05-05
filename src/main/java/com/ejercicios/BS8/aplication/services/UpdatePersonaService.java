package com.ejercicios.BS8.aplication.services;

import com.ejercicios.BS8.infrastructure.repository.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonaService {

    @Autowired
    PersonaRepo personaRepository;
}
