package com.mygdx.game.Pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.App.*;
import com.mygdx.game.Elementos.Botones;
import com.mygdx.game.Elementos.Imagen;
import com.mygdx.game.Elementos.Texto;
import com.mygdx.game.Eventos.EntradaBatalla;
import com.mygdx.game.Utiles.Recursos;
import com.mygdx.game.Utiles.Render;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PantallaBatalla implements Screen {

    private SpriteBatch b;
    private int ancho=200, alto=30;
    private Imagen fondo;
    private Botones botones;
    private Texto o1,o2,o3,o4,h1,h2,h3,h4, descripcion;
    private EntradaBatalla entada = new EntradaBatalla(this);
    private int cont=0;
    public float tiempo;
    private Batalla batalla;
    private Compa pikachu;
    private Enemigo charizard;
    private Entrenador entrenador;
    private Map<Integer, Habilidad> habilidades = new HashMap<>();
    private Mochila mochilaJugador;


    @Override
    public void show() {

        habilidades.put(1, new Habilidad(100, 95, 20, "Ataque Relampago"));
        habilidades.put(2, new Habilidad(70, 100, 15, "Fuego Elemental"));
        habilidades.put(3, new Habilidad(150, 70, 25, "Misil Etereo"));
        habilidades.put(4, new Habilidad(200, 90, 50, "Explosion Mental"));
        habilidades.put(5, new Habilidad(185, 85, 40, "Tormenta de Fuego"));
        habilidades.put(6, new Habilidad(200, 65, 30, "Tormenta Elcctrica"));
        habilidades.put(7, new Habilidad(300, 65, 50, "Descarga Elcctrica"));
        habilidades.put(8, new Habilidad(40, 100, 0, "Ataque Basico"));
        int[] charizardSkills = {1, 2, 3, 4};
        int[] pikachuSkills = {5, 6, 7, 8};

         charizard = new Enemigo(5, 500,200,50,25,100, "Charizard", 100, habilidades, charizardSkills);
         pikachu = new Compa(5,1000,500,100,10,150, "pikachu", 15, habilidades, pikachuSkills);


        Item pocionG = new Pocion("Pocion grande", 5, TamanioItem.GRANDE.getRecuperacion());
        Item elixirM = new Elixir("Elixir mediano", 20, TamanioItem.MEDIANO.getRecuperacion());
        Item elixirG = new Elixir("Elixir grande", 5, TamanioItem.GRANDE.getRecuperacion());
        List<Item> items = new ArrayList<>();
        items.add(pocionG);
        items.add(elixirG);
        items.add(elixirM);
        mochilaJugador = new Mochila(items);
        entrenador = new Entrenador(mochilaJugador);

        batalla = new Batalla(pikachu, charizard, entrenador);
        batalla.comenzarBatalla();


        b= Render.batch;
        fondo= new Imagen(Recursos.BATALLA);
        Gdx.input.setInputProcessor(entada);

        descripcion=new Texto(Recursos.FUENTE1,40, Color.ORANGE,true);
        descripcion.setTexto("¿Que deberia hacer -----?");
        descripcion.setPosition(80,150);


        botones = new Botones();
    }

    private void cargarBotones(){
        botones.agregarBoton(o1,"Luchar",40);
        botones.agregarBoton(o2,"Mochila",40);
        botones.agregarBoton(o3,"Huir",40);
        botones.agregarBoton(o4,"",40);
    }

    private void cargarHabilidades(){
        botones.agregarBoton(h1,"Habilidad 1",30);
        botones.agregarBoton(h2,"Habilidad 2",30);
        botones.agregarBoton(h3,"Habilidad 3",30);
        botones.agregarBoton(h4,"Habilidad 4",30);
    }

    private void posicionBotonera(){
        float dist=45;
        float i=0;
        for (Texto aux:botones.getBotones()){
            aux.setPosition(900,170-i*dist);
            aux.dibujar();
            i++;
        }
    }

    private void posicionHabilidades(){
        float dist=30;
        float i=0;
        for (Texto aux:botones.getBotones()){
            aux.setPosition(900,200-i*dist);
            aux.dibujar();
            i++;
        }
    }

    private void eleccionBoton(){
        posicionBotonera();
        tiempo+=Gdx.graphics.getDeltaTime();

        if(entada.isAbajo()){
            if(tiempo>0.1f){
                tiempo=0;
                cont++;
                if(cont>3){
                    cont=1;
                }
            }
        }

        if(entada.isArriba()){
            if(tiempo>0.1f){
                tiempo=0;
                cont--;
                if(cont<1){
                    cont=3;
                }
            }
        }

        for (int i=0; i<botones.getBotones().size();i++){
            if(i==(cont-1)){
                botones.getBotones().get(i).setColor(Color.ORANGE);
            }else{
                botones.getBotones().get(i).setColor(Color.WHITE);
            }
        }
    }

    private void eleccionHabilidades(){
        tiempo+=Gdx.graphics.getDeltaTime();

        if(entada.isAbajo()){
            if(tiempo>0.1f){
                tiempo=0;
                cont++;
                if(cont>4){
                    cont=1;
                }
            }
        }

        if(entada.isArriba()){
            if(tiempo>0.1f){
                tiempo=0;
                cont--;
                if(cont<1){
                    cont=4;
                }
            }
        }

        for (int i=0; i<botones.getBotones().size();i++){
            if(i==(cont)){
                botones.getBotones().get(i).setColor(Color.ORANGE);
            }else{
                botones.getBotones().get(i).setColor(Color.WHITE);
            }
        }
    }

    private int luchar(){
        if(cont==1 && entada.isEnter()){
            botones.limpiar();
            cargarHabilidades();
            posicionHabilidades();
            eleccionHabilidades();
            return 0;
        }
        return 1;
    }



    @Override
    public void render(float delta) {
        Render.limpiarPantalla(1,1,1);
        b.begin();
        fondo.dibujar();
        descripcion.dibujar();
        b.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
