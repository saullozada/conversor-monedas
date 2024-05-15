package com.slventura.exchange.servicio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.slventura.exchange.modelo.Datos;
import com.slventura.exchange.modelo.DatosApi;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conexion {

  public void clienteHttp(String monedaBase, String monedaTarget, double monedaMonto) {
    // Construir la URL de la API
    var URL_BASE = "https://v6.exchangerate-api.com/v6/d1b329305202d24f4260c84f/pair/";
    String urlExchange = URL_BASE + monedaBase + "/" + monedaTarget;

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(urlExchange))
        .build();
    try {
      HttpResponse<String> response = client
          .send(request, HttpResponse.BodyHandlers.ofString());

      // Complementar la respuesta JSON con el monto a convertir
      String json = response.body().replace("}", ",") + "currency_amount:" + monedaMonto + "}";

      // Uso de la biblioteca Gson para leer JSON
      Gson gson = new GsonBuilder()
          .setPrettyPrinting()
          .create();
      // Utilizar un DTO para la transformación a objetos
      DatosApi datosJSON = gson.fromJson(json, DatosApi.class);
      Datos datos = new Datos(datosJSON);

      // Escribir archivo JSON como ejercicio de practica
      FileWriter escritura = new FileWriter("datos.json");
      escritura.write(gson.toJson(datos));
      escritura.close();

      // Mostrar el resultado de la conversion de monedas.
      datos.mostrarConversion();

    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
