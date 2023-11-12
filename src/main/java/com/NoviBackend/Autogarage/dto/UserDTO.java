package com.NoviBackend.Autogarage.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
     Long id;
     String firstname;
     String lastname;
     String email;
     String password;
     String role;
}