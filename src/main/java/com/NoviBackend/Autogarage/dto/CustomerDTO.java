package com.NoviBackend.Autogarage.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    Long id;
    String firstName;
    String lastName;
    String phoneNumber;
}
