package com.proyectofarmaciaBD2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(value = "sucursal")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sucursal {

    @Id
    private int id;
    private Domicilio domicilio;
    private List<Empleado> empleados;
    private Empleado encargado;

}
