package com.mygdx.game.App;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import javax.naming.ldap.PagedResultsControl;


public class Main {

    public static void main(String[] args) throws IOException {
        //instanciamiento de clases


        /*Map<Integer, Habilidad> habilidades = new HashMap<>();
        habilidades.put(1, new Habilidad(100, 95, 20, "Ataque Relampago"));
        habilidades.put(2, new Habilidad(70, 100, 15, "Fuego Elemental"));
        habilidades.put(3, new Habilidad(150, 70, 25, "Misil Etereo"));
        habilidades.put(4, new Habilidad(200, 90, 50, "Explosion Mental"));
        habilidades.put(5, new Habilidad(185, 85, 40, "Tormenta de Fuego"));
        habilidades.put(6, new Habilidad(200, 65, 30, "Tormenta Elcctrica"));
        habilidades.put(7, new Habilidad(300, 65, 50, "Descarga Elcctrica"));
        habilidades.put(8, new Habilidad(40, 100, 0, "Ataque Basico"));*/


        //LECTURA DE ARCHIVO .JSON CON LAS HABILIDADES\\
        //Lleno de cosas raras que tuve que sacar de internet para que funcionase\\
        Gson gson = new Gson();
        Map<Integer, Habilidad> habilidades = null;
        try{
            File file = new File("core/src/com/mygdx/game/Archivos/Habilidades.json");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            habilidades = new HashMap<Integer, Habilidad>(gson.fromJson(bufferedReader, Map.class));
            String jsonString = gson.toJson(habilidades);
            Type type = new TypeToken<HashMap<Integer, Habilidad>>(){}.getType();
            habilidades = gson.fromJson(jsonString, type);
            bufferedReader.close();
        }
        catch(IOException e){
            System.out.println("Error de carga de habilidades");
        }

        System.out.println(habilidades.get(2));

        //ESCRITURA DE .JSON CON HABILIDADES\\ (queda comentado porque ya está creado el archivo)

        /*try{
            Gson gson = new Gson();
            File file = new File("core/src/com/mygdx/game/Archivos/Habilidades.json");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            gson.toJson(habilidades, Map.class, bufferedWriter);
            bufferedWriter.close();
        }
        catch(IOException e){
            System.out.println("error");
        }*/


        int[] charizardSkills = {8, 3, 4, 5};
        int[] pikachuSkills = {8, 4, 6, 7};
        //replantear map
        Enemigo charizard = new Enemigo(5, 500,200,50,25,100, "Charizard", 100, habilidades, charizardSkills);
        Compa pikachu = new Compa(5,1000,500,100,10,150, "pikachu", 15, habilidades, pikachuSkills);

        //Items\\
        /*
        Item pocionP = new Pocion("Pocion paqueña", TamanioItem.CHICO.getRecuperacion());
        Item pocionM = new Pocion("Pocion mediana",  TamanioItem.MEDIANO.getRecuperacion());
        Item pocionG = new Pocion("Pocion grande",  TamanioItem.GRANDE.getRecuperacion());
        Item elixirP = new Elixir("Elixir pequeño",  TamanioItem.CHICO.getRecuperacion());
        Item elixirM = new Elixir("Elixir mediano",  TamanioItem.MEDIANO.getRecuperacion());
        Item elixirG = new Elixir("Elixir grande",  TamanioItem.GRANDE.getRecuperacion());
        ArrayList<Item> items = new ArrayList<>();
        items.add(pocionG);
        items.add(elixirG);
        items.add(elixirM);
        items.add(elixirP);
        items.add(pocionM);
        items.add(pocionP);

         */


        /*
        Mochila mochilaJugador = new Mochila();
        mochilaJugador.agregarItem(pocionG);
        mochilaJugador.agregarItem(elixirG);
        mochilaJugador.agregarItem(elixirM);
         */


        //GRABADO DE ITEMS\\
        /*
        try{
            Gson gson2 = new Gson();
            File fileItems = new File("core/src/com/mygdx/game/Archivos/Items.json");
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(fileItems));
            gson2.toJson(items, ArrayList.class, bufferedWriter2);
            bufferedWriter2.close();
            System.out.println("grabado con exito");
        }
        catch(IOException e){
            System.out.println("error");
        }

        System.out.println("Check");

         */






        //LECTURA DE ITEMS\\ FUNCIONA PERO NO SE PORQUE SE ROMPE CUANDO SE SELECCIONA DESDE EL COMBATE

        /*
        Mochila mochilaJugador = new Mochila();
        ArrayList<Item> items = new ArrayList<>();
        Gson gson2 = new Gson();
        try {
            File fileItems = new File("core/src/com/mygdx/game/Archivos/Items.json");
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(fileItems));
            items = (ArrayList<Item>) gson2.fromJson(bufferedReader2, ArrayList.class);
            bufferedReader2.close();
            System.out.println("cargado con exito");
        }
        catch (IOException e){
            System.out.println("Error");
            Texto.systemPause();
        }

         */



        //mochilaJugador = new Mochila(items);
        /*
        System.out.println("check");
        System.out.println(items.getClass());
        System.out.println(items.toString());
        for (Item variable : items){
            System.out.println("asdasd");
        }
        System.out.println(items);
        System.out.println("check");
        System.out.println(((Item)items.get(0)).toString());

        Texto.systemPause();
        mochilaJugador.agregarItem(items.get(0));
        mochilaJugador.agregarItem(items.get(1));
        mochilaJugador.agregarItem(items.get(2));
        System.out.println(mochilaJugador);

         */




        /*
        System.out.println(items);
        System.out.println("check");
        System.out.println(items.get(0));
        System.out.println(items.get(1));
        System.out.println(items.get(2));
        mochilaJugador.agregarItem(()items.get(0));
        mochilaJugador.agregarItem(items.get(1));
        mochilaJugador.agregarItem(items.get(2));
        System.out.println("check");
         */




        /*
        String jsonString2 = gson2.toJson(mochilaJugador);

         */

        /*
        Type type2 = new TypeToken<Mochila>(){}.getType();
        System.out.println(type2);
        String jsonString2 = gson2.toJson(mochilaJugador);
        mochilaJugador = gson2.fromJson(jsonString2, type2);
        System.out.println(mochilaJugador);
         */



        //Entrenador\\
        //Entrenador entrenador = new Entrenador(mochilaJugador);

        //pikachu.setVida(120);
        //pikachu.setMana(320);
        /*
        Batalla battle1 = new Batalla(pikachu, charizard, entrenador);
        battle1.comenzarBatalla();
        Texto.systemPause();

         */

        /*
        System.out.println(pikachu);

        pocionP.usar(pikachu);

        System.out.println(pikachu);
        System.out.println(pocionP);

        pocionP.tirar(4);

        System.out.println(pocionP);

         */


        //ITEMS COMO MAP\\
        /*
        Item pocionP = new Pocion("Pocion paqueña", TamanioItem.CHICO.getRecuperacion());
        Item pocionM = new Pocion("Pocion mediana",  TamanioItem.MEDIANO.getRecuperacion());
        Item pocionG = new Pocion("Pocion grande",  TamanioItem.GRANDE.getRecuperacion());
        Item elixirP = new Elixir("Elixir pequeño",  TamanioItem.CHICO.getRecuperacion());
        Item elixirM = new Elixir("Elixir mediano",  TamanioItem.MEDIANO.getRecuperacion());
        Item elixirG = new Elixir("Elixir grande",  TamanioItem.GRANDE.getRecuperacion());
        Map<Integer, Item> items = new HashMap<>();
        items.put(1, pocionG);
        items.put(2, elixirG);
        items.put(3, elixirM);
        items.put(4, elixirP);
        items.put(5, pocionM);
        items.put(6, pocionP);

        try{

            Gson gson2 = new Gson();
            File fileItems = new File("core/src/com/mygdx/game/Archivos/Items2.json");
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(fileItems));
            gson2.toJson(items, Map.class, bufferedWriter2);
            bufferedWriter2.close();
            System.out.println("grabado con exito");
        }
        catch(IOException e){
            System.out.println("error");
        }

        System.out.println("Check");

         */

        Gson gson2 = new Gson();
        Map<Integer, Item> items = null;
        try{
            File file2 = new File("core/src/com/mygdx/game/Archivos/Items2.json");
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
            items = new HashMap<Integer, Item>(gson2.fromJson(bufferedReader2, Map.class));
            String jsonString2 = gson2.toJson(items);
            Type type = new TypeToken<HashMap<Integer, Item>>(){}.getType();
            items = gson2.fromJson(jsonString2, type);
            bufferedReader2.close();
        }
        catch(IOException e){
            System.out.println("Error de carga de Items");
        }

        System.out.println(items.get(2));
        System.out.println(items.toString());
        int[] itemKeys = {1,2,3,4};
        Mochila mochilaJugador = new Mochila(items, itemKeys);
        System.out.println(items.toString());
        Texto.imprimirMenuInventario(mochilaJugador.getListaBolsillo());
        System.out.println("check");

        Entrenador entrenador = new Entrenador(mochilaJugador);
        Batalla battle1 = new Batalla(pikachu, charizard, entrenador);
        battle1.comenzarBatalla();

    }
}
