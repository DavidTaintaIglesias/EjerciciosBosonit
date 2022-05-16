package com.ejercicios.JVA2.infrastructure.repository;

import com.ejercicios.JVA2.domain.entities.PersonaJVA2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PersonaRepositoryJVA2 extends JpaRepository<PersonaJVA2, Integer> {

    //@Query("aqui escribo la query que yo quiero")
    PersonaJVA2 findByUser(String user);

    //El nombre de la funcion debe tener el nobre de la variable que busco.
    //SpringBoot hace el trabajo y me crea una funcion que busca en mi reposotrio el nombre que le mando por parametro (nombre de la variable no columna)
    //findByNombre_Columna(tipo_dato valor_a_comparar)
}
