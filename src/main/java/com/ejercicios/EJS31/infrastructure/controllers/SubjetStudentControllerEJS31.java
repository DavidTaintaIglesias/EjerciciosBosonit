package com.ejercicios.EJS31.infrastructure.controllers;

import com.ejercicios.EJS31.application.services.SubjetsStudentServiceEJS31;
import com.ejercicios.shared.exceptions.Unprocessable;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "EJS31")
@RestController
@RequestMapping("/EJS31")
public class SubjetStudentControllerEJS31 {

    @Autowired
    SubjetsStudentServiceEJS31 subjetsStudentService;

    @PutMapping("/student/{idStudent}/subjet/{idSubjet}")
    public String studentSubjet(@PathVariable int idStudent, @PathVariable int idSubjet, @RequestParam(defaultValue = "error") String putType){
        if(putType.equals("add")){
            return subjetsStudentService.addSubjet(idStudent, idSubjet);
        } else if(putType.equals("remove")){
            return subjetsStudentService.removeSubjet(idStudent, idSubjet);
        } else throw new Unprocessable("putType must be 'add' or 'remove'");
    }
}
