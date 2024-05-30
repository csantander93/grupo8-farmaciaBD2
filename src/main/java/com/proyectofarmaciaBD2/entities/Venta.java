package com.proyectofarmaciaBD2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(value = "venta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Venta {

    private String numeroTicket;
    private LocalDate fecha;
    private double total;
    private String formaPago; // Efectivo, Tarjeta o Débito
    private List<ProductoVendido> productos;
    private Empleado empleadoAtendio;
    private Empleado empleadoCobro;
    private Cliente cliente;
    private Sucursal sucursal;

}
