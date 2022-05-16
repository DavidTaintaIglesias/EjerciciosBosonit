/*package com.ejercicios.DBA1.infrastructure.repository;

import com.ejercicios.DBA1.domain.entities.PersonaDBA1;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonaRespositoryDBA1Impl {
    private EntityManager entityManager;

    public List<PersonaDBA1> getData(HashMap<String, Object> conditions){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonaDBA1> query = cb.createQuery(PersonaDBA1.class);
        Root<PersonaDBA1> root = query.from(PersonaDBA1.class);

        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach((field,value) ->{
            switch (field){
                case "user":
                    predicates.add(cb.equal(root.get(field),value));
                    break;
                case "name":
                    predicates.add(cb.equal(root.get(field),value));
                    break;
                case "surname":
                    predicates.add(cb.equal(root.get(field), value));
                    break;
            }
        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }
}*/
