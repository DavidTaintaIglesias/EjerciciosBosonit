package com.ejercicios.EJS31.infrastructure.controllers.dto.output;

import com.ejercicios.EJS31.domain.entities.SubjetEJS31;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class SubjetOutputDTOEJS31 {

    private Integer id;
    private String name;
    private String coments;
    private LocalDate initialDate;
    private LocalDate finishDate;

    public SubjetOutputDTOEJS31(SubjetEJS31 studentSubjets){
        setId(studentSubjets.getId());
        setName(studentSubjets.getName());
        setComents(studentSubjets.getComents());
        setInitialDate(studentSubjets.getInitialDate());
        setFinishDate(studentSubjets.getFinishDate());
    }
}
