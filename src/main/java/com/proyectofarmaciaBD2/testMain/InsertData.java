package com.proyectofarmaciaBD2.testMain;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.proyectofarmaciaBD2.dao.MongoDBConnection;
import com.proyectofarmaciaBD2.entities.*;
import org.bson.Document;

import java.util.Arrays;
import java.util.Date;

public class InsertData {
    public static void main(String[] args) {
        MongoDatabase database = MongoDBConnection.connectToDatabase("farmaciaDB");

        // Crear domicilios
        Domicilio domicilio = new Domicilio(1, "Avenida Siempreviva", 742, "Springfield", "Illinois");
        Domicilio domicilio2 = new Domicilio(2, "Peron", 111, "Guernica", "Buenos Aires");
        Domicilio domicilio3 = new Domicilio(3, "Av. de Mayo", 222, "Nuñez", "CABA");
        Domicilio domicilioSucursal = new Domicilio(4, "Av. Santa Fe", 7, "Palermo", "CABA");

        // Crear una obra social
        ObraSocial obraSocial = new ObraSocial(1, "OSDE");

        // Crear un cliente
        Cliente cliente = new Cliente(1, "Santander", "Cristian", "12345678", domicilio, obraSocial, "12345678");

        // Crear empleados
        Empleado cajero = new Empleado(1, "Pico", "Juan", "99999999", "20-99999999-9", domicilio2, obraSocial, "11111111");
        Empleado vendedor = new Empleado(2, "Renda", "Belen", "123456789", "20-123456789-9", domicilio3, obraSocial, "22222222");

        // Crear productos
        Producto producto1 = new Producto(1, "Ibuprofeno", "Medicamento", "Laboratorio A", 10.0);
        Producto producto2 = new Producto(2, "Shampoo", "Perfumería", "Laboratorio B", 15.0);
        Producto producto3 = new Producto(3, "Paracetamol", "Medicamento", "Laboratorio C", 5.0);
        Producto producto4 = new Producto(4, "Jabón", "Perfumería", "Laboratorio D", 2.0);

        // Crear productos vendidos
        ProductoVendido productoVendido1 = new ProductoVendido(producto1, 2, 10.0, 20.0);
        ProductoVendido productoVendido2 = new ProductoVendido(producto2, 1, 15.0, 15.0);
        ProductoVendido productoVendido3 = new ProductoVendido(producto3, 3, 5.0, 15.0);
        ProductoVendido productoVendido4 = new ProductoVendido(producto4, 4, 2.0, 8.0);

        // Crear ventas
        Venta venta1 = new Venta(1, "0001-00000123", new Date(), 35.0, "Efectivo", Arrays.asList(productoVendido1, productoVendido2), vendedor, cajero);
        Venta venta2 = new Venta(2, "0001-00000124", new Date(), 23.0, "Tarjeta", Arrays.asList(productoVendido3, productoVendido4), vendedor, cajero);
        Venta venta3 = new Venta(3, "0001-00000125", new Date(), 28.0, "Efectivo", Arrays.asList(productoVendido1, productoVendido3), vendedor, cajero);
        Venta venta4 = new Venta(4, "0001-00000126", new Date(), 10.0, "Tarjeta", Arrays.asList(productoVendido4), vendedor, cajero);
        Venta venta5 = new Venta(5, "0001-00000127", new Date(), 45.0, "Efectivo", Arrays.asList(productoVendido2, productoVendido3, productoVendido4), vendedor, cajero);
        Venta venta6 = new Venta(6, "0001-00000128", new Date(), 20.0, "Tarjeta", Arrays.asList(productoVendido1), vendedor, cajero);
        Venta venta7 = new Venta(7, "0001-00000129", new Date(), 60.0, "Efectivo", Arrays.asList(productoVendido2, productoVendido3), vendedor, cajero);
        Venta venta8 = new Venta(8, "0001-00000130", new Date(), 18.0, "Tarjeta", Arrays.asList(productoVendido4, productoVendido1), vendedor, cajero);
        Venta venta9 = new Venta(9, "0001-00000131", new Date(), 35.0, "Efectivo", Arrays.asList(productoVendido1, productoVendido2), vendedor, cajero);
        Venta venta10 = new Venta(10, "0001-00000132", new Date(), 23.0, "Tarjeta", Arrays.asList(productoVendido3, productoVendido4), vendedor, cajero);

        // Crear una sucursal
        Sucursal sucursal = new Sucursal(1, domicilioSucursal, Arrays.asList(cajero, vendedor), cajero);

        // Insertar documentos en MongoDB
        MongoCollection<Document> clientesCollection = database.getCollection("clientes");
        clientesCollection.insertOne(new Document()
                .append("id", cliente.getId())
                .append("apellido", cliente.getApellido())
                .append("nombre", cliente.getNombre())
                .append("dni", cliente.getDni())
                .append("domicilio", new Document()
                        .append("calle", domicilio.getCalle())
                        .append("numero", domicilio.getNumero())
                        .append("localidad", domicilio.getLocalidad())
                        .append("provincia", domicilio.getProvincia()))
                .append("obraSocial", new Document()
                        .append("id", obraSocial.getId())
                        .append("nombre", obraSocial.getNombre()))
                .append("numeroAfiliado", cliente.getNumeroAfiliado()));

        MongoCollection<Document> empleadosCollection = database.getCollection("empleados");
        empleadosCollection.insertOne(new Document()
                .append("id", vendedor.getId())
                .append("apellido", vendedor.getApellido())
                .append("nombre", vendedor.getNombre())
                .append("dni", vendedor.getDni())
                .append("cuil", vendedor.getCuil())
                .append("domicilio", new Document()
                        .append("calle", domicilio3.getCalle())
                        .append("numero", domicilio3.getNumero())
                        .append("localidad", domicilio3.getLocalidad())
                        .append("provincia", domicilio3.getProvincia()))
                .append("obraSocial", new Document()
                        .append("id", obraSocial.getId())
                        .append("nombre", obraSocial.getNombre()))
                .append("numeroAfiliado", vendedor.getNumeroAfiliado()));

        empleadosCollection.insertOne(new Document()
                .append("id", cajero.getId())
                .append("apellido", cajero.getApellido())
                .append("nombre", cajero.getNombre())
                .append("dni", cajero.getDni())
                .append("cuil", cajero.getCuil())
                .append("domicilio", new Document()
                        .append("calle", domicilio2.getCalle())
                        .append("numero", domicilio2.getNumero())
                        .append("localidad", domicilio2.getLocalidad())
                        .append("provincia", domicilio2.getProvincia()))
                .append("obraSocial", new Document()
                        .append("id", obraSocial.getId())
                        .append("nombre", obraSocial.getNombre()))
                .append("numeroAfiliado", cajero.getNumeroAfiliado()));

        MongoCollection<Document> productosCollection = database.getCollection("productos");
        productosCollection.insertOne(new Document()
                .append("id", producto1.getId())
                .append("descripcion", producto1.getDescripcion())
                .append("tipo", producto1.getTipo())
                .append("laboratorio", producto1.getLaboratorio())
                .append("precio", producto1.getPrecio()));

        productosCollection.insertOne(new Document()
                .append("id", producto2.getId())
                .append("descripcion", producto2.getDescripcion())
                .append("tipo", producto2.getTipo())
                .append("laboratorio", producto2.getLaboratorio())
                .append("precio", producto2.getPrecio()));

        productosCollection.insertOne(new Document()
                .append("id", producto3.getId())
                .append("descripcion", producto3.getDescripcion())
                .append("tipo", producto3.getTipo())
                .append("laboratorio", producto3.getLaboratorio())
                .append("precio", producto3.getPrecio()));

        productosCollection.insertOne(new Document()
                .append("id", producto4.getId())
                .append("descripcion", producto4.getDescripcion())
                .append("tipo", producto4.getTipo())
                .append("laboratorio", producto4.getLaboratorio())
                .append("precio", producto4.getPrecio()));

        MongoCollection<Document> ventasCollection = database.getCollection("ventas");

        // Insertar las ventas iniciales
        ventasCollection.insertOne(new Document()
                .append("id", venta1.getId())
                .append("numeroTicket", venta1.getNumeroTicket())
                .append("fecha", venta1.getFecha())
                .append("total", venta1.getTotal())
                .append("formaPago", venta1.getFormaPago())
                .append("productos", Arrays.asList(
                        new Document()
                                .append("producto", new Document()
                                        .append("id", producto1.getId())
                                        .append("descripcion", producto1.getDescripcion())
                                        .append("tipo", producto1.getTipo())
                                        .append("laboratorio", producto1.getLaboratorio())
                                        .append("precio", producto1.getPrecio()))
                                .append("cantidad", productoVendido1.getCantidad())
                                .append("precioUnitario", productoVendido1.getPrecioUnitario())
                                .append("total", productoVendido1.getTotal()),
                        new Document()
                                .append("producto", new Document()
                                        .append("id", producto2.getId())
                                        .append("descripcion", producto2.getDescripcion())
                                        .append("tipo", producto2.getTipo())
                                        .append("laboratorio", producto2.getLaboratorio())
                                        .append("precio", producto2.getPrecio()))
                                .append("cantidad", productoVendido2.getCantidad())
                                .append("precioUnitario", productoVendido2.getPrecioUnitario())
                                .append("total", productoVendido2.getTotal())))
                .append("empleadoAtendio", new Document()
                        .append("id", vendedor.getId())
                        .append("apellido", vendedor.getApellido())
                        .append("nombre", vendedor.getNombre())
                        .append("dni", vendedor.getDni())
                        .append("cuil", vendedor.getCuil())
                        .append("domicilio", new Document()
                                .append("calle", domicilio3.getCalle())
                                .append("numero", domicilio3.getNumero())
                                .append("localidad", domicilio3.getLocalidad())
                                .append("provincia", domicilio3.getProvincia()))
                        .append("obraSocial", new Document()
                                .append("id", obraSocial.getId())
                                .append("nombre", obraSocial.getNombre()))
                        .append("numeroAfiliado", vendedor.getNumeroAfiliado()))
                .append("empleadoCobro", new Document()
                        .append("id", cajero.getId())
                        .append("apellido", cajero.getApellido())
                        .append("nombre", cajero.getNombre())
                        .append("dni", cajero.getDni())
                        .append("cuil", cajero.getCuil())
                        .append("domicilio", new Document()
                                .append("calle", domicilio2.getCalle())
                                .append("numero", domicilio2.getNumero())
                                .append("localidad", domicilio2.getLocalidad())
                                .append("provincia", domicilio2.getProvincia()))
                        .append("obraSocial", new Document()
                                .append("id", obraSocial.getId())
                                .append("nombre", obraSocial.getNombre()))
                        .append("numeroAfiliado", cajero.getNumeroAfiliado())));

        ventasCollection.insertOne(new Document()
                .append("id", venta2.getId())
                .append("numeroTicket", venta2.getNumeroTicket())
                .append("fecha", venta2.getFecha())
                .append("total", venta2.getTotal())
                .append("formaPago", venta2.getFormaPago())
                .append("productos", Arrays.asList(
                        new Document()
                                .append("producto", new Document()
                                        .append("id", producto3.getId())
                                        .append("descripcion", producto3.getDescripcion())
                                        .append("tipo", producto3.getTipo())
                                        .append("laboratorio", producto3.getLaboratorio())
                                        .append("precio", producto3.getPrecio()))
                                .append("cantidad", productoVendido3.getCantidad())
                                .append("precioUnitario", productoVendido3.getPrecioUnitario())
                                .append("total", productoVendido3.getTotal()),
                        new Document()
                                .append("producto", new Document()
                                        .append("id", producto4.getId())
                                        .append("descripcion", producto4.getDescripcion())
                                        .append("tipo", producto4.getTipo())
                                        .append("laboratorio", producto4.getLaboratorio())
                                        .append("precio", producto4.getPrecio()))
                                .append("cantidad", productoVendido4.getCantidad())
                                .append("precioUnitario", productoVendido4.getPrecioUnitario())
                                .append("total", productoVendido4.getTotal())))
                .append("empleadoAtendio", new Document()
                        .append("id", vendedor.getId())
                        .append("apellido", vendedor.getApellido())
                        .append("nombre", vendedor.getNombre())
                        .append("dni", vendedor.getDni())
                        .append("cuil", vendedor.getCuil())
                        .append("domicilio", new Document()
                                .append("calle", domicilio3.getCalle())
                                .append("numero", domicilio3.getNumero())
                                .append("localidad", domicilio3.getLocalidad())
                                .append("provincia", domicilio3.getProvincia()))
                        .append("obraSocial", new Document()
                                .append("id", obraSocial.getId())
                                .append("nombre", obraSocial.getNombre()))
                        .append("numeroAfiliado", vendedor.getNumeroAfiliado()))
                .append("empleadoCobro", new Document()
                        .append("id", cajero.getId())
                        .append("apellido", cajero.getApellido())
                        .append("nombre", cajero.getNombre())
                        .append("dni", cajero.getDni())
                        .append("cuil", cajero.getCuil())
                        .append("domicilio", new Document()
                                .append("calle", domicilio2.getCalle())
                                .append("numero", domicilio2.getNumero())
                                .append("localidad", domicilio2.getLocalidad())
                                .append("provincia", domicilio2.getProvincia()))
                        .append("obraSocial", new Document()
                                .append("id", obraSocial.getId())
                                .append("nombre", obraSocial.getNombre()))
                        .append("numeroAfiliado", cajero.getNumeroAfiliado())));

        // Insertar las ventas adicionales
        for (Venta venta : Arrays.asList(venta3, venta4, venta5, venta6, venta7, venta8, venta9, venta10)) {
            ventasCollection.insertOne(new Document()
                    .append("id", venta.getId())
                    .append("numeroTicket", venta.getNumeroTicket())
                    .append("fecha", venta.getFecha())
                    .append("total", venta.getTotal())
                    .append("formaPago", venta.getFormaPago())
                    .append("productos", Arrays.asList(
                            new Document()
                                    .append("producto", new Document()
                                            .append("id", producto1.getId())
                                            .append("descripcion", producto1.getDescripcion())
                                            .append("tipo", producto1.getTipo())
                                            .append("laboratorio", producto1.getLaboratorio())
                                            .append("precio", producto1.getPrecio()))
                                    .append("cantidad", productoVendido1.getCantidad())
                                    .append("precioUnitario", productoVendido1.getPrecioUnitario())
                                    .append("total", productoVendido1.getTotal()),
                            new Document()
                                    .append("producto", new Document()
                                            .append("id", producto2.getId())
                                            .append("descripcion", producto2.getDescripcion())
                                            .append("tipo", producto2.getTipo())
                                            .append("laboratorio", producto2.getLaboratorio())
                                            .append("precio", producto2.getPrecio()))
                                    .append("cantidad", productoVendido2.getCantidad())
                                    .append("precioUnitario", productoVendido2.getPrecioUnitario())
                                    .append("total", productoVendido2.getTotal())))
                    .append("empleadoAtendio", new Document()
                            .append("id", vendedor.getId())
                            .append("apellido", vendedor.getApellido())
                            .append("nombre", vendedor.getNombre())
                            .append("dni", vendedor.getDni())
                            .append("cuil", vendedor.getCuil())
                            .append("domicilio", new Document()
                                    .append("calle", domicilio3.getCalle())
                                    .append("numero", domicilio3.getNumero())
                                    .append("localidad", domicilio3.getLocalidad())
                                    .append("provincia", domicilio3.getProvincia()))
                            .append("obraSocial", new Document()
                                    .append("id", obraSocial.getId())
                                    .append("nombre", obraSocial.getNombre()))
                            .append("numeroAfiliado", vendedor.getNumeroAfiliado()))
                    .append("empleadoCobro", new Document()
                            .append("id", cajero.getId())
                            .append("apellido", cajero.getApellido())
                            .append("nombre", cajero.getNombre())
                            .append("dni", cajero.getDni())
                            .append("cuil", cajero.getCuil())
                            .append("domicilio", new Document()
                                    .append("calle", domicilio2.getCalle())
                                    .append("numero", domicilio2.getNumero())
                                    .append("localidad", domicilio2.getLocalidad())
                                    .append("provincia", domicilio2.getProvincia()))
                            .append("obraSocial", new Document()
                                    .append("id", obraSocial.getId())
                                    .append("nombre", obraSocial.getNombre()))
                            .append("numeroAfiliado", cajero.getNumeroAfiliado())));
        }

        MongoCollection<Document> sucursalesCollection = database.getCollection("sucursales");
        sucursalesCollection.insertOne(new Document()
                .append("id", sucursal.getId())
                .append("domicilio", new Document()
                        .append("calle", domicilioSucursal.getCalle())
                        .append("numero", domicilioSucursal.getNumero())
                        .append("localidad", domicilioSucursal.getLocalidad())
                        .append("provincia", domicilioSucursal.getProvincia()))
                .append("empleados", Arrays.asList(
                        new Document()
                                .append("id", cajero.getId())
                                .append("apellido", cajero.getApellido())
                                .append("nombre", cajero.getNombre())
                                .append("dni", cajero.getDni())
                                .append("cuil", cajero.getCuil())
                                .append("domicilio", new Document()
                                        .append("calle", domicilio2.getCalle())
                                        .append("numero", domicilio2.getNumero())
                                        .append("localidad", domicilio2.getLocalidad())
                                        .append("provincia", domicilio2.getProvincia()))
                                .append("obraSocial", new Document()
                                        .append("id", obraSocial.getId())
                                        .append("nombre", obraSocial.getNombre()))
                                .append("numeroAfiliado", cajero.getNumeroAfiliado()),
                        new Document() // Nuevo documento para el vendedor
                                .append("id", vendedor.getId())
                                .append("apellido", vendedor.getApellido())
                                .append("nombre", vendedor.getNombre())
                                .append("dni", vendedor.getDni())
                                .append("cuil", vendedor.getCuil())
                                .append("domicilio", new Document()
                                        .append("calle", domicilio3.getCalle())
                                        .append("numero", domicilio3.getNumero())
                                        .append("localidad", domicilio3.getLocalidad())
                                        .append("provincia", domicilio3.getProvincia()))
                                .append("obraSocial", new Document()
                                        .append("id", obraSocial.getId())
                                        .append("nombre", obraSocial.getNombre()))
                                .append("numeroAfiliado", vendedor.getNumeroAfiliado())))
                .append("encargado", new Document()
                        .append("id", cajero.getId())
                        .append("apellido", cajero.getApellido())
                        .append("nombre", cajero.getNombre())
                        .append("dni", cajero.getDni())
                        .append("cuil", cajero.getCuil())
                        .append("domicilio", new Document()
                                .append("calle", domicilio2.getCalle())
                                .append("numero", domicilio2.getNumero())
                                .append("localidad", domicilio2.getLocalidad())
                                .append("provincia", domicilio2.getProvincia()))
                        .append("obraSocial", new Document()
                                .append("id", obraSocial.getId())
                                .append("nombre", obraSocial.getNombre()))
                        .append("numeroAfiliado", cajero.getNumeroAfiliado())));

        MongoDBConnection.closeConnection();
    }
}
