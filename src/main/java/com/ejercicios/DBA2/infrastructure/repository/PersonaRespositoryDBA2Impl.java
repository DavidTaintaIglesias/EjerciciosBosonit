/*package com.ejercicios.DBA2.infrastructure.repository;

import com.ejercicios.DBA2.domain.entities.PersonaDBA2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaRespositoryDBA2Impl implements PersonaRepositoryDBA2{

    private final MongoTemplate mongoTemplate;

    @Autowired
    public PersonaRespositoryDBA2Impl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public PersonaDBA2 savePerson(PersonaDBA2 personaDBA2) {
        mongoTemplate.save(personaDBA2);
        return personaDBA2;
    }

    @Override
    public List<PersonaDBA2> getAllPerson() {
        return mongoTemplate.findAll(PersonaDBA2.class);
    }
}*/
