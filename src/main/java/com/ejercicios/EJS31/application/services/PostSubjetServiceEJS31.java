package com.ejercicios.EJS31.application.services;

import com.ejercicios.EJS31.domain.entities.SubjetEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.input.SubjetInputDTOEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.output.SubjetOutputDTOEJS31;
import com.ejercicios.EJS31.infrastructure.repository.SubjetsRepositoryEJS31;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostSubjetServiceEJS31 {

    @Autowired
    SubjetsRepositoryEJS31 subjetsRepository;

    public SubjetOutputDTOEJS31 postSubjet(SubjetInputDTOEJS31 subjetInputDTO){
        SubjetEJS31 subjet = new SubjetEJS31(subjetInputDTO);
        subjetsRepository.save(subjet);
        SubjetOutputDTOEJS31 subjetOutputDTO = new SubjetOutputDTOEJS31(subjet);
        return subjetOutputDTO;
    }
}
