package com.ejercicios.EJ2.application;

import com.ejercicios.EJ2.domain.Persona;
import com.ejercicios.EJ2.infrastructure.controllers.dto.input.PersonaInputDTO;
import com.ejercicios.EJ2.infrastructure.controllers.dto.output.PersonaOutputDTO;
import com.ejercicios.EJ2.infrastructure.repositories.PersonaRepository;
import com.ejercicios.shared.exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PersonaService implements Serializable {


    @Autowired
    PersonaRepository personaRepository;


    //Recibir todos las persona de mi BBDD
    public List<PersonaOutputDTO> getAll() {
        List<Persona> personas = personaRepository.findAll();
        return personas.stream().map(PersonaOutputDTO::new).toList();

    }

    //Buscar por ID
    public PersonaOutputDTO getById(int id) throws Exception{
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaRepository.findById(id).orElseThrow(()-> new Exception("No existe ese ID")));
        return personaOutputDTO;
    }


    //Buscar by User (En el caso de que User pueda repetirse, sino quitaria ArrayList
    public ArrayList<PersonaOutputDTO> getByUser(String user){
        ArrayList<Persona> listaPersonasEntities = personaRepository.findByUser(user);
        ArrayList<PersonaOutputDTO> listaPersonasDTO = new ArrayList<PersonaOutputDTO>();
        for(int i=0;i<listaPersonasEntities.size();i++){
            Persona persona = listaPersonasEntities.get(i);
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
    public String deleteById(int id) throws EmptyResultDataAccessException {
        try{
            personaRepository.deleteById(id);
            return "Borrado el registro con el Id: "+id;
        } catch (EmptyResultDataAccessException e){
            return "Id no encontrado";
        }
    }

    //Modificar por id
    public PersonaOutputDTO putById(int id, PersonaInputDTO personaInputDTO) throws EmptyResultDataAccessException{
        try{
            personaRepository.deleteById(id);
            Persona personaEntity = new Persona(personaInputDTO);
            personaRepository.save(personaEntity);
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaEntity);
            return personaOutputDTO;
        } catch (EmptyResultDataAccessException e){
            Persona personaEntity = new Persona(personaInputDTO);
            personaRepository.save(personaEntity);
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaEntity);
            return personaOutputDTO;
        }
    }

    //Añadir personas
    public PersonaOutputDTO setPersona(PersonaInputDTO personaDTO) throws Exception{
        if(personaDTO.getUser()!=null){
            if(personaDTO.getUser().length()<6 || personaDTO.getUser().length()>10){
                throw new Exception("User debe estar entre 6 y 10 caracteres");
            } else {
                Persona personaEntity = new Persona(personaDTO);//Convierto InputDTO en Entity con el constructor de Entity
                personaRepository.save(personaEntity);//Almaceno Entity en mi repositorio
                PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaEntity);//Convierto Entity en OutputDTO con el constructor de DTO
                System.out.println("Persona añadida");
                return personaOutputDTO;
            }
        } else {
            throw new Exception("User no puede estar vacio");
        }
    }

    //Modificar algunos campos
    public Persona patchPersona(Integer id, Map<Object, Object> personaInputDTO) {

        Persona p = personaRepository.findById(id).orElseThrow(()-> new NotFound("Id not found"));

        personaInputDTO.forEach((k,v)->{
            Field field = ReflectionUtils.findField(Persona.class, (String) k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, p, v);
        });
        return personaRepository.save(p);
    }
}