package com.proyectofarmaciaBD2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "obra_social")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ObraSocial {

    @Id
    private int id;
    private String nombre;

}
