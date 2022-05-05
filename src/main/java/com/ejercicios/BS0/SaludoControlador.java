package com.ejercicios.BS0;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/BS0")
public class SaludoControlador {

    @GetMapping("/user/{nombre}")
    public String getNombre(@PathVariable String nombre){ //@PathVariable coge la variable de la ruta y la introduce en mi variable nombre
        return "Hola "+nombre; //Devuelvo por pantalla el saludo + el nombre de la persona
    }

    @GetMapping("/variasVariables")
    public String addUser(@RequestParam (defaultValue = "Sin asignar") String tel, @RequestParam(defaultValue = "Sin nombre") String nombre){
        return "Telefono: "+tel+ "-> nombre: "+nombre;
    }

}
