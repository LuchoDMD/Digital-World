package com.mygdx.game.App;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import com.mygdx.game.Pantalla.*;
import java.util.List;

public class Carga {

    public static Map<Integer, Habilidad> cargarHabilidades(){
        Gson gson = new Gson();
        File file = new File("core/src/com/mygdx/game/Archivos/Habilidades.json");
        Map<Integer, Habilidad> habilidades = null;
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            habilidades = new HashMap<Integer, Habilidad>(gson.fromJson(bufferedReader, Map.class));
            String jsonString = gson.toJson(habilidades);
            Type type = new TypeToken<HashMap<Integer, Habilidad>>(){}.getType();
            habilidades = gson.fromJson(jsonString, type);
            bufferedReader.close();
            return habilidades;
        }
        catch(IOException e){
            System.out.println("Error de carga de habilidades");
        }
        return null;
    }

    //método de testeo\\
    public static Map<Integer, Habilidad> cargarHabilidades(String path){
        Gson gson = new Gson();
        File file = new File(path);
        Map<Integer, Habilidad> habilidades = null;
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            habilidades = new HashMap<Integer, Habilidad>(gson.fromJson(bufferedReader, Map.class));
            String jsonString = gson.toJson(habilidades);
            Type type = new TypeToken<HashMap<Integer, Habilidad>>(){}.getType();
            habilidades = gson.fromJson(jsonString, type);
            bufferedReader.close();
            return habilidades;
        }
        catch(IOException e){
            System.out.println("Error de carga de habilidades");
        }
        return null;
    }



    public static Map<Integer, Item> cargarItems(){
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
        return items;
    }

    public static Map<Integer, Item> cargarItems(String path){
        Gson gson2 = new Gson();
        Map<Integer, Item> items = null;
        try{
            File file2 = new File(path);
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
        return items;
    }



    public static boolean guardarHabilidades(){
        Map<Integer, Habilidad> habilidades = new HashMap<>();
        habilidades.put(1, new Habilidad(120,95,20,"Espada Trancesdental"));
        habilidades.put(2, new Habilidad(150,100,30,"Rifle Supremo"));
        habilidades.put(3, new Habilidad(250,70,35,"Omega Inforce"));
        habilidades.put(4, new Habilidad(110,95,20,"Destructor Dimensional"));
        habilidades.put(5, new Habilidad(120,95,20,"Crono Paradoja"));
        habilidades.put(6, new Habilidad(250,95,20,"Gran Big Bang"));
        habilidades.put(7, new Habilidad(80,95,20,"Garra Brutal"));
        habilidades.put(8, new Habilidad(90,95,20,"Mordisco Fugaz"));
        habilidades.put(9, new Habilidad(120,95,20,"Flama Bebe"));
        habilidades.put(10, new Habilidad(90,95,20,"Cornada"));
        habilidades.put(11, new Habilidad(110,95,20,"Fuego Azul"));
        habilidades.put(12, new Habilidad(70,95,20,"Circ. Magico"));
        habilidades.put(13, new Habilidad(75,95,20,"Frag. Hielo"));
        habilidades.put(14, new Habilidad(80,95,20,"Llama Infernal"));
        habilidades.put(15, new Habilidad(60,95,20,"Ataque Basico"));
        try{
            Gson gson = new Gson();
            //File file = new File("core/src/com/mygdx/game/Archivos/Habilidades.json");
            File file = new File("Habilidades.json");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            gson.toJson(habilidades, Map.class, bufferedWriter);
            bufferedWriter.close();
            return true;
        }
        catch(IOException e){
            System.out.println("error");
        }
        return false;
    }

    public static boolean guardarItems(){
        Item pocionP = new Pocion("Pocion",  TamanioItem.GRANDE.getRecuperacion());
        Item pocionM = new Pocion("Pocion",  TamanioItem.GRANDE.getRecuperacion());
        Item pocionG = new Pocion("Pocion",  TamanioItem.GRANDE.getRecuperacion());
        Item elixirP = new Elixir("Elixir",  TamanioItem.GRANDE.getRecuperacion());
        Item elixirM = new Elixir("Elixir",  TamanioItem.GRANDE.getRecuperacion());
        Item elixirG = new Elixir("Elixir",  TamanioItem.GRANDE.getRecuperacion());
        Map<Integer, Item> items = new HashMap<>();
        items.put(1, pocionG);
        items.put(2, elixirG);
        items.put(3, elixirM);
        items.put(4, elixirP);
        items.put(5, pocionM);
        items.put(6, pocionP);

        try{
            Gson gson2 = new Gson();
            File fileItems = new File("Items2.json");
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(fileItems));
            gson2.toJson(items, Map.class, bufferedWriter2);
            bufferedWriter2.close();
            System.out.println("grabado con exito");
            return true;
        }
        catch(IOException e){
            System.out.println("error");
        }
        return false;
    }


}
