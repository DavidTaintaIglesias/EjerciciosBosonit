package com.ejercicios.BS9.infrastructure.controllers;

import com.ejercicios.BS9.aplication.services.GetUserService;
import com.ejercicios.BS9.infrastructure.controllers.dto.output.ClientOutputDTO;
import com.ejercicios.BS9.infrastructure.controllers.dto.output.UserOutputDTO;
//import com.ejercicios.BS9.infrastructure.feign.IFeignClient;
//Version de feign no compatible con 2.5.4 para Springboot, conflicto con swagger
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/BS9/getuser")
public class GetUserController {

    @Autowired
    GetUserService getUserService;

    /*@Autowired
    IFeignClient iFeignClient;*/
    //Instanciar la interfaz

    @GetMapping("/all")
    public List<UserOutputDTO> getAll(){
        return getUserService.getAll();
    }

    @GetMapping("/ById/{id}")
    public UserOutputDTO getById(@PathVariable int id){
        return getUserService.getById(id);
    }

    //Uso de RestTemplate
    @GetMapping("/client/{id}")
    public ClientOutputDTO getClient(@PathVariable int id){
        System.out.println("Template: Pido en User el cliente "+id);
        ResponseEntity<ClientOutputDTO> respuesta = new RestTemplate().getForEntity("http://localhost:8080/BS9/getclient/byid/"+id, ClientOutputDTO.class);
        //url del endpoint al que estoy llamando, clase del tipo de objeto que me devuelve el endpoint al que llamo
        System.out.println("Template: Ya me han devuelto en User el cliente "+id);
        return respuesta.getBody();
    }

    /*//Uso de Feign
    @GetMapping("/client/feign/{id}")
    public ClientOutputDTO getClientByFeign(@PathVariable int id){
        System.out.println("Feign: Pido en User el cliente "+id);
        ClientOutputDTO respuesta = iFeignClient.callClient(id);
        //con este código en esta url en la que estoy llamando a la interfaz hago que iFeignClient llame a la url de la interfaz
        System.out.println("Feign: Ya me han devuelto en User el cliente "+id);
        return respuesta;
    }*/
}
