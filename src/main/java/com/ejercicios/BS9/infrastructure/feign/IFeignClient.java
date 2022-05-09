package com.ejercicios.BS9.infrastructure.feign;


import com.ejercicios.BS9.infrastructure.controllers.dto.output.ClientOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Etiqueta para crear la interfaz de Feign a la que llamare
@FeignClient(name = "feignClient", url = "http://localhost:8080/BS9/getclient/byid/")//Url a la que hago la llamada para obtener los datos
public interface IFeignClient {

    @GetMapping("/{id}")
    ResponseEntity<ClientOutputDTO> callClient(@PathVariable int id);
}
