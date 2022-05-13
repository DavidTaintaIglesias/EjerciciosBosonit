package com.ejercicios.EJ31.application.services;

import com.ejercicios.EJ31.application.exceptions.NotFoundException;
import com.ejercicios.EJ31.domain.entities.Profesor;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.FullProfesorOutputDTO;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.ProfesorOutputDTO;
import com.ejercicios.EJ31.infrastructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProfesorService {

  @Autowired
  ProfesorRepository profesorRepository;

  public List<ProfesorOutputDTO> getAll() {

    List<Profesor> profesors = profesorRepository.findAll();
    return profesors.stream().map(ProfesorOutputDTO::new).toList();
  }

  public ProfesorOutputDTO getById(int id) {

    ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(profesorRepository.findById(id).orElseThrow(() -> new NotFoundException("Profesor Id not foud")));
    return profesorOutputDTO;
  }

  public FullProfesorOutputDTO getFullById(int id) {

    FullProfesorOutputDTO fullProfesorOutputDTO = new FullProfesorOutputDTO(profesorRepository.findById(id).orElseThrow(() -> new NotFoundException("Profesor Id not found")));
    return fullProfesorOutputDTO;
  }

}
