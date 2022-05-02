package com.example.ejercicioBS8.infrastructure.repository;

import com.example.ejercicioBS8.domain.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {

    //@Query("aqui escribo la query que yo quiero")
    Optional<PersonaEntity> findByUser(String user);

    //El nombre de la funcion debe tener el nobre de la variable que busco.
    //SpringBoot hace el trabajo y me crea una funcion que busca en mi reposotrio el nombre que le mando por parametro (nombre de la variable no columna)
    //findByNombre_Columna(tipo_dato valor_a_comparar)
}
