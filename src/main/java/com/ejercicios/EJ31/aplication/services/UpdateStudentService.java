package com.ejercicios.EJ31.aplication.services;

import com.ejercicios.EJ31.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStudentService {

    @Autowired
    StudentRepository studentRepository;
}
