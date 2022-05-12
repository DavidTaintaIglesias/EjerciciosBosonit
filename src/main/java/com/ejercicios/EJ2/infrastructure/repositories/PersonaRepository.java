package com.ejercicios.EJ2.infrastructure.repositories;

import com.ejercicios.EJ2.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

  //@Query("aqui escribo la query que yo quiero")
  List<Persona> findByUser(String user);

  //El nombre de la funcion debe tener el nobre de la variable que busco.
  //SpringBoot hace el trabajo y me crea una funcion que busca en mi reposotrio el nombre que le mando por parametro (nombre de la variable no columna)
  //findByNombre_Columna(tipo_dato valor_a_comparar)
}
