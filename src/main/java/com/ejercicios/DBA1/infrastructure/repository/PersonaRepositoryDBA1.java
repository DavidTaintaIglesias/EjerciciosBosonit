package com.ejercicios.DBA1.infrastructure.repository;

import com.ejercicios.DBA1.domain.entities.PersonaDBA1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;

public interface PersonaRepositoryDBA1 extends JpaRepository<PersonaDBA1, Integer> {

    PersonaDBA1 findByUser(String user);

    //public List<PersonaDBA1> getData(HashMap<String, Object> Conditions);
}
