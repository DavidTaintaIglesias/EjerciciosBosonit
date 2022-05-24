package com.ejercicios.EJS31.application.checks;

import com.ejercicios.EJS31.domain.entities.PersonEJS31;
import com.ejercicios.EJS31.domain.entities.ProfesorEJS31;
import com.ejercicios.EJS31.infrastructure.repository.PersonRepositoryEJS31;
import com.ejercicios.EJS31.infrastructure.repository.ProfesorRepositoryEJS31;
import com.ejercicios.shared.exceptions.NotFound;
import com.ejercicios.shared.exceptions.Unprocessable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorPersonChecksEJS31 {

    @Autowired
    PersonRepositoryEJS31 personRepository;

    @Autowired
    ProfesorRepositoryEJS31 profesorRepository;

    public void personCheck(int id){
        personRepository.findById(id).orElseThrow(()->new NotFound("Person Id not found"));
    }

    public void validProfesor(int id){
        PersonEJS31 person = personRepository.getById(id);
        if(person.getIdProffesor()!=null){
            throw new Unprocessable("This Person is already a profesor");
        }
        if(person.getIdStudent()!=null){
            throw new Unprocessable("This Person is already a Student");
        }
    }

    public void addPersonToProfesor (int idPerson, int idProfesor){
        PersonEJS31 person = personRepository.getById(idPerson);
        ProfesorEJS31 profesor = profesorRepository.getById(idProfesor);
        profesor.setPerson(person);
        profesorRepository.save(profesor);
        person.setIdProffesor(profesor.getId());
        personRepository.save(person);
    }
}
