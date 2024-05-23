package com.proyectofarmaciaBD2.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "domicilio")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Domicilio {

    private String calle;
    private int numero;
    private String localidad;
    private String provincia;

}
