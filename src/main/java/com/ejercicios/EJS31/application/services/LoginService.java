package com.ejercicios.EJS31.application.services;

import com.ejercicios.EJS31.domain.entities.PersonEJS31;
import com.ejercicios.EJS31.infrastructure.repository.PersonRepositoryEJS31;
import com.ejercicios.shared.exceptions.NotFound;
import com.ejercicios.shared.exceptions.Unprocessable;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginService {

    @Autowired
    PersonRepositoryEJS31 personRepository;

    public String getLogin(String user, String pass){

        PersonEJS31 person = personRepository.findByUser(user).orElseThrow(()-> new NotFound("User not found"));

        String password = person.getPassword();

        if(!pass.equals(password)){
            throw new Unprocessable("Wrong password");
        }

        if(!person.isAdmin()){
            return "You are not an admin";
        }

        String rol = "ROLE_ADMIN";//Puedo poner tantos roles como necesite. Poner siempre ROLE_ delante del nombre del rol
        return getJWTToken(user, rol);
    }

    private String getJWTToken(String user, String rol) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(rol);

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(user)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
