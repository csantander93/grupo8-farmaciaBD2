package com.proyectofarmaciaBD2.testMain.consultas.testActividad2;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.proyectofarmaciaBD2.dao.MongoDBConnection;
import com.proyectofarmaciaBD2.entities.*;
import org.bson.Document;

import java.time.LocalDate;
import java.util.Arrays;

public class InsertData {
    public static void main(String[] args) {
        MongoDatabase database = MongoDBConnection.connectToDatabase("farmaciaDB");

        // Crear domicilios
        Domicilio domicilio = new Domicilio("Avenida Siempreviva", 742, "Springfield", "Illinois");
        Domicilio domicilio2 = new Domicilio("Peron", 111, "Guernica", "Buenos Aires");
        Domicilio domicilio3 = new Domicilio("Av. de Mayo", 222, "Nuñez", "CABA");
        Domicilio domicilioSucursal1 = new Domicilio("Av. Santa Fe", 7, "Palermo", "CABA");
        Domicilio domicilioSucursal2 = new Domicilio("Cabildo", 333, "Recoleta", "CABA");
        Domicilio domicilioSucursal3 = new Domicilio("Calle falsa", 123, "Banfield", "Buenos Aires");


        // Crear una obra social
        ObraSocial obraSocial = new ObraSocial("OSDE");
        ObraSocial obraSocial2 = new ObraSocial("OSECAC");
        ObraSocial obraSocial3 = new ObraSocial("IOMA");

        // Crear un cliente
        Cliente cliente = new Cliente("Santander", "Cristian", "12345678", domicilio, obraSocial3, "12345678");
        Cliente cliente2 = new Cliente("Lopez", "Marcelo", "11111111", domicilio, obraSocial3, "87654321");
        Cliente cliente3 = new Cliente("Ribeiro", "Federico", "22222222", domicilio, obraSocial3, "11223344");

        // Crear empleados
        Empleado cajero1 = new Empleado("Pico", "Juan", "99999999", "20-99999999-9", domicilio2, obraSocial2, "11111111");
        Empleado cajero2 = new Empleado("Facundo", "Lopez", "12344556", "20-12344556-9", domicilio2, obraSocial, "11111112");
        Empleado cajero3 = new Empleado("Mario", "Bros", "11336688", "20-11336688-1", domicilio3, obraSocial, "11111114");


        Empleado vendedor1 = new Empleado("Renda", "Belen", "123456789", "27-123456789-9", domicilio3, obraSocial2, "22222223");
        Empleado vendedor2 = new Empleado("Kevin", "Oviedo", "87654321", "20-87654321-9", domicilio3, obraSocial, "22222224");
        Empleado vendedor3 = new Empleado("Rodriguez", "Mariano", "88995544", "20-88995544-9", domicilio3, obraSocial, "111122223");

        // Crear productos
        Producto producto1 = new Producto("Ibuprofeno", "Medicamento", "Laboratorio A", 10.0);
        Producto producto2 = new Producto("Shampoo", "Perfumería", "Laboratorio B", 15.0);
        Producto producto3 = new Producto("Paracetamol", "Medicamento", "Laboratorio C", 5.0);
        Producto producto4 = new Producto("Jabón", "Perfumería", "Laboratorio D", 2.0);

        // Crear productos vendidos
        ProductoVendido productoVendido1 = new ProductoVendido(producto1, 2, 10.0, 20.0);
        ProductoVendido productoVendido2 = new ProductoVendido(producto2, 1, 15.0, 15.0);
        ProductoVendido productoVendido3 = new ProductoVendido(producto3, 3, 5.0, 15.0);
        ProductoVendido productoVendido4 = new ProductoVendido(producto4, 4, 2.0, 8.0);

        // Crear una sucursal
        Sucursal sucursal1 = new Sucursal("sucursal1", domicilioSucursal1, Arrays.asList(cajero1, vendedor1), cajero1);
        Sucursal sucursal2 = new Sucursal("sucursal2", domicilioSucursal2, Arrays.asList(cajero2, vendedor2), vendedor2);
        Sucursal sucursal3 = new Sucursal("sucursal3", domicilioSucursal3, Arrays.asList(cajero3, vendedor3), cajero3);

        // Crear ventas
        Venta venta1 = new Venta("0001-00000123", LocalDate.of(2024, 5, 5), 35.0, "Efectivo", Arrays.asList(productoVendido1, productoVendido2), vendedor1, cajero1, cliente, sucursal1);
        Venta venta2 = new Venta("0001-00000124", LocalDate.of(2024, 5, 5), 23.0, "Tarjeta", Arrays.asList(productoVendido3, productoVendido4), vendedor1, cajero1, cliente, sucursal1);
        Venta venta3 = new Venta("0001-00000125", LocalDate.of(2024, 5, 5), 28.0, "Efectivo", Arrays.asList(productoVendido1, productoVendido3), vendedor1, cajero1, cliente, sucursal1);
        Venta venta4 = new Venta("0001-00000126", LocalDate.of(2024, 5, 5), 10.0, "Tarjeta", Arrays.asList(productoVendido4), vendedor1, cajero1, cliente, sucursal1);
        Venta venta5 = new Venta("0001-00000127", LocalDate.of(2024, 5, 7), 45.0, "Efectivo", Arrays.asList(productoVendido2, productoVendido3, productoVendido4), vendedor1, cajero1, cliente, sucursal1);
        Venta venta6 = new Venta("0001-00000128", LocalDate.now(), 20.0, "Tarjeta", Arrays.asList(productoVendido1), vendedor1, cajero1, cliente, sucursal1);
        Venta venta7 = new Venta("0001-00000129", LocalDate.of(2024, 5, 5), 60.0, "Efectivo", Arrays.asList(productoVendido2, productoVendido3), vendedor1, cajero1, cliente, sucursal1);
        Venta venta8 = new Venta("0001-00000130", LocalDate.of(2024, 5, 7), 18.0, "Tarjeta", Arrays.asList(productoVendido4, productoVendido1), vendedor1, cajero1, cliente, sucursal1);
        Venta venta9 = new Venta("0001-00000131", LocalDate.of(2024, 5, 7), 35.0, "Efectivo", Arrays.asList(productoVendido1, productoVendido2), vendedor1, cajero1, cliente, sucursal1);
        Venta venta10 = new Venta("0001-00000132", LocalDate.of(2024, 5, 7), 23.0, "Tarjeta", Arrays.asList(productoVendido3, productoVendido4), vendedor1, cajero1, cliente, sucursal1);
        Venta venta11 = new Venta("0001-00000128", LocalDate.now(), 20.0, "Tarjeta", Arrays.asList(productoVendido1), vendedor1, cajero1, cliente, sucursal2);
        Venta venta12 = new Venta("0001-00000129", LocalDate.of(2024, 5, 7), 60.0, "Efectivo", Arrays.asList(productoVendido2, productoVendido3), vendedor1, cajero1, cliente, sucursal2);
        Venta venta13 = new Venta("0001-00000130", LocalDate.now(), 18.0, "Tarjeta", Arrays.asList(productoVendido4, productoVendido1), vendedor1, cajero1, cliente, sucursal2);
        Venta venta14 = new Venta("0001-00000131", LocalDate.now(), 35.0, "Efectivo", Arrays.asList(productoVendido1, productoVendido2), vendedor1, cajero1, cliente, sucursal2);
        Venta venta15 = new Venta("0001-00000132", LocalDate.of(2024, 5, 7), 23.0, "Tarjeta", Arrays.asList(productoVendido3, productoVendido4), vendedor1, cajero1, cliente, sucursal2);

        // Insertar documentos en MongoDB
        MongoCollection<Document> clientesCollection = database.getCollection("clientes");
        clientesCollection.insertOne(new Document()
                .append("apellido", cliente.getApellido())
                .append("nombre", cliente.getNombre())
                .append("dni", cliente.getDni())
                .append("domicilio", new Document()
                        .append("calle", cliente.getDomicilio().getCalle())
                        .append("numero", cliente.getDomicilio().getNumero())
                        .append("localidad", cliente.getDomicilio().getLocalidad())
                        .append("provincia", cliente.getDomicilio().getProvincia()))
                .append("obraSocial", new Document()
                        .append("nombre", cliente.getObraSocial().getNombre()))
                .append("numeroAfiliado", cliente.getNumeroAfiliado()));

        clientesCollection.insertOne(new Document()
                .append("apellido", cliente2.getApellido())
                .append("nombre", cliente2.getNombre())
                .append("dni", cliente2.getDni())
                .append("domicilio", new Document()
                        .append("calle", cliente2.getDomicilio().getCalle())
                        .append("numero", cliente2.getDomicilio().getNumero())
                        .append("localidad", cliente2.getDomicilio().getLocalidad())
                        .append("provincia", cliente2.getDomicilio().getProvincia()))
                .append("obraSocial", new Document()
                        .append("nombre", cliente2.getObraSocial().getNombre()))
                .append("numeroAfiliado", cliente2.getNumeroAfiliado()));

        clientesCollection.insertOne(new Document()
                .append("apellido", cliente3.getApellido())
                .append("nombre", cliente3.getNombre())
                .append("dni", cliente3.getDni())
                .append("domicilio", new Document()
                        .append("calle", cliente3.getDomicilio().getCalle())
                        .append("numero", cliente3.getDomicilio().getNumero())
                        .append("localidad", cliente3.getDomicilio().getLocalidad())
                        .append("provincia", cliente3.getDomicilio().getProvincia()))
                .append("obraSocial", new Document()
                        .append("nombre", cliente3.getObraSocial().getNombre()))
                .append("numeroAfiliado", cliente3.getNumeroAfiliado()));

        MongoCollection<Document> empleadosCollection = database.getCollection("empleados");
        empleadosCollection.insertOne(new Document()
                .append("apellido", vendedor1.getApellido())
                .append("nombre", vendedor1.getNombre())
                .append("dni", vendedor1.getDni())
                .append("cuil", vendedor1.getCuil())
                .append("domicilio", new Document()
                        .append("calle", vendedor1.getDomicilio().getCalle())
                        .append("numero", vendedor1.getDomicilio().getNumero())
                        .append("localidad", vendedor1.getDomicilio().getLocalidad())
                        .append("provincia", vendedor1.getDomicilio().getProvincia()))
                .append("obraSocial", new Document()
                        .append("nombre", vendedor1.getObraSocial().getNombre()))
                .append("numeroAfiliado", vendedor1.getNumeroAfiliado()));

        empleadosCollection.insertOne(new Document()
                .append("apellido", cajero1.getApellido())
                .append("nombre", cajero1.getNombre())
                .append("dni", cajero1.getDni())
                .append("cuil", cajero1.getCuil())
                .append("domicilio", new Document()
                        .append("calle", cajero1.getDomicilio().getCalle())
                        .append("numero", cajero1.getDomicilio().getNumero())
                        .append("localidad", cajero1.getDomicilio().getLocalidad())
                        .append("provincia", cajero1.getDomicilio().getProvincia()))
                .append("obraSocial", new Document()
                        .append("nombre", cajero1.getObraSocial().getNombre()))
                .append("numeroAfiliado", cajero1.getNumeroAfiliado()));

        empleadosCollection.insertOne(new Document()
                .append("apellido", vendedor2.getApellido())
                .append("nombre", vendedor2.getNombre())
                .append("dni", vendedor2.getDni())
                .append("cuil", vendedor2.getCuil())
                .append("domicilio", new Document()
                        .append("calle", vendedor2.getDomicilio().getCalle())
                        .append("numero", vendedor2.getDomicilio().getNumero())
                        .append("localidad", vendedor2.getDomicilio().getLocalidad())
                        .append("provincia", vendedor2.getDomicilio().getProvincia()))
                .append("obraSocial", new Document()
                        .append("nombre", vendedor2.getObraSocial().getNombre()))
                .append("numeroAfiliado", vendedor2.getNumeroAfiliado()));

        empleadosCollection.insertOne(new Document()
                .append("apellido", cajero2.getApellido())
                .append("nombre", cajero2.getNombre())
                .append("dni", cajero2.getDni())
                .append("cuil", cajero2.getCuil())
                .append("domicilio", new Document()
                        .append("calle", cajero2.getDomicilio().getCalle())
                        .append("numero", cajero2.getDomicilio().getNumero())
                        .append("localidad", cajero2.getDomicilio().getLocalidad())
                        .append("provincia", cajero2.getDomicilio().getProvincia()))
                .append("obraSocial", new Document()
                        .append("nombre", cajero2.getObraSocial().getNombre()))
                .append("numeroAfiliado", cajero2.getNumeroAfiliado()));

        empleadosCollection.insertOne(new Document()
                .append("apellido", vendedor3.getApellido())
                .append("nombre", vendedor3.getNombre())
                .append("dni", vendedor3.getDni())
                .append("cuil", vendedor3.getCuil())
                .append("domicilio", new Document()
                        .append("calle", vendedor3.getDomicilio().getCalle())
                        .append("numero", vendedor3.getDomicilio().getNumero())
                        .append("localidad", vendedor3.getDomicilio().getLocalidad())
                        .append("provincia", vendedor3.getDomicilio().getProvincia()))
                .append("obraSocial", new Document()
                        .append("nombre", vendedor3.getObraSocial().getNombre()))
                .append("numeroAfiliado", vendedor3.getNumeroAfiliado()));

        empleadosCollection.insertOne(new Document()
                .append("apellido", cajero3.getApellido())
                .append("nombre", cajero3.getNombre())
                .append("dni", cajero3.getDni())
                .append("cuil", cajero3.getCuil())
                .append("domicilio", new Document()
                        .append("calle", cajero3.getDomicilio().getCalle())
                        .append("numero", cajero3.getDomicilio().getNumero())
                        .append("localidad", cajero3.getDomicilio().getLocalidad())
                        .append("provincia", cajero3.getDomicilio().getProvincia()))
                .append("obraSocial", new Document()
                        .append("nombre", cajero3.getObraSocial().getNombre()))
                .append("numeroAfiliado", cajero3.getNumeroAfiliado()));

        MongoCollection<Document> productosCollection = database.getCollection("productos");
        productosCollection.insertOne(new Document()
                .append("descripcion", producto1.getDescripcion())
                .append("tipo", producto1.getTipo())
                .append("laboratorio", producto1.getLaboratorio())
                .append("precio", producto1.getPrecio()));

        productosCollection.insertOne(new Document()
                .append("descripcion", producto2.getDescripcion())
                .append("tipo", producto2.getTipo())
                .append("laboratorio", producto2.getLaboratorio())
                .append("precio", producto2.getPrecio()));

        productosCollection.insertOne(new Document()
                .append("descripcion", producto3.getDescripcion())
                .append("tipo", producto3.getTipo())
                .append("laboratorio", producto3.getLaboratorio())
                .append("precio", producto3.getPrecio()));

        productosCollection.insertOne(new Document()
                .append("descripcion", producto4.getDescripcion())
                .append("tipo", producto4.getTipo())
                .append("laboratorio", producto4.getLaboratorio())
                .append("precio", producto4.getPrecio()));

        MongoCollection<Document> ventasCollection = database.getCollection("ventas");

        for (Venta venta : Arrays.asList(venta1, venta2, venta3, venta4, venta5, venta6, venta7, venta8, venta9, venta10, venta11, venta12, venta13, venta14, venta15)) {
            ventasCollection.insertOne(new Document()
                    .append("numeroTicket", venta.getNumeroTicket())
                    .append("fecha", venta.getFecha())
                    .append("total", venta.getTotal())
                    .append("formaPago", venta.getFormaPago())
                    .append("productos", Arrays.asList(
                            new Document()
                                    .append("producto", new Document()
                                            .append("descripcion", producto1.getDescripcion())
                                            .append("tipo", producto1.getTipo())
                                            .append("laboratorio", producto1.getLaboratorio())
                                            .append("precio", producto1.getPrecio()))
                                    .append("cantidad", productoVendido1.getCantidad())
                                    .append("precioUnitario", productoVendido1.getPrecioUnitario())
                                    .append("total", productoVendido1.getTotal()),
                            new Document()
                                    .append("producto", new Document()
                                            .append("descripcion", producto2.getDescripcion())
                                            .append("tipo", producto2.getTipo())
                                            .append("laboratorio", producto2.getLaboratorio())
                                            .append("precio", producto2.getPrecio()))
                                    .append("cantidad", productoVendido2.getCantidad())
                                    .append("precioUnitario", productoVendido2.getPrecioUnitario())
                                    .append("total", productoVendido2.getTotal())))
                    .append("empleadoAtendio", new Document()
                            .append("apellido", vendedor1.getApellido())
                            .append("nombre", vendedor1.getNombre())
                            .append("dni", vendedor1.getDni())
                            .append("cuil", vendedor1.getCuil())
                            .append("domicilio", new Document()
                                    .append("calle", vendedor1.getDomicilio().getCalle())
                                    .append("numero", vendedor1.getDomicilio().getNumero())
                                    .append("localidad", vendedor1.getDomicilio().getLocalidad())
                                    .append("provincia", vendedor1.getDomicilio().getProvincia()))
                            .append("obraSocial", new Document()
                                    .append("nombre", vendedor1.getObraSocial().getNombre()))
                            .append("numeroAfiliado", vendedor1.getNumeroAfiliado()))
                    .append("empleadoCobro", new Document()
                            .append("apellido", cajero1.getApellido())
                            .append("nombre", cajero1.getNombre())
                            .append("dni", cajero1.getDni())
                            .append("cuil", cajero1.getCuil())
                            .append("domicilio", new Document()
                                    .append("calle", cajero1.getDomicilio().getCalle())
                                    .append("numero", cajero1.getDomicilio().getNumero())
                                    .append("localidad", cajero1.getDomicilio().getLocalidad())
                                    .append("provincia", cajero1.getDomicilio().getProvincia()))
                            .append("obraSocial", new Document()
                                    .append("nombre", cajero1.getObraSocial().getNombre()))
                            .append("numeroAfiliado", cajero1.getNumeroAfiliado()))
                    .append("cliente", new Document()
                            .append("apellido", venta1.getCliente().getApellido())
                            .append("nombre", venta1.getCliente().getNombre())
                            .append("dni", venta1.getCliente().getDni())
                            .append("domicilio", new Document()
                                    .append("calle", venta1.getCliente().getDomicilio().getCalle())
                                    .append("numero", venta1.getCliente().getDomicilio().getNumero())
                                    .append("localidad", venta1.getCliente().getDomicilio().getLocalidad())
                                    .append("provincia", venta1.getCliente().getDomicilio().getProvincia()))
                            .append("obraSocial", new Document()
                                    .append("nombre", venta1.getCliente().getObraSocial().getNombre()))
                            .append("numeroAfiliado", venta1.getCliente().getNumeroAfiliado()))
                            .append("sucursal", new Document()
                                            .append("nombreSucursal", venta.getSucursal().getNombreSucursal())));
        }

        for (Venta venta : Arrays.asList(venta1, venta2, venta3, venta4, venta5, venta6, venta7, venta8, venta9, venta10, venta11, venta12, venta13, venta14, venta15)) {
            ventasCollection.insertOne(new Document()
                    .append("numeroTicket", venta.getNumeroTicket())
                    .append("fecha", venta.getFecha())
                    .append("total", venta.getTotal())
                    .append("formaPago", venta.getFormaPago())
                    .append("productos", Arrays.asList(
                            new Document()
                                    .append("producto", new Document()
                                            .append("descripcion", producto1.getDescripcion())
                                            .append("tipo", producto1.getTipo())
                                            .append("laboratorio", producto1.getLaboratorio())
                                            .append("precio", producto1.getPrecio()))
                                    .append("cantidad", productoVendido1.getCantidad())
                                    .append("precioUnitario", productoVendido1.getPrecioUnitario())
                                    .append("total", productoVendido1.getTotal()),
                            new Document()
                                    .append("producto", new Document()
                                            .append("descripcion", producto2.getDescripcion())
                                            .append("tipo", producto2.getTipo())
                                            .append("laboratorio", producto2.getLaboratorio())
                                            .append("precio", producto2.getPrecio()))
                                    .append("cantidad", productoVendido2.getCantidad())
                                    .append("precioUnitario", productoVendido2.getPrecioUnitario())
                                    .append("total", productoVendido2.getTotal())))
                    .append("empleadoAtendio", new Document()
                            .append("apellido", vendedor2.getApellido())
                            .append("nombre", vendedor2.getNombre())
                            .append("dni", vendedor2.getDni())
                            .append("cuil", vendedor2.getCuil())
                            .append("domicilio", new Document()
                                    .append("calle", vendedor2.getDomicilio().getCalle())
                                    .append("numero", vendedor2.getDomicilio().getNumero())
                                    .append("localidad", vendedor2.getDomicilio().getLocalidad())
                                    .append("provincia", vendedor2.getDomicilio().getProvincia()))
                            .append("obraSocial", new Document()
                                    .append("nombre", vendedor2.getObraSocial().getNombre()))
                            .append("numeroAfiliado", vendedor2.getNumeroAfiliado()))
                    .append("empleadoCobro", new Document()
                            .append("apellido", cajero2.getApellido())
                            .append("nombre", cajero2.getNombre())
                            .append("dni", cajero2.getDni())
                            .append("cuil", cajero2.getCuil())
                            .append("domicilio", new Document()
                                    .append("calle", cajero2.getDomicilio().getCalle())
                                    .append("numero", cajero2.getDomicilio().getNumero())
                                    .append("localidad", cajero2.getDomicilio().getLocalidad())
                                    .append("provincia", cajero2.getDomicilio().getProvincia()))
                            .append("obraSocial", new Document()
                                    .append("nombre", cajero2.getObraSocial().getNombre()))
                            .append("numeroAfiliado", cajero2.getNumeroAfiliado()))
                    .append("cliente", new Document()
                            .append("apellido", venta3.getCliente().getApellido())
                            .append("nombre", venta3.getCliente().getNombre())
                            .append("dni", venta3.getCliente().getDni())
                            .append("domicilio", new Document()
                                    .append("calle", venta3.getCliente().getDomicilio().getCalle())
                                    .append("numero", venta3.getCliente().getDomicilio().getNumero())
                                    .append("localidad", venta3.getCliente().getDomicilio().getLocalidad())
                                    .append("provincia", venta3.getCliente().getDomicilio().getProvincia()))
                            .append("obraSocial", new Document()
                                    .append("nombre", venta3.getCliente().getObraSocial().getNombre()))
                            .append("numeroAfiliado", venta3.getCliente().getNumeroAfiliado()))
                    .append("sucursal", new Document()
                            .append("nombreSucursal", sucursal2.getNombreSucursal())));
        }

        for (Venta venta : Arrays.asList(venta1, venta2, venta3, venta4, venta5, venta6, venta7, venta8, venta9, venta10, venta11, venta12, venta13, venta14, venta15)) {
            ventasCollection.insertOne(new Document()
                    .append("numeroTicket", venta.getNumeroTicket())
                    .append("fecha", venta.getFecha())
                    .append("total", venta.getTotal())
                    .append("formaPago", venta.getFormaPago())
                    .append("productos", Arrays.asList(
                            new Document()
                                    .append("producto", new Document()
                                            .append("descripcion", producto1.getDescripcion())
                                            .append("tipo", producto1.getTipo())
                                            .append("laboratorio", producto1.getLaboratorio())
                                            .append("precio", producto1.getPrecio()))
                                    .append("cantidad", productoVendido1.getCantidad())
                                    .append("precioUnitario", productoVendido1.getPrecioUnitario())
                                    .append("total", productoVendido1.getTotal()),
                            new Document()
                                    .append("producto", new Document()
                                            .append("descripcion", producto2.getDescripcion())
                                            .append("tipo", producto2.getTipo())
                                            .append("laboratorio", producto2.getLaboratorio())
                                            .append("precio", producto2.getPrecio()))
                                    .append("cantidad", productoVendido2.getCantidad())
                                    .append("precioUnitario", productoVendido2.getPrecioUnitario())
                                    .append("total", productoVendido2.getTotal())))
                    .append("empleadoAtendio", new Document()
                            .append("apellido", vendedor3.getApellido())
                            .append("nombre", vendedor3.getNombre())
                            .append("dni", vendedor3.getDni())
                            .append("cuil", vendedor3.getCuil())
                            .append("domicilio", new Document()
                                    .append("calle", vendedor3.getDomicilio().getCalle())
                                    .append("numero", vendedor3.getDomicilio().getNumero())
                                    .append("localidad", vendedor3.getDomicilio().getLocalidad())
                                    .append("provincia", vendedor3.getDomicilio().getProvincia()))
                            .append("obraSocial", new Document()
                                    .append("nombre", vendedor3.getObraSocial().getNombre()))
                            .append("numeroAfiliado", vendedor3.getNumeroAfiliado()))
                    .append("empleadoCobro", new Document()
                            .append("apellido", cajero3.getApellido())
                            .append("nombre", cajero3.getNombre())
                            .append("dni", cajero3.getDni())
                            .append("cuil", cajero3.getCuil())
                            .append("domicilio", new Document()
                                    .append("calle", cajero3.getDomicilio().getCalle())
                                    .append("numero", cajero3.getDomicilio().getNumero())
                                    .append("localidad", cajero3.getDomicilio().getLocalidad())
                                    .append("provincia", cajero3.getDomicilio().getProvincia()))
                            .append("obraSocial", new Document()
                                    .append("nombre", cajero3.getObraSocial().getNombre()))
                            .append("numeroAfiliado", cajero3.getNumeroAfiliado()))
                    .append("cliente", new Document()
                            .append("apellido", venta3.getCliente().getApellido())
                            .append("nombre", venta3.getCliente().getNombre())
                            .append("dni", venta3.getCliente().getDni())
                            .append("domicilio", new Document()
                                    .append("calle", venta3.getCliente().getDomicilio().getCalle())
                                    .append("numero", venta3.getCliente().getDomicilio().getNumero())
                                    .append("localidad", venta3.getCliente().getDomicilio().getLocalidad())
                                    .append("provincia", venta3.getCliente().getDomicilio().getProvincia()))
                            .append("obraSocial", new Document()
                                    .append("nombre", venta3.getCliente().getObraSocial().getNombre()))
                            .append("numeroAfiliado", venta3.getCliente().getNumeroAfiliado()))
                    .append("sucursal", new Document()
                            .append("nombreSucursal", sucursal3.getNombreSucursal())));
        }

        MongoCollection<Document> sucursalesCollection = database.getCollection("sucursales");
        sucursalesCollection.insertOne(new Document()
                .append("nombreSucursal", sucursal1.getNombreSucursal())
                .append("domicilio", new Document()
                        .append("calle", sucursal1.getDomicilio().getCalle())
                        .append("numero", sucursal1.getDomicilio().getNumero())
                        .append("localidad", sucursal1.getDomicilio().getLocalidad())
                        .append("provincia", sucursal1.getDomicilio().getProvincia()))
                .append("empleados", Arrays.asList(
                        new Document()
                                .append("apellido", cajero1.getApellido())
                                .append("nombre", cajero1.getNombre())
                                .append("dni", cajero1.getDni())
                                .append("cuil", cajero1.getCuil())
                                .append("domicilio", new Document()
                                        .append("calle", cajero1.getDomicilio().getCalle())
                                        .append("numero", cajero1.getDomicilio().getNumero())
                                        .append("localidad", cajero1.getDomicilio().getLocalidad())
                                        .append("provincia", cajero1.getDomicilio().getProvincia()))
                                .append("obraSocial", new Document()
                                        .append("nombre", cajero1.getObraSocial().getNombre()))
                                .append("numeroAfiliado", cajero1.getNumeroAfiliado()),
                        new Document() // Nuevo documento para el vendedor
                                .append("apellido", vendedor1.getApellido())
                                .append("nombre", vendedor1.getNombre())
                                .append("dni", vendedor1.getDni())
                                .append("cuil", vendedor1.getCuil())
                                .append("domicilio", new Document()
                                        .append("calle", vendedor1.getDomicilio().getCalle())
                                        .append("numero", vendedor1.getDomicilio().getNumero())
                                        .append("localidad", vendedor1.getDomicilio().getLocalidad())
                                        .append("provincia", vendedor1.getDomicilio().getProvincia()))
                                .append("obraSocial", new Document()
                                        .append("nombre", vendedor1.getObraSocial().getNombre()))
                                .append("numeroAfiliado", vendedor1.getNumeroAfiliado())))
                .append("encargado", new Document()
                        .append("apellido", cajero1.getApellido())
                        .append("nombre", cajero1.getNombre())
                        .append("dni", cajero1.getDni())
                        .append("cuil", cajero1.getCuil())
                        .append("domicilio", new Document()
                                .append("calle", cajero1.getDomicilio().getCalle())
                                .append("numero", cajero1.getDomicilio().getNumero())
                                .append("localidad", cajero1.getDomicilio().getLocalidad())
                                .append("provincia", cajero1.getDomicilio().getProvincia()))
                        .append("obraSocial", new Document()
                                .append("nombre", cajero1.getObraSocial().getNombre()))
                        .append("numeroAfiliado", cajero1.getNumeroAfiliado())));

        sucursalesCollection.insertOne(new Document()
                .append("nombreSucursal", sucursal2.getNombreSucursal())
                .append("domicilio", new Document()
                        .append("calle", sucursal2.getDomicilio().getCalle())
                        .append("numero", sucursal2.getDomicilio().getNumero())
                        .append("localidad", sucursal2.getDomicilio().getLocalidad())
                        .append("provincia", sucursal2.getDomicilio().getProvincia()))
                .append("empleados", Arrays.asList(
                        new Document()
                                .append("apellido", cajero2.getApellido())
                                .append("nombre", cajero2.getNombre())
                                .append("dni", cajero2.getDni())
                                .append("cuil", cajero2.getCuil())
                                .append("domicilio", new Document()
                                        .append("calle", cajero2.getDomicilio().getCalle())
                                        .append("numero", cajero2.getDomicilio().getNumero())
                                        .append("localidad", cajero2.getDomicilio().getLocalidad())
                                        .append("provincia", cajero2.getDomicilio().getProvincia()))
                                .append("obraSocial", new Document()
                                        .append("nombre", cajero2.getObraSocial().getNombre()))
                                .append("numeroAfiliado", cajero2.getNumeroAfiliado()),
                        new Document() // Nuevo documento para el vendedor
                                .append("apellido", vendedor2.getApellido())
                                .append("nombre", vendedor2.getNombre())
                                .append("dni", vendedor2.getDni())
                                .append("cuil", vendedor2.getCuil())
                                .append("domicilio", new Document()
                                        .append("calle", vendedor2.getDomicilio().getCalle())
                                        .append("numero", vendedor2.getDomicilio().getNumero())
                                        .append("localidad", vendedor2.getDomicilio().getLocalidad())
                                        .append("provincia", vendedor2.getDomicilio().getProvincia()))
                                .append("obraSocial", new Document()
                                        .append("nombre", vendedor2.getObraSocial().getNombre()))
                                .append("numeroAfiliado", vendedor2.getNumeroAfiliado())))
                .append("encargado", new Document()
                        .append("apellido", vendedor2.getApellido())
                        .append("nombre", vendedor2.getNombre())
                        .append("dni", vendedor2.getDni())
                        .append("cuil", vendedor2.getCuil())
                        .append("domicilio", new Document()
                                .append("calle", vendedor2.getDomicilio().getCalle())
                                .append("numero", vendedor2.getDomicilio().getNumero())
                                .append("localidad", vendedor2.getDomicilio().getLocalidad())
                                .append("provincia", vendedor2.getDomicilio().getProvincia()))
                        .append("obraSocial", new Document()
                                .append("nombre", vendedor2.getObraSocial().getNombre()))
                        .append("numeroAfiliado", vendedor2.getNumeroAfiliado())));

        sucursalesCollection.insertOne(new Document()
                .append("nombreSucursal", sucursal3.getNombreSucursal())
                .append("domicilio", new Document()
                        .append("calle", sucursal3.getDomicilio().getCalle())
                        .append("numero", sucursal3.getDomicilio().getNumero())
                        .append("localidad", sucursal3.getDomicilio().getLocalidad())
                        .append("provincia", sucursal3.getDomicilio().getProvincia()))
                .append("empleados", Arrays.asList(
                        new Document()
                                .append("apellido", cajero3.getApellido())
                                .append("nombre", cajero3.getNombre())
                                .append("dni", cajero3.getDni())
                                .append("cuil", cajero3.getCuil())
                                .append("domicilio", new Document()
                                        .append("calle", cajero3.getDomicilio().getCalle())
                                        .append("numero", cajero3.getDomicilio().getNumero())
                                        .append("localidad", cajero3.getDomicilio().getLocalidad())
                                        .append("provincia", cajero3.getDomicilio().getProvincia()))
                                .append("obraSocial", new Document()
                                        .append("nombre", cajero3.getObraSocial().getNombre()))
                                .append("numeroAfiliado", cajero3.getNumeroAfiliado()),
                        new Document() // Nuevo documento para el vendedor
                                .append("apellido", vendedor3.getApellido())
                                .append("nombre", vendedor3.getNombre())
                                .append("dni", vendedor3.getDni())
                                .append("cuil", vendedor3.getCuil())
                                .append("domicilio", new Document()
                                        .append("calle", vendedor3.getDomicilio().getCalle())
                                        .append("numero", vendedor3.getDomicilio().getNumero())
                                        .append("localidad", vendedor3.getDomicilio().getLocalidad())
                                        .append("provincia", vendedor3.getDomicilio().getProvincia()))
                                .append("obraSocial", new Document()
                                        .append("nombre", vendedor3.getObraSocial().getNombre()))
                                .append("numeroAfiliado", vendedor3.getNumeroAfiliado())))
                .append("encargado", new Document()
                        .append("apellido", vendedor3.getApellido())
                        .append("nombre", vendedor3.getNombre())
                        .append("dni", vendedor3.getDni())
                        .append("cuil", vendedor3.getCuil())
                        .append("domicilio", new Document()
                                .append("calle", vendedor3.getDomicilio().getCalle())
                                .append("numero", vendedor3.getDomicilio().getNumero())
                                .append("localidad", vendedor3.getDomicilio().getLocalidad())
                                .append("provincia", vendedor3.getDomicilio().getProvincia()))
                        .append("obraSocial", new Document()
                                .append("nombre", vendedor3.getObraSocial().getNombre()))
                        .append("numeroAfiliado", vendedor3.getNumeroAfiliado())));

        MongoDBConnection.closeConnection();
    }
}
