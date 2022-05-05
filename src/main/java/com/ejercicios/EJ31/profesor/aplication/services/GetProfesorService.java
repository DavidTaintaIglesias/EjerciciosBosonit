package com.ejercicios.EJ31.profesor.aplication.services;

import com.ejercicios.EJ31.profesor.domain.entities.ProfesorEntity;
import com.ejercicios.EJ31.profesor.infrastructure.controllers.dto.output.FullProfesorOutputDTO;
import com.ejercicios.EJ31.profesor.infrastructure.controllers.dto.output.ProfesorOutputDTO;
import com.ejercicios.EJ31.profesor.infrastructure.repository.ProfesorRepository;
import com.ejercicios.EJ31.shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;

    public List<ProfesorOutputDTO> getAllProfesor(){
        List<ProfesorEntity> profesors = profesorRepository.findAll();
        return profesors.stream().map(ProfesorOutputDTO::new).toList();
    }

    public ProfesorOutputDTO getPofesorById(int id){
        ProfesorOutputDTO profesorOutputDTO= new ProfesorOutputDTO(profesorRepository.findById(id).orElseThrow(()->new NotFoundException("ID no encontrado")));
        return profesorOutputDTO;
    }

    public FullProfesorOutputDTO getFullProfesorById(int id){
        FullProfesorOutputDTO fullProfesorOutputDTO = new FullProfesorOutputDTO(profesorRepository.findById(id).orElseThrow(()->new NotFoundException("ID no encontrado")));
        return fullProfesorOutputDTO;
    }

}
