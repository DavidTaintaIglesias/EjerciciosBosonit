package com.ejercicios.EJ31.aplication.services;

import com.ejercicios.EJ31.infrastructure.controllers.dto.output.FullPersonOutputDTO;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.ProfesorOutputDTO;
import com.ejercicios.EJ31.infrastructure.repository.ProfesorRepository;
import com.ejercicios.EJ31.infrastructure.repository.StudentRepository;
import com.ejercicios.shared.exceptions.NotFoundException;
import com.ejercicios.EJ31.domain.entities.PersonEntity;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.PersonOutputDTO;
import com.ejercicios.EJ31.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPersonsService {

    @Autowired
    PersonRepository personaRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    public List<PersonOutputDTO> getAll(){
        List<PersonEntity> personas = personaRepository.findAll();
        return personas.stream().map(PersonOutputDTO::new).toList();//Con el stream.map convierto la lista en mi lista de DTO y lo muestro.
    }

    public List<FullPersonOutputDTO> getFullAll(){
        List<PersonEntity> persons = personaRepository.findAll();
        return persons.stream().map(FullPersonOutputDTO::new).toList();
    }

    public PersonOutputDTO getById(int id){
        PersonOutputDTO personaOutputDTO = new PersonOutputDTO(personaRepository.findById(id).orElseThrow(()-> new NotFoundException("Id no encontrado")));
        return personaOutputDTO;
    }

    public FullPersonOutputDTO getFullById(int id){
        PersonEntity person = personaRepository.findById(id).orElseThrow(()-> new NotFoundException("Id no encontrado"));
        FullPersonOutputDTO fullPersonOutputDTO = new FullPersonOutputDTO(person);
        if(person.getIdProfesor()!=null){
            fullPersonOutputDTO.setProfesorEntity(profesorRepository.getById(person.getIdProfesor()));
        }
        if(person.getIdStudent()!=null){
            fullPersonOutputDTO.setStudentEntity(studentRepository.getById(person.getIdStudent()));
        }
        return fullPersonOutputDTO;
    }

    public PersonOutputDTO getByUser(String user){
        PersonOutputDTO personaOutputDTO = new PersonOutputDTO(personaRepository.findByUser(user).orElseThrow(()-> new NotFoundException("User no encontrado")));
        return personaOutputDTO;
    }

    public FullPersonOutputDTO getFullByUser(String user){
        FullPersonOutputDTO fullPersonOutputDTO = new FullPersonOutputDTO(personaRepository.findByUser(user).orElseThrow(()-> new NotFoundException("User no encontrado")));
        return fullPersonOutputDTO;
    }
}
