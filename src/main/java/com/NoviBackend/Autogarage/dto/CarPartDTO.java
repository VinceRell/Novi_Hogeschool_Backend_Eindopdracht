package com.NoviBackend.Autogarage.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarPartDTO {
    Long id;
    String partName;
    double price;
    int stock;
}
