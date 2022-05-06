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
        StudentEntity studentEntity = studentRepository.findById(schoolSubjetInputDTO.getIdStudent()).orElseThrow(()-> new NotFoundException("Id no encontrado"));
        subjet.setStudentEntity(studentEntity);
        subjetRepository.save(subjet);
        studentEntity.addSubjet(subjet);
        studentRepository.save(studentEntity);
        SchoolSubjetOutputDTO schoolSubjetOutputDTO = new SchoolSubjetOutputDTO(subjet);
        return schoolSubjetOutputDTO;
    }
}
