package com.mygdx.game.Pantalla;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.App.*;
import com.mygdx.game.Elementos.Imagen;
import com.mygdx.game.Elementos.Texto;
import com.mygdx.game.Eventos.EntradaBatalla;
import com.mygdx.game.Utiles.Recursos;
import com.mygdx.game.Utiles.Render;

import java.util.ArrayList;
import java.util.List;


public class PantallaBatalla implements Screen {

    private SpriteBatch b;
    private int ancho=200, alto=30;
    private Imagen fondo;
    private Texto descripcion, statsCompa,statsEnemigo,menu,aux;
    private EntradaBatalla entrada = new EntradaBatalla(this);
    private TextButton luchar,mochila,huir,hab1,hab2,hab3,hab4,atras;
    private Stage stage;
    private Skin skin;
    private static Compa compa;
    private static Entrenador entrenador;
    private static Enemigo enemigo;
    public List<Turno> log = new ArrayList<>();
    private int turno = 1;
    public float tiempo;
    private Music musica;


    public Compa getCompa() {
        return compa;
    }

    public static void setCompa(Compa partner) {
        compa = partner;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public static void setEntrenador(int[] keyItems) {
        entrenador = new Entrenador(new Mochila(Carga.cargarItems("Items2.json"), keyItems));
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }

    public static void setEnemigo(Enemigo enem) {
        enemigo = enem;
    }


    @Override
    public void show() {

         // seconds
        //stage=new Stage();
        //Gdx.input.setInputProcessor(stage);
        //skin=new Skin(Gdx.files.internal("Skin/uiskin.json"));

        /**-----------------------------------BOTONES DE OPCIONES------------------------------------*/
        /*luchar= new TextButton("Luchar",skin);
        luchar.setPosition(800,130);
        luchar.setHeight(40);
        luchar.setWidth(200);
        poner(luchar);


        mochila= new TextButton("Mochila",skin);
        mochila.setPosition(luchar.getX()+luchar.getWidth()+10,130);
        mochila.setHeight(40);
        mochila.setWidth(200);
        poner(mochila);


        huir= new TextButton("Huir",skin);
        huir.setPosition(luchar.getX(),luchar.getY()-luchar.getHeight()-10);
        huir.setHeight(40);
        huir.setWidth(200);
        poner(huir);

        /**-----------------------------------BOTONES DE HABILIDADES------------------------------------*/
        /*hab1= new TextButton("Habilidad1",skin);
        hab1.setPosition(800,130);
        hab1.setHeight(40);
        hab1.setWidth(200);
        poner(hab1);
        hab1.setVisible(false);

        hab2= new TextButton("Habilidad2",skin);
        hab2.setPosition(luchar.getX()+luchar.getWidth()+10,130);
        hab2.setHeight(40);
        hab2.setWidth(200);
        poner(hab2);
        hab2.setVisible(false);

        hab3= new TextButton("Habilidad3",skin);
        hab3.setPosition(luchar.getX(),luchar.getY()-luchar.getHeight()-10);
        hab3.setHeight(40);
        hab3.setWidth(200);
        poner(hab3);
        hab3.setVisible(false);

        hab4= new TextButton("Habilidad4",skin);
        hab4.setPosition(mochila.getX(), huir.getY());
        hab4.setHeight(40);
        hab4.setWidth(200);
        poner(hab4);
        hab4.setVisible(false);


        atras= new TextButton("Atras",skin);
        atras.setPosition(hab3.getX(), hab3.getY()-hab3.getHeight()-5);
        atras.setHeight(30);
        atras.setWidth(200);
        poner(atras);
        atras.setVisible(false);*/


        musica= Gdx.audio.newMusic(Gdx.files.internal(Recursos.MUSICABATALLA));

        b= Render.batch;
        Gdx.input.setInputProcessor(entrada);
        fondo= new Imagen(Recursos.BATALLA);

        descripcion=new Texto(Recursos.FUENTE1,30, Color.ORANGE,true);
        descripcion.setTexto("¿Que deberia hacer " + compa.getNombre() + "?");
        descripcion.setPosition(80,150);


        statsCompa=new Texto(Recursos.FUENTE1,30, Color.ORANGE,true);
        statsCompa.setPosition(850, 330);
        statsCompa.setTexto(compa.getNombre() + " \nHP: " + compa.getVida() + "\nMP: " + compa.getMana());

        statsEnemigo=new Texto(Recursos.FUENTE1,30, Color.ORANGE,true);
        statsEnemigo.setPosition(80, 650);
        statsEnemigo.setTexto(enemigo.getNombre() + " \nHP: " + enemigo.getHp() + "\nMP: " + enemigo.getMp());

        menu=new Texto(Recursos.FUENTE1,40,Color.ORANGE,true);
        menu.setPosition(850,170);
        menu.setTexto("Q- LUCHAR\nW- MOCHILA\nE- HUIR\n");

        aux=new Texto(Recursos.FUENTE1,40, Color.ORANGE,true);
        aux.setTexto("");
        aux.setPosition(80,120);

    }

    private void menu(){
        menu.dibujar();
            if (entrada.isBotq()) {
                descripcion.setTexto("Elige una Habilidad\n 0: Para Regresar");
                menu = new Texto(Recursos.FUENTE1, 30, Color.ORANGE, true);
                menu.setPosition(700, 170);
                menu.setTexto(
                        " 1: " + compa.habilidades[0].getNombre() + "\n" +
                                " 2: " + compa.habilidades[1].getNombre() + "\n" +
                                " 3: " + compa.habilidades[2].getNombre() + "\n" +
                                " 4: " + compa.habilidades[3].getNombre() + "\n");
                menu.dibujar();
            }
            if (entrada.isBotw()) {
                descripcion.setTexto("Elige un Item\n0: Para Regresar");
                menu = new Texto(Recursos.FUENTE1, 30, Color.ORANGE, true);
                menu.setPosition(700, 170);
                menu.setTexto(
                        " 1: " + entrenador.mochila.getBolsillos(0).getItem().getDescEfecto() + "\n" +
                                " 2: " + entrenador.mochila.getBolsillos(1).getItem().getDescEfecto() + "\n" +
                                " 3: " + entrenador.mochila.getBolsillos(2).getItem().getDescEfecto() + "\n" +
                                " 4: " + entrenador.mochila.getBolsillos(3).getItem().getDescEfecto() + "\n"
                );
                menu.dibujar();
            }
            if (entrada.isBote()) {
                Render.app.setScreen(new PantallaMapa());
            }
            menuHabilidades();


    }

    private void menuHabilidades(){
        boolean flagMenu = true;
        label: while (flagMenu){
            if (entrada.isBot1()) {
                if(tiempo>0.1f){
                    tiempo=0;
                int danio = enemigo.getDanioRecibido(compa.habilidadAtaque(compa.habilidades[0]));
                enemigo.golpeRematador(danio);
                log.add(new Turno(compa.getNombre(), enemigo.getNombre(), danio, turno, compa.habilidades[0].getNombre()));
                descripcion.setTexto("Has lanzado " + compa.habilidades[0].getNombre());
                com.mygdx.game.App.Texto.printMenuStatus(enemigo, compa);
                statsEnemigo.setTexto(enemigo.getNombre() + " \nHP: " + enemigo.getHp() + "\nMP: " + enemigo.getMp());
                compa.regenerarMP();
                statsCompa.setTexto(compa.getNombre() + " \nHP: " + compa.getVida() + "\nMP: " + compa.getMana());
                statsCompa.dibujar();
                }
            }


            if (entrada.isBot2()) {
                if(tiempo>0.1f){
                    tiempo=0;
                int danio = enemigo.getDanioRecibido(compa.habilidadAtaque(compa.habilidades[1]));
                if (compa.verificarMana(compa.habilidades[1])) {
                    compa.setMana(compa.getMana() - compa.habilidades[1].getCostoMP());
                    enemigo.golpeRematador(danio);
                } else {
                    aux.setTexto("No tienes sufiente MP ");
                    aux.dibujar();
                    continue;
                }
                log.add(new Turno(compa.getNombre(), enemigo.getNombre(), danio, turno, compa.habilidades[1].getNombre()));
                com.mygdx.game.App.Texto.printMenuStatus(enemigo, compa);
                descripcion.setTexto("Has lanzado " + compa.habilidades[1].getNombre());
                statsEnemigo.setTexto(enemigo.getNombre() + " \nHP: " + enemigo.getHp() + "\nMP: " + enemigo.getMp());
                statsCompa.setTexto(compa.getNombre() + " \nHP: " + compa.getVida() + "\nMP: " + compa.getMana());
                statsCompa.dibujar();
                }
            }
            turnoBot();
            flagMenu = false;
        }
    }

    private void turnoBot(){

        int accion = enemigo.botEnemigo();
                int danio = compa.getDanioRecibido(enemigo.habilidadAtaque(enemigo.habilidades[accion]));
                enemigo.setMp(enemigo.getMp() - enemigo.habilidades[accion].getCostoMP());
                compa.golpeRematador(danio);
                log.add(new Turno(enemigo.getNombre(), compa.getNombre(), danio, turno, enemigo.habilidades[accion].getNombre()));
                if (danio == 0) {
                    descripcion.setTexto("El Enemigo \nha fallado el ataque");
                }
                else{
                    descripcion.setTexto("El enemigo ha lanzado \n" + enemigo.habilidades[accion].getNombre()+ "\nDanio " + enemigo.habilidades[accion].getDanio());
                }
                if (accion == 0) {
                    enemigo.regenerarMP();
                }
    }

    @Override
    public void render(float delta) {
        Render.limpiarPantalla(1,1,1);
        tiempo+=delta/2;
        musica.setVolume(0.3f);
        musica.play();
        b.begin();
        fondo.dibujar();
        descripcion.dibujar();
        statsCompa.dibujar();
        menu();
        statsEnemigo.dibujar();
        b.end();
    }




    private void poner(Actor a){
        stage.addActor(a);
    }

    private void botonLuchar(){
        luchar.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                luchar.setVisible(false);
                mochila.setVisible(false);
                huir.setVisible(false);
                hab1.setVisible(true);
                hab2.setVisible(true);
                hab3.setVisible(true);
                hab4.setVisible(true);
                atras.setVisible(true);
            }
        });
    }

    private void botonMochila(){

    }

    private void habilidad1(){

    }

    private void habilidad2(){

    }

    private void habilidad3(){

    }

    private void habilidad4(){

    }

    private void botonHuir(){
        huir.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Render.app.setScreen(new PantallaMapa());
            }
        });
    }

    private void botonAtras(){
        atras.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                hab1.setVisible(false);
                hab2.setVisible(false);
                hab3.setVisible(false);
                hab4.setVisible(false);
                atras.setVisible(false);
                luchar.setVisible(true);
                mochila.setVisible(true);
                huir.setVisible(true);
            }
        });
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
