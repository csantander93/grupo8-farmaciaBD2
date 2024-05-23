package com.proyectofarmaciaBD2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "producto_vendido")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoVendido {

    private Producto producto;
    private int cantidad;
    private double precioUnitario;
    private double total;

}
