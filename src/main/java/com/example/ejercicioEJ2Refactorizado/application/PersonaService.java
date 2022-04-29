package com.example.ejercicioEJ2Refactorizado.application;

import com.example.ejercicioEJ2Refactorizado.domain.PersonaEntity;
import com.example.ejercicioEJ2Refactorizado.infrastructure.controllers.dto.input.PersonaInputDTO;
import com.example.ejercicioEJ2Refactorizado.infrastructure.controllers.dto.output.PersonaOutputDTO;
import com.example.ejercicioEJ2Refactorizado.infrastructure.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;

@Component
public class PersonaService implements Serializable {


    @Autowired
    PersonaRepository personaRepository;


    //Recibir todos las persona de mi BBDD
    public ArrayList<PersonaOutputDTO> getAll() {
        ArrayList<PersonaOutputDTO> lista= new ArrayList<PersonaOutputDTO>();
        for (int i =1; i<=personaRepository.count();i++){
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaRepository.getById(i));
            lista.add(personaOutputDTO);
        }
        return lista;

    }

    //Buscar por ID
    public PersonaOutputDTO getById(int id) throws Exception {
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaRepository.findById(id).orElseThrow(()-> new Exception("No existe ese ID")));
        return personaOutputDTO;
    }


    //Buscar by User (En el caso de que User pueda repetirse, sino quitaria ArrayList
    public ArrayList<PersonaOutputDTO> getByUser(String user){
        ArrayList<PersonaEntity> listaPersonasEntities = personaRepository.findByUser(user);
        ArrayList<PersonaOutputDTO> listaPersonasDTO = new ArrayList<PersonaOutputDTO>();
        for(int i=0;i<listaPersonasEntities.size();i++){
            PersonaEntity persona = listaPersonasEntities.get(i);
            PersonaOutputDTO personaDTO = new PersonaOutputDTO(persona);
            listaPersonasDTO.add(personaDTO);
        }
        return listaPersonasDTO;
    }

    /*//Buscar by User sin usar findByUser
    public ArrayList<PersonaOutputDTO> getByUser(String user){
        ArrayList<PersonaOutputDTO> listaPersonasDTO = new ArrayList<PersonaOutputDTO>();
        for(int i =1; i<=personaRepository.count();i++){
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaRepository.getById(i));
            if(personaOutputDTO.getUser().equals(user)){
                listaPersonasDTO.add(personaOutputDTO);
            }
        }
        return listaPersonasDTO;
    }*/

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