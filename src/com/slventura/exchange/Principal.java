package com.slventura.exchange;

import com.slventura.exchange.modelo.Opciones;
import com.slventura.exchange.servicio.Conexion;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principal {
  public static void main(String[] args) throws FileNotFoundException {

    while (true) {
      // Llamar al metodo mostarMenu()
      Opciones opciones = new Opciones();
      opciones.mostrarMenu();

      // Capturar la opción de Usuario seleccionada
      Scanner teclado = new Scanner(System.in);
      System.out.println("Elegir la opción deseada:");

      try {
        var opcion = Integer.valueOf(teclado.nextLine());

        if (opcion == 7) {
          System.out.println("Gracias por utilizar la Aplicación");
          break;
        }

        // Convertir la opción de Usuario en las monedas correspondientes
        String monedaBase = Opciones.obtenerBase(opcion);
        String monedaTarget = Opciones.obtenerTarget(opcion);

        // Capturar el monto del Usuario a convertir
        System.out.println("\nIngrese la cantidad en " + monedaBase + " que desea convertir: ");
        double monedaMonto = teclado.nextDouble();
        teclado.nextLine();

        // Conexion con el cliente Exchange API
        Conexion conexion = new Conexion();
        conexion.clienteHttp(monedaBase, monedaTarget, monedaMonto);

      } catch (RuntimeException e) {
        System.out.println("Error en la opción: " + e.getMessage());
        System.out.println("¡Favor de elegir una opción valida!");
      }
    }


  }

}
