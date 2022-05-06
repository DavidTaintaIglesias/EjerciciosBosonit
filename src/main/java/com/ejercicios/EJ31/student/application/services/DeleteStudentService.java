package com.ejercicios.EJ31.student.application.services;

import com.ejercicios.shared.exceptions.NotFoundException;
import com.ejercicios.EJ31.student.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteStudentService {

    @Autowired
    StudentRepository studentRepository;

    public String deleteStudent(int id){
        try{
            studentRepository.deleteById(id);
            return "Student con Id: "+id+" borrado";
        } catch (Exception ex){  //OJO!! Así cualquier excepcion la cogeré y la modificaré y no sabré cual es la excepción real
            throw new NotFoundException("Id no encontrado");
        }
    }
}
