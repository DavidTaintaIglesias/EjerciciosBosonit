package com.ejercicios.DBA1.infrastructure.repository;

import com.ejercicios.DBA1.domain.entities.PersonaDBA1;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Configuration
public class PersonaRespositoryDBA1Impl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<PersonaDBA1> getData(HashMap<String, Object> conditions){

        //Creamos la consulta sobre nuestra entidad
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonaDBA1> query = cb.createQuery(PersonaDBA1.class);
        Root<PersonaDBA1> root = query.from(PersonaDBA1.class);

        //Creamos la lista para añadir a la query los comparadores de la busqueda
        List<Predicate> predicates = new ArrayList<>();

        conditions.forEach((field,value) ->{
            switch (field){//vemos que campo de nuestra persona estamos buscando
                case "name":
                    predicates.add(cb.equal(root.get(field), value));//Añadimos ese comparador a la lista
                    break;

                case "surname":
                    predicates.add(cb.equal(root.get(field), value));
                    break;

                case "user":
                    predicates.add(cb.equal(root.get(field), value));
                    break;
            }
        });

        /* Explicación de las ultimas lineas
            Predicate[] finalPredicates = new Predicate [predicates.size()] -> creamos un array del tamaño de nuestra lista de predicados.
            predicates.toArray(finalPredicates -> convertimos la lista en Array
            query.select(root).where(finalPredicates) -> creamos la consulta
            return entityManager.createQuery(query).(.....) -> recibimos los resultados
        */

        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));//where(-> Creamos la consulta final con nuestro array de comparadores)
        return entityManager.createQuery(query)//Ejecutamos la consulta en nuestra tabla
                .setMaxResults(1)//Maximos resultados de la página
                .setFirstResult(0)//resultado que queremos en primer lugar
                .getResultList();//Obtener la lista de resultados
    }
}
