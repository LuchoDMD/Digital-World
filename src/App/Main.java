package App;

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
        abilities.put(8, new Ability(40, 100, 0, "Ataque Básico"));
        int[] charizardSkills = {8, 3, 4, 5};
        int[] pikachuSkills = {8, 4, 6, 7};
        //replantear map
        Enemy charizard = new Enemy(5, 500,200,50,25,100, 100, "charizard", 100, abilities, charizardSkills);
        Partner pikachu = new Partner(5,300,500,100,10,150, "pikachu", 15, abilities, pikachuSkills);

        pikachu.setVida(120);
        pikachu.setMana(320);

        //Batalla battle1 = new Batalla(pikachu, charizard);
        //battle1.comenzarBatalla();

        Item pocionP = new Pocion("Pocion paqueña", 10, 30);
        Item pocionM = new Pocion("Pocion mediana", 20, 70);
        Item pocionG = new Pocion("Pocion grande", 5, 100);
        Item elixirP = new Elixir("Elixir pequeño", 10, 30);
        Item elixirM = new Elixir("Elixir mediano", 20, 70);
        Item elixirG = new Elixir("Elixir grande", 5, 100);

        System.out.println(pikachu);

        pocionP.usar(pikachu);

        System.out.println(pikachu);
        System.out.println(pocionP);

        pocionP.tirar(4);

        System.out.println(pocionP);

        Mochila<Item> mochilaJugador = new Mochila<>();

        mochilaJugador.agregarItems(pocionG);
        mochilaJugador.agregarItems(elixirM);

        System.out.println(mochilaJugador);

    }
}
