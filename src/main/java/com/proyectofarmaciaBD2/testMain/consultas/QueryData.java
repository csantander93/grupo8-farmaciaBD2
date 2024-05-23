package com.proyectofarmaciaBD2.testMain.consultas;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.proyectofarmaciaBD2.dao.MongoDBConnection;
import org.bson.Document;

public class QueryData {
    public static void main(String[] args) {
        MongoDatabase database = MongoDBConnection.connectToDatabase("farmaciaDB");

        MongoCollection<Document> clientesCollection = database.getCollection("clientes");
        FindIterable<Document> clientes = clientesCollection.find();
        for (Document cliente : clientes) {
            System.out.println(cliente.toJson());
        }

        MongoCollection<Document> empleadosCollection = database.getCollection("empleados");
        FindIterable<Document> empleados = empleadosCollection.find();
        for (Document empleado : empleados) {
            System.out.println(empleado.toJson());
        }

        MongoCollection<Document> productosCollection = database.getCollection("productos");
        FindIterable<Document> productos = productosCollection.find();
        for (Document producto : productos) {
            System.out.println(producto.toJson());
        }

        MongoCollection<Document> ventasCollection = database.getCollection("ventas");
        FindIterable<Document> ventas = ventasCollection.find();
        for (Document venta : ventas) {
            System.out.println(venta.toJson());
        }

        MongoCollection<Document> sucursalesCollection = database.getCollection("sucursales");
        FindIterable<Document> sucursales = sucursalesCollection.find();
        for (Document sucursal : sucursales) {
            System.out.println(sucursal.toJson());
        }

        MongoDBConnection.closeConnection();
    }
}

