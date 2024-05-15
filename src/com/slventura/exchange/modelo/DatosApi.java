package com.slventura.exchange.modelo;

public record DatosApi(String time_last_update_utc,
                       String base_code,
                       String target_code,
                       double conversion_rate,
                       double currency_amount) {
}
