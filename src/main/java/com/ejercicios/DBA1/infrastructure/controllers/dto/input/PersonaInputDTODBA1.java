package com.ejercicios.DBA1.infrastructure.controllers.dto.input;

import java.time.LocalDate;

public record PersonaInputDTODBA1(
        String user,
        String password,
        String name,
        String surname,
        String companyEmail,
        String personalEmail,
        String city,
        Boolean active,
        LocalDate date,
        String imageUrl,
        LocalDate termination_date
) {
}

/*@Data
public class PersonaInputDTOJVA2 {


    private String user;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private Boolean active;
    private Date date;
    private String imageUrl;
    private Date termination_date;


}*/

