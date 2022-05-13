package com.ejercicios.EJ31.infrastructure.controllers.dto.output;

import com.ejercicios.EJ31.domain.entities.Subjet;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class SubjetOutputDTO {

  private Integer id;
  private String name;
  private String coments;
  private LocalDate initialDate;
  private LocalDate finishDate;

  public SubjetOutputDTO(Subjet studentSubjets) {

    setId(studentSubjets.getId());
    setName(studentSubjets.getName());
    setComents(studentSubjets.getComents());
    setInitialDate(studentSubjets.getInitialDate());
    setFinishDate(studentSubjets.getFinishDate());
  }

}
