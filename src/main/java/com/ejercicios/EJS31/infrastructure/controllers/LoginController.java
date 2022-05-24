package com.ejercicios.EJS31.infrastructure.controllers;

import com.ejercicios.EJS31.application.services.LoginService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(tags = "EJS31")
@RequestMapping("/EJS31")

public class LoginController {

    @Autowired
    LoginService loginService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("user") String user, @RequestParam("password") String password){
        return new ResponseEntity<>(loginService.getLogin(user, password), HttpStatus.OK);
        }
}
