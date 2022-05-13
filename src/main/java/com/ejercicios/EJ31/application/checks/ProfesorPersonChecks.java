package com.ejercicios.EJ31.application.checks;

import com.ejercicios.EJ31.application.exceptions.NotFoundException;
import com.ejercicios.EJ31.application.exceptions.UnprocessableException;
import com.ejercicios.EJ31.domain.entities.Person;
import com.ejercicios.EJ31.domain.entities.Profesor;
import com.ejercicios.EJ31.infrastructure.repository.PersonRepository;
import com.ejercicios.EJ31.infrastructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorPersonChecks {

  @Autowired
  PersonRepository personRepository;

  @Autowired
  ProfesorRepository profesorRepository;

  public void personCheck(int id) {

    personRepository.findById(id).orElseThrow(() -> new NotFoundException("Person Id not found"));
  }

  public void validProfesor(int id) {

    Person person = personRepository.getById(id);
    if (person.getIdProfesor() != null) {
      throw new UnprocessableException("This Person is already a profesor");
    }
    if (person.getIdStudent() != null) {
      throw new UnprocessableException("This Person is already a Student");
    }
  }

  public void addPersonToProfesor(int idPerson, int idProfesor) {

    Person person = personRepository.getById(idPerson);
    Profesor profesor = profesorRepository.getById(idProfesor);
    profesor.setPerson(person);
    profesorRepository.save(profesor);
    person.setIdProfesor(profesor.getId());
    personRepository.save(person);
  }

}
