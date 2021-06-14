package com.mygdx.game.App;

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

    // Metodo para imprimir un encabezado en la consola

    public static void imprimirEncabezado (String titulo) {
        imprimirSeparacion(50);
        System.out.println(titulo);
        imprimirSeparacion(50);
    }

    // Metodos para la impresion de la historia del juego

    public static void imprimirIntroduccion() {
        imprimirSeparacion(50);
        System.out.println("PROLOGO");
        imprimirSeparacion(50);
        System.out.println("Inicias tu aventura seleccionando a tu compañero Digimon y habiendolo bautizado con un hermoso nombre.");
        System.out.println("Tu deber como entrenador de Digimons es derrotar a todos tus enemigos para alzarte con la victoria");
        System.out.println("La aventura comienza ahora!");
        systemPause();
    }

    // Metodo para imprimir los logs de batalla del combate

    public static String printLog(List<Turno> log){
        StringBuilder rda = new StringBuilder();
        for(Turno variable : log){
            rda.append(variable.toString()).append("\n");
        }
        return rda.toString();
    }

    // Metodo para simular un screen clear

    public static void limpiarPantalla(){
        for(int i = 0; i < 50 ; i++){
            System.out.println(" ");
        }
    }

    public static void imprimirMenuCombate(){
        imprimirEncabezado("BATALLA EN PROGRESO:");
        System.out.println("1) Atacar.");
        System.out.println("2) Defender.");
        System.out.println("3) Esquivar.");
        System.out.println("4) Ver estadisticas actuales.");
        System.out.println("5) Inventario.");
        System.out.println("6) Huir del combate.");
        imprimirSeparacion(50);
        System.out.print("Seleccione una opcion: ");
    }


    public static void imprimirMenuInventario(Mochila<Item> mochila){
        int aux = 1;
        for (Item variable: mochila.getBolsillo()) {
            System.out.println("presione " + aux + " para utilizar " + variable);
            aux++;
        }
    }


    public static void printMenuSkills(Compa compa){
        limpiarPantalla();
        imprimirEncabezado("LISTA DE HABILIDADES DISPONIBLES:");
        System.out.println("Habilidad 1: " + compa.habilidades[0].toString());
        System.out.println("Habilidad 2: " + compa.habilidades[1].toString());
        System.out.println("Habilitad 3: " + compa.habilidades[2].toString());
        System.out.println("Habilidad 4: " + compa.habilidades[3].toString());
        System.out.println("5) Regresar al menu anterior.");
        imprimirSeparacion(50);
        System.out.print("Seleccione habilidad para lanzar: ");
    }

    public static void printMenuStatus(Enemigo enemigo, Compa compa){
        imprimirEncabezado("ESTADISTICAS ACTUALES DE LOS PERSONAJES:");
        System.out.println("Jugador:                      Enemigo:");
        System.out.println("HP: " + compa.getVida() + "                       HP: " + enemigo.getHp());
        System.out.println("MP: " + compa.getMana() + "                       MP: " + enemigo.getMp());
    }

    public static void declararVencedor(Enemigo enemigo, Compa compa){
        if (compa.getVida() <= 0) {
            System.out.println("El enemigo logro destruir a tu Digimon!");
        } else {
            System.out.println("Lograste aplastar a tu enemigo!");
        }
    }

    public static void huirBatalla (){
        System.out.println("Huiste despavorido de la batalla");
        systemPause();
        System.exit(0);
    }

}
