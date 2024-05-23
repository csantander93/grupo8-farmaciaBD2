package com.proyectofarmaciaBD2.dtos.request.Domicilio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DomicilioDTORequest {

    private String calle;
    private int numero;
    private String localidad;
    private String provincia;

}
