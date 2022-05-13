package com.ejercicios.EJ31.application.services;

import com.ejercicios.EJ31.domain.entities.Subjet;
import com.ejercicios.EJ31.infrastructure.controllers.dto.input.SubjetInputDTO;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.SubjetOutputDTO;
import com.ejercicios.EJ31.infrastructure.repository.SubjetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostSubjetService {

  @Autowired
  SubjetsRepository subjetsRepository;

  public SubjetOutputDTO postSubjet(SubjetInputDTO subjetInputDTO) {

    Subjet subjet = new Subjet(subjetInputDTO);
    subjetsRepository.save(subjet);
    SubjetOutputDTO subjetOutputDTO = new SubjetOutputDTO(subjet);
    return subjetOutputDTO;
  }

}
