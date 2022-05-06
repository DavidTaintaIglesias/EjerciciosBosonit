package com.ejercicios.EJ31.aplication.services;

import com.ejercicios.shared.exceptions.NotFoundException;
import com.ejercicios.EJ31.domain.entities.StudentEntity;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.FullStudentOutputDTO;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.StudentOutputDTO;
import com.ejercicios.EJ31.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class GetStudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<StudentOutputDTO> getAllStudent(){
        List<StudentEntity> students = studentRepository.findAll();
        return students.stream().map(StudentOutputDTO::new).toList();
    }

    public StudentOutputDTO getStudentById(int id){
        try{
            StudentOutputDTO studentOutputDTO = new StudentOutputDTO(studentRepository.getById(id));
            return studentOutputDTO;
        } catch (EntityNotFoundException es){
            throw new NotFoundException("Id no encontrado");
        }
    }

    public FullStudentOutputDTO getFullStudentById(int id){
        try{
            FullStudentOutputDTO fullStudentOutputDTO = new FullStudentOutputDTO(studentRepository.getById(id));
            return fullStudentOutputDTO;
        } catch (EntityNotFoundException es){
            throw new NotFoundException("Id no encontrado");
        }
    }
}
