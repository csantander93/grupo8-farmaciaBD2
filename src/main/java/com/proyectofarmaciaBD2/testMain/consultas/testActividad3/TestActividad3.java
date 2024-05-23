package com.proyectofarmaciaBD2.testMain.consultas.testActividad3;

import com.proyectofarmaciaBD2.testMain.consultas.ConsultaService;
import org.bson.Document;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestActividad3 {

    public static void main(String[] args) {
        ConsultaService consultaService = new ConsultaService();

        try {
            // Formato de fecha
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaInicio = dateFormat.parse("2024-01-01");
            Date fechaFin = dateFormat.parse("2024-12-31");

            // Consultar ventas por fechas
            System.out.println("Detalle y totales de ventas entre fechas:");
            List<Document> ventasPorFechas = consultaService.getVentasPorFechas(fechaInicio, fechaFin, null);
            ventasPorFechas.forEach(System.out::println);

            // Consultar ventas por obra social
            System.out.println("\nDetalle y totales de ventas por obra social entre fechas:");
            List<Document> ventasPorObraSocial = consultaService.getVentasPorObraSocial(fechaInicio, fechaFin, "1", null);
            ventasPorObraSocial.forEach(System.out::println);

            // Consultar cobranzas por medio de pago
            System.out.println("\nDetalle y totales de cobranza por medio de pago entre fechas:");
            List<Document> cobranzasPorMedioPago = consultaService.getCobranzasPorMedioPago(fechaInicio, fechaFin, "Efectivo", null);
            cobranzasPorMedioPago.forEach(System.out::println);

            // Consultar ventas por tipo de producto (farmacia)
            System.out.println("\nDetalle y totales de ventas de productos de farmacia entre fechas:");
            List<Document> ventasPorTipoProductoFarmacia = consultaService.getVentasPorTipoProducto(fechaInicio, fechaFin, "Medicamento", null);
            ventasPorTipoProductoFarmacia.forEach(System.out::println);

            // Consultar ventas por tipo de producto (perfumería)
            System.out.println("\nDetalle y totales de ventas de productos de perfumería entre fechas:");
            List<Document> ventasPorTipoProductoPerfumeria = consultaService.getVentasPorTipoProducto(fechaInicio, fechaFin, "Perfumería", null);
            ventasPorTipoProductoPerfumeria.forEach(System.out::println);

            // Ranking de productos por monto
            System.out.println("\nRanking de ventas de productos por monto entre fechas:");
            List<Document> rankingProductosPorMonto = consultaService.getRankingProductosPorMonto(fechaInicio, fechaFin, null);
            rankingProductosPorMonto.forEach(System.out::println);

            // Ranking de productos por cantidad
            System.out.println("\nRanking de ventas de productos por cantidad entre fechas:");
            List<Document> rankingProductosPorCantidad = consultaService.getRankingProductosPorCantidad(fechaInicio, fechaFin, null);
            rankingProductosPorCantidad.forEach(System.out::println);

            // Ranking de clientes por monto
            System.out.println("\nRanking de clientes por compras por monto entre fechas:");
            List<Document> rankingClientesPorMonto = consultaService.getRankingClientesPorMonto(fechaInicio, fechaFin, null);
            rankingClientesPorMonto.forEach(System.out::println);

            // Ranking de clientes por cantidad
            System.out.println("\nRanking de clientes por compras por cantidad entre fechas:");
            List<Document> rankingClientesPorCantidad = consultaService.getRankingClientesPorCantidad(fechaInicio, fechaFin, null);
            rankingClientesPorCantidad.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

