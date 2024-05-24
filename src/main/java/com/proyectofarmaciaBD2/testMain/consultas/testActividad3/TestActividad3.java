package com.proyectofarmaciaBD2.testMain.consultas.testActividad3;

import com.mongodb.client.AggregateIterable;
import org.bson.Document;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestActividad3 {

    public static void main(String[] args) {
        ConsultasAvanzadas consultas = new ConsultasAvanzadas();
        LocalDate fechaInicio = LocalDate.parse("2024-01-01", DateTimeFormatter.ISO_DATE);
        LocalDate fechaFin = LocalDate.parse("2024-12-31", DateTimeFormatter.ISO_DATE);

        // Ejemplo de uso de los métodos
        System.out.println("Detalle y totales de ventas entre fechas:");
        AggregateIterable<Document> resultado1 = consultas.detalleYTotalesDeVentasEntreFechas(fechaInicio, fechaFin, null);
        for (Document doc : resultado1) {
            System.out.println(doc.toJson());
        }

        System.out.println("Detalle y totales de ventas por obra social entre fechas:");
        AggregateIterable<Document> resultado2 = consultas.detalleYTotalesDeVentasPorObraSocialEntreFechas(fechaInicio, fechaFin, "OSDE", null);
        for (Document doc : resultado2) {
            System.out.println(doc.toJson());
        }

        System.out.println("Detalle y totales de cobranza por medio de pago entre fechas:");
        AggregateIterable<Document> resultado3 = consultas.detalleYTotalesDeCobranzaPorMedioPagoEntreFechas(fechaInicio, fechaFin, "Tarjeta de Crédito", null);
        for (Document doc : resultado3) {
            System.out.println(doc.toJson());
        }

        System.out.println("Detalle y totales de ventas de productos entre fechas:");
        AggregateIterable<Document> resultado4 = consultas.detalleYTotalesDeVentasDeProductosEntreFechas(fechaInicio, fechaFin, "Farmacia", null);
        for (Document doc : resultado4) {
            System.out.println(doc.toJson());
        }

        System.out.println("Ranking de ventas de productos por monto entre fechas:");
        AggregateIterable<Document> resultado5 = consultas.rankingDeVentasDeProductosPorMontoEntreFechas(fechaInicio, fechaFin, null);
        for (Document doc : resultado5) {
            System.out.println(doc.toJson());
        }

        System.out.println("Ranking de ventas de productos por cantidad vendida entre fechas:");
        AggregateIterable<Document> resultado6 = consultas.rankingDeVentasDeProductosPorCantidadVendidaEntreFechas(fechaInicio, fechaFin, null);
        for (Document doc : resultado6) {
            System.out.println(doc.toJson());
        }

        System.out.println("Ranking de clientes por compras por monto entre fechas:");
        AggregateIterable<Document> resultado7 = consultas.rankingDeClientesPorComprasPorMontoEntreFechas(fechaInicio, fechaFin, null);
        for (Document doc : resultado7) {
            System.out.println(doc.toJson());
        }

        System.out.println("Ranking de clientes por compras por cantidad vendida entre fechas:");
        AggregateIterable<Document> resultado8 = consultas.rankingDeClientesPorComprasPorCantidadVendidaEntreFechas(fechaInicio, fechaFin, null);
        for (Document doc : resultado8) {
            System.out.println(doc.toJson());
        }

        // Cerrar la conexión
        consultas.cerrarConexion();
    }
}
