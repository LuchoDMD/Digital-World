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
            System.out.println("check1");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            System.out.println("check2");
            habilidades = new HashMap<Integer, Habilidad>(gson.fromJson(bufferedReader, Map.class));
            System.out.println("check3");
            String jsonString = gson.toJson(habilidades);
            System.out.println("check4");
            Type type = new TypeToken<HashMap<Integer, Habilidad>>(){}.getType();
            System.out.println("check5");
            habilidades = gson.fromJson(jsonString, type);
            System.out.println("check6");
            bufferedReader.close();
            System.out.println("check7");
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
        habilidades.put(1, new Habilidad(100, 95, 20, "Ataque Relampago"));
        habilidades.put(2, new Habilidad(70, 100, 15, "Fuego Elemental"));
        habilidades.put(3, new Habilidad(150, 70, 25, "Misil Etereo"));
        habilidades.put(4, new Habilidad(200, 90, 50, "Explosion Mental"));
        habilidades.put(5, new Habilidad(185, 85, 40, "Tormenta de Fuego"));
        habilidades.put(6, new Habilidad(200, 65, 30, "Tormenta Elcctrica"));
        habilidades.put(7, new Habilidad(300, 65, 50, "Descarga Elcctrica"));
        habilidades.put(8, new Habilidad(40, 100, 0, "Ataque Basico"));
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
            return true;
        }
        catch(IOException e){
            System.out.println("error");
        }
        return false;
    }


}
