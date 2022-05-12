package com.ejercicios.EJ31.infrastructure.controllers.dto.input;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PersonInputDTO {

  @NotNull(message = "user cannot be null")
  @Length(min = 6, max = 10, message = "user must be betwin 6 and 10 characters")
  private String user;

  @NotNull(message = "password cannot be null")
  private String password;

  @NotNull(message = "name cannot be null")
  private String name;

  private String surname;

  @NotNull(message = "companyEmail cannot be null")
  @Email(message = "companyEmail must be a valid email")
  private String companyEmail;

  @NotNull(message = "personalEmail cannot be null")
  @Email(message = "personalEmail must be a valid email")
  private String personalEmail;

  @NotNull(message = "city cannot be null")
  private String city;

  @NotNull(message = "active cannot be null")
  private boolean active;

  @NotNull(message = "createdDate cannot be null")
  private LocalDate createdDate;

  private String imageUrl;

  private LocalDate terminationDate;

}
