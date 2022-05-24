package com.ejercicios.EJS31.infrastructure.controllers;

import com.ejercicios.EJS31.application.services.PostSubjetServiceEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.input.SubjetInputDTOEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.output.SubjetOutputDTOEJS31;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "EJS31")
@RestController
@RequestMapping("/EJS31")
public class PostSubjetControllerEJS31 {

    @Autowired
    PostSubjetServiceEJS31 postSubjetService;

    @PostMapping("/postSubjet")
    public ResponseEntity<SubjetOutputDTOEJS31> postSubjet(@Valid @RequestBody SubjetInputDTOEJS31 subjetInputDTO){
        return new ResponseEntity<>(new SubjetOutputDTOEJS31(postSubjetService.postSubjet(subjetInputDTO)), HttpStatus.CREATED);
    }
}
