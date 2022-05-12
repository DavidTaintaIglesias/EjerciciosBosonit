package com.ejercicios.BS9.infrastructure.feign;


import com.ejercicios.BS9.infrastructure.controllers.dto.output.ClientOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Etiqueta para crear la interfaz de Feign a la que llamare
@FeignClient(name = "feignClient", url = "http://localhost:8080/BS9/getclient/byid/")
//Url a la que hago la llamada para obtener los datos
//Declaro la variable url en propierties y asi puedo cambiar de servidor facilmente sin cambiar codigo
public interface IFeignClient {

  @GetMapping("/{id}")
  ClientOutputDTO callClient(@PathVariable int id); //Le paso por parametro la variable que luego sera el id final que consultare en mi nueva URL

}
