package com.proyectofarmaciaBD2.testMain.consultas.testActividad3;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.proyectofarmaciaBD2.dao.MongoDBConnection;
import org.bson.Document;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ConsultasAvanzadas {

    private MongoDatabase database;

    public ConsultasAvanzadas() {
        this.database = MongoDBConnection.connectToDatabase("farmaciaDB");
    }

    // 1. Detalle y totales de ventas para la cadena completa y por sucursal, entre fechas
    public AggregateIterable<Document> detalleYTotalesDeVentasEntreFechas(LocalDate fechaInicio, LocalDate fechaFin, String sucursalId) {
        MongoCollection<Document> ventasCollection = database.getCollection("ventas");
        Document match = new Document("$match", new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin))
                .append("sucursalId", sucursalId == null ? new Document("$exists", true) : sucursalId));
        Document group = new Document("$group", new Document("_id", "$sucursalId")
                .append("totalVentas", new Document("$sum", "$total"))
                .append("detalleVentas", new Document("$push", "$$ROOT")));
        List<Document> pipeline = Arrays.asList(match, group);
        return ventasCollection.aggregate(pipeline);
    }

    // 2. Detalle y totales de ventas por obra social o privados, entre fechas
    public AggregateIterable<Document> detalleYTotalesDeVentasPorObraSocialEntreFechas(LocalDate fechaInicio, LocalDate fechaFin, String obraSocial, String sucursalId) {
        MongoCollection<Document> ventasCollection = database.getCollection("ventas");
        Document match = new Document("$match", new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin))
                .append("obraSocial", obraSocial == null ? new Document("$exists", true) : obraSocial)
                .append("sucursalId", sucursalId == null ? new Document("$exists", true) : sucursalId));
        Document group = new Document("$group", new Document("_id", "$sucursalId")
                .append("totalVentas", new Document("$sum", "$total"))
                .append("detalleVentas", new Document("$push", "$$ROOT")));
        List<Document> pipeline = Arrays.asList(match, group);
        return ventasCollection.aggregate(pipeline);
    }

    // 3. Detalle y totales de cobranza por medio de pago, entre fechas
    public AggregateIterable<Document> detalleYTotalesDeCobranzaPorMedioPagoEntreFechas(LocalDate fechaInicio, LocalDate fechaFin, String formaPago, String sucursalId) {
        MongoCollection<Document> ventasCollection = database.getCollection("ventas");
        Document match = new Document("$match", new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin))
                .append("formaPago", formaPago == null ? new Document("$exists", true) : formaPago)
                .append("sucursalId", sucursalId == null ? new Document("$exists", true) : sucursalId));
        Document group = new Document("$group", new Document("_id", "$sucursalId")
                .append("totalCobranza", new Document("$sum", "$total"))
                .append("detalleCobranza", new Document("$push", "$$ROOT")));
        List<Document> pipeline = Arrays.asList(match, group);
        return ventasCollection.aggregate(pipeline);
    }

    // 4. Detalle y totales de ventas de productos por tipo, entre fechas
    public AggregateIterable<Document> detalleYTotalesDeVentasDeProductosEntreFechas(LocalDate fechaInicio, LocalDate fechaFin, String tipoProducto, String sucursalId) {
        MongoCollection<Document> ventasCollection = database.getCollection("ventas");
        Document match = new Document("$match", new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin))
                .append("productos.producto.tipo", tipoProducto)
                .append("sucursalId", sucursalId == null ? new Document("$exists", true) : sucursalId));
        Document unwind = new Document("$unwind", "$productos");
        Document group = new Document("$group", new Document("_id", "$sucursalId")
                .append("totalVentas", new Document("$sum", "$productos.total"))
                .append("detalleVentas", new Document("$push", "$$ROOT")));
        List<Document> pipeline = Arrays.asList(match, unwind, group);
        return ventasCollection.aggregate(pipeline);
    }

    // 5. Ranking de ventas de productos por monto, entre fechas
    public AggregateIterable<Document> rankingDeVentasDeProductosPorMontoEntreFechas(LocalDate fechaInicio, LocalDate fechaFin, String sucursalId) {
        MongoCollection<Document> ventasCollection = database.getCollection("ventas");
        Document match = new Document("$match", new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin))
                .append("sucursalId", sucursalId == null ? new Document("$exists", true) : sucursalId));
        Document unwind = new Document("$unwind", "$productos");
        Document group = new Document("$group", new Document("_id", "$productos.producto.descripcion")
                .append("totalVentas", new Document("$sum", "$productos.total")));
        Document sort = new Document("$sort", new Document("totalVentas", -1));
        List<Document> pipeline = Arrays.asList(match, unwind, group, sort);
        return ventasCollection.aggregate(pipeline);
    }

    // 6. Ranking de ventas de productos por cantidad vendida, entre fechas
    public AggregateIterable<Document> rankingDeVentasDeProductosPorCantidadVendidaEntreFechas(LocalDate fechaInicio, LocalDate fechaFin, String sucursalId) {
        MongoCollection<Document> ventasCollection = database.getCollection("ventas");
        Document match = new Document("$match", new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin))
                .append("sucursalId", sucursalId == null ? new Document("$exists", true) : sucursalId));
        Document unwind = new Document("$unwind", "$productos");
        Document group = new Document("$group", new Document("_id", "$productos.producto.descripcion")
                .append("cantidadVendida", new Document("$sum", "$productos.cantidad")));
        Document sort = new Document("$sort", new Document("cantidadVendida", -1));
        List<Document> pipeline = Arrays.asList(match, unwind, group, sort);
        return ventasCollection.aggregate(pipeline);
    }

    // 7. Ranking de clientes por compras por monto, entre fechas
    public AggregateIterable<Document> rankingDeClientesPorComprasPorMontoEntreFechas(LocalDate fechaInicio, LocalDate fechaFin, String sucursalId) {
        MongoCollection<Document> ventasCollection = database.getCollection("ventas");
        Document match = new Document("$match", new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin))
                .append("sucursalId", sucursalId == null ? new Document("$exists", true) : sucursalId));
        Document group = new Document("$group", new Document("_id", "$cliente.dni")
                .append("totalCompras", new Document("$sum", "$total")));
        Document sort = new Document("$sort", new Document("totalCompras", -1));
        List<Document> pipeline = Arrays.asList(match, group, sort);
        return ventasCollection.aggregate(pipeline);
    }

    // 8. Ranking de clientes por compras por cantidad vendida, entre fechas
    public AggregateIterable<Document> rankingDeClientesPorComprasPorCantidadVendidaEntreFechas(LocalDate fechaInicio, LocalDate fechaFin, String sucursalId) {
        MongoCollection<Document> ventasCollection = database.getCollection("ventas");
        Document match = new Document("$match", new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin))
                .append("sucursalId", sucursalId == null ? new Document("$exists", true) : sucursalId));
        Document unwind = new Document("$unwind", "$productos");
        Document group = new Document("$group", new Document("_id", "$cliente.dni")
                .append("cantidadComprada", new Document("$sum", "$productos.cantidad")));
        Document sort = new Document("$sort", new Document("cantidadComprada", -1));
        List<Document> pipeline = Arrays.asList(match, unwind, group, sort);
        return ventasCollection.aggregate(pipeline);
    }

    public void cerrarConexion() {
        MongoDBConnection.closeConnection();
    }
}
