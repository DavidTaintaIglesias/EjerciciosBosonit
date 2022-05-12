package com.ejercicios.BS4.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/BS4")
@PropertySource("application_BS4.properties")
public class Controller {

  @Value("${VAR1}")
  private String VAR1;

  @Value("${My.VAR2}")
  private int VAR2;

  @Value("${VAR3}")
  private String VAR3;

  @GetMapping("/valores")
  public String valores() {

    return "El valor de VAR1 es :" + VAR1 + ".\nValor de My.VAR2 es :" + VAR2 + ".";
  }

  @GetMapping("/var3")
  public String var3() {

    if (VAR3.length() == 0) {
      return "VAR3 no tiene valor";
    } else {
      return "Valor de VAR3 es: " + VAR3;
    }
  }

}
