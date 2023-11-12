package com.NoviBackend.Autogarage.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    Long id;
    String brand;
    String model;
    int modelYear;
}
