package com.ejercicios;

//import com.ejercicios.EJS31.application.JWTAuthorizationFilter;

import com.ejercicios.EJS31.application.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableWebSecurity
//@EnableFeignClients//Etiqueta para activar las interfaces Feign
//Puedo ejecutar varios main a la vez y cambiando en Enviroments Variables server.port=8081 y levantar tantos servers en diferentes puertos como quiera.
public class Main extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers("/EJS31/login").permitAll()
				.antMatchers(HttpMethod.GET).permitAll()
				.antMatchers(HttpMethod.POST).hasRole("ADMIN")//IMPORTANTE!! Nombre del rol sin ROLE_
				.anyRequest().authenticated();
	}
}
