package com.ejercicios.EJ31.aplication.services;

import com.ejercicios.EJ31.domain.entities.SchoolSubjetEntity;
import com.ejercicios.EJ31.infrastructure.controllers.dto.input.SchoolSubjetInputDTO;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.SchoolSubjetOutputDTO;
import com.ejercicios.EJ31.infrastructure.repository.SubjetRepository;
import com.ejercicios.shared.exceptions.NotFoundException;
import com.ejercicios.EJ31.domain.entities.StudentEntity;
import com.ejercicios.EJ31.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostSubjetService {

    @Autowired
    SubjetRepository subjetRepository;

    @Autowired
    StudentRepository studentRepository;

    public SchoolSubjetOutputDTO postSubjet(SchoolSubjetInputDTO schoolSubjetInputDTO){
        SchoolSubjetEntity subjet = new SchoolSubjetEntity(schoolSubjetInputDTO);
        subjetRepository.save(subjet);
        SchoolSubjetOutputDTO subjetOutputDTO = new SchoolSubjetOutputDTO(subjet);
        return subjetOutputDTO;
    }
}
