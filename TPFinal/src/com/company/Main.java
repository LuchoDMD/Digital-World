package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        //instanciamiento
        Map<Integer, Ability> abilities = new HashMap<>();
        abilities.put(1, new Ability(100, 95, 20, "Ataque Relámpago"));
        abilities.put(2, new Ability(70, 100, 15, "Fuego Elemental"));
        abilities.put(3, new Ability(150, 70, 25, "Misil Etéreo"));
        abilities.put(4, new Ability(200, 90, 50, "Explosión Mental"));
        abilities.put(5, new Ability(185, 85, 40, "Tormenta de Fuego"));
        abilities.put(6, new Ability(200, 65, 30, "Tormenta Eléctrica"));
        abilities.put(7, new Ability(300, 65, 50, "Descarga Eléctrica"));
        int[] charizardSkills = {2, 3, 4, 5};
        int[] pikachuSkills = {1, 4, 6, 7};
        Enemy charizard = new Enemy(5, 500,200,50,25,100, 100, "charizard", abilities, charizardSkills);
        Partner pikachu = new Partner(5,300,500,100,10,150, "pikachu", (HashMap) abilities, pikachuSkills);


        Batalla battle1 = new Batalla(pikachu, charizard);
        battle1.comenzarBatalla();

    }
}
