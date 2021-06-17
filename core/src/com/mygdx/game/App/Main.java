package com.mygdx.game.App;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //instanciamiento de Digimons
        int[] charizardSkills = {8, 3, 4, 5};
        int[] pikachuSkills = {8, 4, 6, 7};
        Enemigo charizard = new Enemigo(5, 500,200,50,25,100, "Charizard", 100, Carga.cargarHabilidades(), charizardSkills);
        Compa pikachu = new Compa(5,1000,500,100,10,150, "pikachu", 15, Carga.cargarHabilidades(), pikachuSkills);

        //Entrenador\\
        int[] itemKeys = {1,2,3,4};
        Mochila mochilaJugador = new Mochila(Carga.cargarItems(), itemKeys);
        Entrenador entrenador = new Entrenador(mochilaJugador);

        //comienzo de batalla\\
        Batalla battle1 = new Batalla(pikachu, charizard, entrenador);
        battle1.comenzarBatalla();
    }
}
