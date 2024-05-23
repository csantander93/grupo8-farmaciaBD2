package com.proyectofarmaciaBD2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(value = "venta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Venta {
    private int id;
    private String numeroTicket;
    private Date fecha;
    private double total;
    private String formaPago; // Efectivo, Tarjeta o Débito
    private List<ProductoVendido> productos;
    private Empleado empleadoAtendio;
    private Empleado empleadoCobro;

}
