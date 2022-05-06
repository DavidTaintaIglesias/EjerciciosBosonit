package com.ejercicios.EJ31.infrastructure.repository;

import com.ejercicios.EJ31.domain.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

    //@Query("aqui escribo la query que yo quiero")
    Optional<PersonEntity> findByUser(String user);

    //El nombre de la funcion debe tener el nobre de la variable que busco.
    //SpringBoot hace el trabajo y me crea una funcion que busca en mi reposotrio el nombre que le mando por parametro (nombre de la variable no columna)
    //findByNombre_Columna(tipo_dato valor_a_comparar)

    Optional<PersonEntity> findByNameAndSurname(String name, String surname);//asi busco por nombre y apellido, puedo buscar por cualquier campo de mi entidad
    //El optional es para evitarme los null en caso de que no encuentre lo buscado

}
