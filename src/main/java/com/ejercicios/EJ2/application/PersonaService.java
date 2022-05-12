package com.ejercicios.EJ2.application;

import com.ejercicios.EJ2.domain.Persona;
import com.ejercicios.EJ2.infrastructure.controllers.dto.input.PersonaInputDTO;
import com.ejercicios.EJ2.infrastructure.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

  @Autowired
  PersonaRepository personaRepository;

  //Recibir todos las persona de mi BBDD
  public List<Persona> getAll() {

    return personaRepository.findAll();
  }

  //Buscar por ID
  public Persona getById(int id) throws Exception {

    return personaRepository.findById(id).orElseThrow(() -> new Exception("No existe ese ID"));
  }

  //Buscar by User (En el caso de que User pueda repetirse, sino quitaria ArrayList
  public List<Persona> getByUser(String user) {

    return personaRepository.findByUser(user);
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
  public void deleteById(int id) throws Exception {

    boolean personExists = personaRepository.existsById(id);

    if (!personExists) {
      throw new Exception("Id no encontrado");
    }

    personaRepository.deleteById(id);
  }

  //Modificar por id
  public Persona editPersona(int id, PersonaInputDTO personaInputDTO) throws Exception {

    Persona persona = personaRepository.findById(id).orElseThrow(() -> new Exception("Persona no encontrada"));

    persona.setUser(personaInputDTO.getUser());
    persona.setPassword(personaInputDTO.getPassword());
    persona.setName(personaInputDTO.getName());
    persona.setSurname(personaInputDTO.getSurname());
    persona.setCompanyEmail(personaInputDTO.getCompanyEmail());
    persona.setPersonalEmail(personaInputDTO.getPersonalEmail());
    persona.setCity(personaInputDTO.getCity());
    persona.setActive(personaInputDTO.getActive());
    persona.setDate(personaInputDTO.getDate());
    persona.setImageUrl(personaInputDTO.getImageUrl());
    persona.setTerminationDate(personaInputDTO.getTerminationDate());

    return personaRepository.save(persona);
  }

  //Añadir personas
  public Persona createPersona(PersonaInputDTO personaDTO) {

    Persona personaEntity = new Persona(personaDTO);//Convierto InputDTO en Entity con el constructor de Entity

    return personaRepository.save(personaEntity);//Almaceno Entity en mi repositorio
  }

}