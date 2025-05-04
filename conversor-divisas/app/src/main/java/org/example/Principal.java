package org.example;


import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static String actualCurrency = "";
    public static String targetCurrency = "";

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Scanner teclado = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 7) {
            displayMenu();
            opcion = teclado.nextInt();

            try {
                if (choiceMenu(opcion)) {
                    System.out.println("Ingrese la cantidad de dinero a convertir:");
                    int numeroIngresado = teclado.nextInt();

                    String message = controlador.realizarConversion(numeroIngresado, actualCurrency, targetCurrency);
                    System.out.println(message);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void displayMenu() {
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

        System.out.println(menu);
    }

    public static boolean choiceMenu(int opcion) {
        switch (opcion) {
            case 1:
                actualCurrency = "USD";
                targetCurrency = "ARS";
                break;
            case 2:
                actualCurrency = "ARS";
                targetCurrency = "USD";
                break;
            case 3:
                actualCurrency = "USD";
                targetCurrency = "COP";
                break;
            case 4:
                actualCurrency = "COP";
                targetCurrency = "USD";
                break;
            case 5:
                actualCurrency = "MXN";
                targetCurrency = "COP";
                break;
            case 6:
                actualCurrency = "COP";
                targetCurrency = "MXN";
                break;
            default:
                System.out.println("La opcion seleccionada no es valida.");
                return false;

        }
        return true;
    }
}
