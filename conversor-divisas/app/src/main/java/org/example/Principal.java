package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        int opcion = 0;
        Scanner teclado = new Scanner(System.in);
        Controlador controlador = new Controlador();

        String menu = """
                ********************************
                ¡Bienvenido/a al conversor de monedas!
                
                Introduzca la opción de conversión a realizar.
                
                1) Dólar => Peso argentino.
                2) Peso argentino => Dólar.
                3) Dólar => Peso colombiano.
                4) Peso colombiano => Dólar.
                5) Peso mexicano => Peso colombiano.
                6) Peso colombiano => Peso mexicano.
                7) Salir.
                ********************************
                """;

        while (opcion != 7) {
            System.out.println(menu);
            opcion = teclado.nextInt();

            if(opcion != 7) {
                System.out.println("Ingrese la cantidad de dinero a convertir:");
                int numeroIngresado = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println(controlador.realizarConversion(numeroIngresado, "USD", "ARS"));
                        break;

                    case 2:
                        System.out.println(controlador.realizarConversion(numeroIngresado, "ARS", "USD"));
                        break;

                    case 3:
                        System.out.println(controlador.realizarConversion(numeroIngresado, "USD", "COP"));
                        break;

                    case 4:
                        System.out.println(controlador.realizarConversion(numeroIngresado, "COP", "USD"));
                        break;

                    case 5:
                        System.out.println(controlador.realizarConversion(numeroIngresado, "MXN", "COP"));
                        break;

                    case 6:
                        System.out.println(controlador.realizarConversion(numeroIngresado, "COP", "MXN"));
                        break;

                    default:
                        System.out.println("Opción no válida. Introduzca una opción del menú.");

                }
            }
        }
    }
}
