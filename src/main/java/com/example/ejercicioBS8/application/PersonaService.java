package com.example.ejercicioBS8.application;

import com.example.ejercicioBS8.domain.PersonaEntity;
import com.example.ejercicioBS8.infrastructure.controllers.NotFoundException;
import com.example.ejercicioBS8.infrastructure.controllers.dto.input.PersonaInputDTO;
import com.example.ejercicioBS8.infrastructure.controllers.dto.output.PersonaOutputDTO;
import com.example.ejercicioBS8.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.List;

@Component
public class PersonaService implements Serializable {


    @Autowired
    PersonaRepository personaRepository;


    //Recibir todos las persona de mi BBDD
    public List<PersonaOutputDTO> getAll() {
        List<PersonaEntity> personas = personaRepository.findAll();
        System.out.println(personas);
        return personas.stream().map(PersonaOutputDTO::new).toList();//Con el stream.map convierto la lista en mi lista de DTO y lo muestro.
    }

    //Buscar por ID
    public PersonaOutputDTO getById(int id) {
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaRepository.findById(id).orElseThrow(()-> new NotFoundException("No existe ese ID")));
        return personaOutputDTO;
    }


    //Buscar by User (En el caso de que User pueda repetirse, sino quitaria ArrayList
    public PersonaOutputDTO getByUser(String user){
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaRepository.findByUser(user).orElseThrow(()-> new NotFoundException("Usuario "+user+" no encontrado")));
        return personaOutputDTO;
    }

    //Borrar por id
    public String deleteById(int id){
        personaRepository.deleteById(id);
        return "Borrado el registro con el Id: "+id;
    }

    //Modificar por id
    public PersonaOutputDTO putById(int id, PersonaInputDTO personaInputDTO) throws Exception{
        try{
            personaRepository.deleteById(id);
            return setPersona(personaInputDTO);
        } catch (EmptyResultDataAccessException e){
            return setPersona(personaInputDTO);
        }
    }

    //Añadir personas
    public PersonaOutputDTO setPersona(PersonaInputDTO personaDTO) throws Exception{
        if(personaDTO.getUser()!=null){
            if(personaDTO.getUser().length()<6 || personaDTO.getUser().length()>10){
                throw new Exception();
            } else {
                PersonaEntity personaEntity = new PersonaEntity(personaDTO);//Convierto InputDTO en Entity con el constructor de Entity
                personaRepository.save(personaEntity);//Almaceno Entity en mi repositorio
                PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaEntity);//Convierto Entity en OutputDTO con el constructor de DTO
                System.out.println("Persona añadida");
                return personaOutputDTO;
            }
        } else {
            throw new Exception();
        }
    }
}