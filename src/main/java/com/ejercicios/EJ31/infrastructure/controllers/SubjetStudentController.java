package com.ejercicios.EJ31.infrastructure.controllers;

import com.ejercicios.EJ31.application.exceptions.UnprocessableException;
import com.ejercicios.EJ31.application.services.SubjetsStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/EJ31")
public class SubjetStudentController {

    @Autowired
    SubjetsStudentService subjetsStudentService;

    /*@PostMapping("/addSubjet/{idSubjet}/{idStudent}")
    public String addSubjet(@PathVariable int idSubjet, @PathVariable Integer idStudent){
        if(idStudent!=null){
            return subjetsStudentService.addSubjet(idStudent, idSubjet);
        } else throw new UnprocessableException("Student Id required");
    }

    @DeleteMapping("/removeSubjet/{idSubjet}/{idStudent}")
    public String removeSubjet(@PathVariable int idSubjet, @PathVariable Integer idStudent){
        if(idStudent!=null){
            return subjetsStudentService.removeSubjet(idStudent, idSubjet);
        } else throw new UnprocessableException("Student Id required");
    }*/

    @PutMapping("/student/{idStudent}/subjet/{idSubjet}")
    public String studentSubjet(@PathVariable int idStudent, @PathVariable int idSubjet, @RequestParam(defaultValue = "error") String putType){
        if(putType.equals("add")){
            return subjetsStudentService.addSubjet(idStudent, idSubjet);
        } else if(putType.equals("remove")){
            return subjetsStudentService.removeSubjet(idStudent, idSubjet);
        } else throw new UnprocessableException("putType must be 'add' or 'remove'");
    }
}
