package com.slventura.exchange.modelo;

import java.text.DecimalFormat;

public class Datos {
  String fechaActualiza;
  String divisaBase;
  String divisaTarget;
  double divisaTasa;
  double divisaCantidad;

  public Datos(DatosApi datosJSON) {
    this.fechaActualiza = datosJSON.time_last_update_utc();
    this.divisaBase = datosJSON.base_code();
    this.divisaTarget = datosJSON.target_code();
    this.divisaTasa = datosJSON.conversion_rate();
    this.divisaCantidad = datosJSON.currency_amount();
  }


  public void mostrarConversion() {
    DecimalFormat decimalFormat = new DecimalFormat("#.##");

    double conversion = divisaCantidad * divisaTasa;

    // Redondeo de variables
    String divisaCantidadRedondeo = decimalFormat.format(divisaCantidad);
    String totalConversionRedondeo = decimalFormat.format(conversion);

    System.out.println("----------------------------------------");
    System.out.println("\nResultado de la Conversion");
    System.out.println("La cantidad de: " + divisaCantidadRedondeo + " " + divisaBase);
    System.out.println("Corresponden a: " + totalConversionRedondeo + " " + divisaTarget);
    System.out.println("\n----------------------------------------");

  }


  @Override
  public String toString() {
    return ")" +
        "fechaActualiza='" + fechaActualiza +
        ", dividaBase='" + divisaBase +
        ", divisaTarget='" + divisaTarget +
        ", divisaTasa=" + divisaTasa +
        ", divisaCantidad=" + divisaCantidad +
        ")";
  }
}
