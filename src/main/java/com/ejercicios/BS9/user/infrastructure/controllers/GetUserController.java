package com.ejercicios.BS9.user.infrastructure.controllers;

import com.ejercicios.BS9.user.aplication.services.GetUserService;
import com.ejercicios.BS9.user.infrastructure.controllers.dto.output.UserOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/BS9/getuser")
public class GetUserController {

    @Autowired
    GetUserService getUserService;

    @GetMapping("/all")
    public List<UserOutputDTO> getAll(){
        return getUserService.getAll();
    }

    @GetMapping("/ById/{id}")
    public UserOutputDTO getById(@PathVariable int id){
        return getUserService.getById(id);
    }
}
