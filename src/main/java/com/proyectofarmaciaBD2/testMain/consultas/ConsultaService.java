package com.proyectofarmaciaBD2.testMain.consultas;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClients;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ConsultaService {

    private MongoDatabase database;

    public ConsultaService() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        this.database = mongoClient.getDatabase("farmaciaDB");
    }

    public List<Document> getVentasPorFechas(Date fechaInicio, Date fechaFin, String sucursalId) {
        MongoCollection<Document> ventasCollection = database.getCollection("ventas");

        Document match = new Document("$match", new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin)));
        if (sucursalId != null) {
            match.append("sucursal.id", sucursalId);
        }
        Document group = new Document("$group", new Document("_id", "$sucursal.id")
                .append("totalVentas", new Document("$sum", "$total"))
                .append("detalleVentas", new Document("$push", "$$ROOT")));

        return ventasCollection.aggregate(Arrays.asList(match, group)).into(new ArrayList<>());
    }

    public List<Document> getVentasPorObraSocial(Date fechaInicio, Date fechaFin, String obraSocialId, String sucursalId) {
        MongoCollection<Document> ventasCollection = database.getCollection("ventas");

        Document match = new Document("$match", new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin))
                .append("cliente.obraSocial.id", obraSocialId));
        if (sucursalId != null) {
            match.append("sucursal.id", sucursalId);
        }
        Document group = new Document("$group", new Document("_id", "$sucursal.id")
                .append("totalVentas", new Document("$sum", "$total"))
                .append("detalleVentas", new Document("$push", "$$ROOT")));

        return ventasCollection.aggregate(Arrays.asList(match, group)).into(new ArrayList<>());
    }

    public List<Document> getCobranzasPorMedioPago(Date fechaInicio, Date fechaFin, String medioPago, String sucursalId) {
        MongoCollection<Document> ventasCollection = database.getCollection("ventas");

        Document match = new Document("$match", new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin))
                .append("formaPago", medioPago));
        if (sucursalId != null) {
            match.append("sucursal.id", sucursalId);
        }
        Document group = new Document("$group", new Document("_id", "$sucursal.id")
                .append("totalCobranza", new Document("$sum", "$total"))
                .append("detalleCobranza", new Document("$push", "$$ROOT")));

        return ventasCollection.aggregate(Arrays.asList(match, group)).into(new ArrayList<>());
    }

    public List<Document> getVentasPorTipoProducto(Date fechaInicio, Date fechaFin, String tipoProducto, String sucursalId) {
        MongoCollection<Document> ventasCollection = database.getCollection("ventas");

        Document match = new Document("$match", new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin))
                .append("productos.producto.tipo", tipoProducto));
        if (sucursalId != null) {
            match.append("sucursal.id", sucursalId);
        }
        Document group = new Document("$group", new Document("_id", "$sucursal.id")
                .append("totalVentas", new Document("$sum", "$total"))
                .append("detalleVentas", new Document("$push", "$$ROOT")));

        return ventasCollection.aggregate(Arrays.asList(match, group)).into(new ArrayList<>());
    }

    public List<Document> getRankingProductosPorMonto(Date fechaInicio, Date fechaFin, String sucursalId) {
        MongoCollection<Document> ventasCollection = database.getCollection("ventas");

        Document match = new Document("$match", new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin)));
        if (sucursalId != null) {
            match.append("sucursal.id", sucursalId);
        }
        Document unwind = new Document("$unwind", "$productos");
        Document group = new Document("$group", new Document("_id", "$productos.producto.id")
                .append("descripcion", new Document("$first", "$productos.producto.descripcion"))
                .append("totalMonto", new Document("$sum", "$productos.total")));
        Document sort = new Document("$sort", new Document("totalMonto", -1));

        return ventasCollection.aggregate(Arrays.asList(match, unwind, group, sort)).into(new ArrayList<>());
    }

    public List<Document> getRankingProductosPorCantidad(Date fechaInicio, Date fechaFin, String sucursalId) {
        MongoCollection<Document> ventasCollection = database.getCollection("ventas");

        Document match = new Document("$match", new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin)));
        if (sucursalId != null) {
            match.append("sucursal.id", sucursalId);
        }
        Document unwind = new Document("$unwind", "$productos");
        Document group = new Document("$group", new Document("_id", "$productos.producto.id")
                .append("descripcion", new Document("$first", "$productos.producto.descripcion"))
                .append("totalCantidad", new Document("$sum", "$productos.cantidad")));
        Document sort = new Document("$sort", new Document("totalCantidad", -1));

        return ventasCollection.aggregate(Arrays.asList(match, unwind, group, sort)).into(new ArrayList<>());
    }

    public List<Document> getRankingClientesPorMonto(Date fechaInicio, Date fechaFin, String sucursalId) {
        MongoCollection<Document> ventasCollection = database.getCollection("ventas");

        Document match = new Document("$match", new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin)));
        if (sucursalId != null) {
            match.append("sucursal.id", sucursalId);
        }
        Document group = new Document("$group", new Document("_id", "$cliente.id")
                .append("nombre", new Document("$first", "$cliente.nombre"))
                .append("apellido", new Document("$first", "$cliente.apellido"))
                .append("totalMonto", new Document("$sum", "$total")));
        Document sort = new Document("$sort", new Document("totalMonto", -1));

        return ventasCollection.aggregate(Arrays.asList(match, group, sort)).into(new ArrayList<>());
    }

    public List<Document> getRankingClientesPorCantidad(Date fechaInicio, Date fechaFin, String sucursalId) {
        MongoCollection<Document> ventasCollection = database.getCollection("ventas");

        Document match = new Document("$match", new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin)));
        if (sucursalId != null) {
            match.append("sucursal.id", sucursalId);
        }
        Document unwind = new Document("$unwind", "$productos");
        Document group = new Document("$group", new Document("_id", "$cliente.id")
                .append("nombre", new Document("$first", "$cliente.nombre"))
                .append("apellido", new Document("$first", "$cliente.apellido"))
                .append("totalCantidad", new Document("$sum", "$productos.cantidad")));
        Document sort = new Document("$sort", new Document("totalCantidad", -1));

        return ventasCollection.aggregate(Arrays.asList(match, unwind, group, sort)).into(new ArrayList<>());
    }
}
