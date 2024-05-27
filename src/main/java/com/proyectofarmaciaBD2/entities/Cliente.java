package com.proyectofarmaciaBD2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {

    private String apellido;
    private String nombre;
    private String dni;
    private Domicilio domicilio;
    private ObraSocial obraSocial;
    private String numeroAfiliado;

}
