package com.ejercicios.RS1.controller;

import com.ejercicios.RS1.model.User;
import com.ejercicios.RS1.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "RS1")
@RestController
@RequestMapping("/RS1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User postUser(@RequestBody User u){
        userService.postGreeting(u);
        return u;
    }

    @GetMapping("/{id}")
    public String saludoId(@PathVariable String id){
        return "Hola usuario numero "+id;
    }

    @PutMapping
    public User putGreeting(@RequestParam (defaultValue = "sin nombre") String nombre, @RequestParam (defaultValue = "-1") int id){
        User user = new User(id, nombre);
        return user;
    }
}
