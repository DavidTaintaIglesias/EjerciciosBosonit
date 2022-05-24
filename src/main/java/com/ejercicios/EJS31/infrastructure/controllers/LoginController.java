package com.ejercicios.EJS31.infrastructure.controllers;

import com.ejercicios.EJS31.application.services.LoginService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api("EJS31")
@RequestMapping("/EJS31")

public class LoginController {

    @Autowired
    LoginService loginService;


    @GetMapping("/login")
    public String login(){
        return "login";
        }
}
