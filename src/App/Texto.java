package App;

import java.util.Scanner;

public class Texto {

    static Scanner scanner = new Scanner(System.in);

    // Metodo para usar separadores de tamaño n

    public static void imprimirSeparacion (int n) {
        for (int i=0; i<n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // Metodo para detener el juego hasta que el usuario ingrese algo por consola
    // Una improvisacion del system("pause")

    public static void systemPause () {
        System.out.println("Ingrese una tecla para continuar...");
        scanner.next();
    }

    public static void imprimirIntroduccion() {
        imprimirSeparacion(30);
        System.out.println("PROLOGO");
        imprimirSeparacion(30);
        System.out.println("Inicias tu aventura seleccionando a tu compañero Digimon y habiendolo bautizado con un hermoso nombre.");
        System.out.println("Tu deber como entrenador de Digimons es derrotar a todos tus enemigos para alzarte con la victoria");
        System.out.println("La aventura comienza ahora!");
        systemPause();
    }
}
