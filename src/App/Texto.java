package App;

import java.util.List;
import java.util.Scanner;

//Clase con todos los prints
public class Texto{

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

    public static String printLog(List<Turno> log){
        String rda = "";
        for(Turno variable : log){
            rda = rda + variable.toString() + "\n";
        }
        return rda;
    }

    public static void limpiarPantalla(){
        for(int i = 0; i < 50 ; i++){
            System.out.println(" ");
        }
    }

    public static void imprimirMenuCombate(){
        System.out.println("presione 1 para Atacar");
        System.out.println("presione 2 para Defender");
        System.out.println("presione 3 para Esquivar");
        System.out.println("presione 4 para ver Inventario");

    }

    public static void printMenuSkills(Compa compa){
        System.out.println("1 :" + compa.habilidades[0].toString());
        System.out.println("2 :" + compa.habilidades[1].toString());
        System.out.println("3 :" + compa.habilidades[2].toString());
        System.out.println("4 :" + compa.habilidades[3].toString());
        System.out.print("Seleccione habilidad para lanzar: ");
    }

    public static void printMenuStatus(Enemigo enemigo, Compa compa){
        System.out.println("Enemigo:                      Player:");
        System.out.println("HP: " + enemigo.getHp() + "                     HP: " + compa.getVida());
        System.out.println("MP: " + enemigo.getMp() + "                     MP: " + compa.getMana());
    }

}
