package com.slventura.exchange.modelo;

public class Opciones {
  public void mostrarMenu() {
    String menu = """
        \n----------------------------------------
        
             Bienvenido(a) a la Aplicación
                 Conversion de Monedas
        
        1. Dólar Americano -> Peso Mexicano
        2. Peso Mexicano   -> Dólar Americano
        3. Dólar Americano -> Real Brasileño
        4. Real Brasileño  -> Dólar Americano
        5. Dólar Americano -> Peso Argentino
        6. Peso Argentino  -> Dólar Americano
        7. Salir
        
        ----------------------------------------
        """;
    System.out.println(menu);
  }

  public static String obtenerBase(int opcion) {
    return switch (opcion) {
      case 1 -> "USD";
      case 2 -> "MXN";
      case 3 -> "USD";
      case 4 -> "BRL";
      case 5 -> "USD";
      case 6 -> "ARS";
      default -> throw new IllegalStateException("Unexpected value: " + opcion);
    };
  }

  public static String obtenerTarget(int opcion) {
    return switch (opcion) {
      case 1 -> "MXN";
      case 2 -> "USD";
      case 3 -> "BRL";
      case 4 -> "USD";
      case 5 -> "ARS";
      case 6 -> "USD";
      default -> throw new IllegalStateException("Unexpected value: " + opcion);
    };
  }
}
