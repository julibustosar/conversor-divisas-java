package org.example;

import java.io.IOException;

public class Controlador {
    private Request request = new Request();
    private Conversion conversion = new Conversion();

    public String realizarConversion (double valorActual, String consulta, String divisaResultado) throws IOException, InterruptedException {
        String divisa = request.getConsulta(consulta, divisaResultado);
        double resultadoConversion = conversion.convertirAMoneda(valorActual, Double.parseDouble(divisa));
        return "El valor de la conversión de " + consulta + " a " + divisaResultado + " es: " + resultadoConversion;
    }

}
