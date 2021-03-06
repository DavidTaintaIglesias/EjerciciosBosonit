package com.ejercicios.BS8.infrastructure.repository;

import com.ejercicios.BS8.domain.entities.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PersonaRepo extends JpaRepository<PersonaEntity, Integer> {

    //@Query("aqui escribo la query que yo quiero")
    Optional<PersonaEntity> findByUser(String user);

    //El nombre de la funcion debe tener el nobre de la variable que busco.
    //SpringBoot hace el trabajo y me crea una funcion que busca en mi reposotrio el nombre que le mando por parametro (nombre de la variable no columna)
    //findByNombre_Columna(tipo_dato valor_a_comparar)
}
