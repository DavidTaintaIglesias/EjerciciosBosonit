package com.ejercicios.EJ31.infrastructure.controllers.dto.output;

import com.ejercicios.EJ31.domain.entities.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentOutputDTO {

  private Integer id;
  private Integer idPerson;
  private int numHours;
  private String coments;
  private Integer idProfesor;
  private String branch;

  public StudentOutputDTO(Student student) {

    setId(student.getId());
    setIdPerson(student.getPerson().getId());
    setNumHours(student.getNumHours());
    setComents(student.getComents());
    setIdProfesor(student.getProfesor().getId());
    setBranch(student.getBranch());
  }

}
