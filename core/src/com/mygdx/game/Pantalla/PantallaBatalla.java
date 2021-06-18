package com.mygdx.game.Pantalla;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.App.*;
import com.mygdx.game.Elementos.Imagen;
import com.mygdx.game.Elementos.Texto;
import com.mygdx.game.Eventos.EntradaBatalla;
import com.mygdx.game.Utiles.Recursos;
import com.mygdx.game.Utiles.Render;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PantallaBatalla implements Screen {

    private SpriteBatch b;
    private int ancho=200, alto=30;
    private Imagen fondo, chalm, agumon, gabumon, devilmon, mileniummon, omnimon;
    private Texto statsCompa,statsEnemigo,menu,aux, accionEnemigo, accionCompa;
    private Texto descripcion;
    private EntradaBatalla entrada = new EntradaBatalla(this);
    private boolean flag, flag2 = false;
    private Stage stage;
    private static Compa compa;
    private static Entrenador entrenador;
    private static Enemigo enemigo;
    public List<Turno> log = new ArrayList<>();
    private int turno = 0;
    public float tiempo;
    private Music musica;
    private static boolean isAgumon;
    int op;
    int danio = 0;
    int danio2 = 0;
    int accion2 = 0;
    int accion = 0;
    Random random = new Random();

    public static boolean isAgumon() {
        return isAgumon;
    }

    public static void setAgumon(boolean agumon) {
        isAgumon = agumon;
    }

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
        PantallaMapa1.turnOff();
        musica= Gdx.audio.newMusic(Gdx.files.internal(Recursos.MUSICABATALLA));
        b= Render.batch;

        descripcion=new Texto(Recursos.FUENTE1,30, Color.ORANGE,true);
        descripcion.setPosition(80,150);
        if(enemigo.getNombre().equals("Omnimon")){
            descripcion.setTexto("Te enseñaré lo básico que debés saber para el combate\nPRESIONA ESPACIO PARA INICIAR");
        }


        Gdx.input.setInputProcessor(entrada);
        fondo= new Imagen(Recursos.BATALLA);
        chalm= new Imagen(Recursos.CHALMENEMIGO);
        chalm.setPosition(800, 400);
        chalm.setSize(275, 325);



        devilmon= new Imagen(Recursos.DEVILMON2);
        devilmon.setPosition(850, 450);

        mileniummon= new Imagen(Recursos.MILENIUMMON2);
        mileniummon.setPosition(850, 400);
        mileniummon.setSize(300, 300);

        agumon= new Imagen(Recursos.AGUMON2);
        agumon.setPosition(250, 230);
        agumon.setSize(300,300);

        omnimon= new Imagen(Recursos.OMNIMON2);
        omnimon.setPosition(250, 230);
        omnimon.setSize(300,300);

        gabumon = new Imagen(Recursos.GABUMON2);
        gabumon.setPosition(250, 230);
        gabumon.setSize(300,300);




        aux=new Texto(Recursos.FUENTE1,40, Color.ORANGE,true);
        aux.setTexto("");
        aux.setPosition(80,120);

        menu=new Texto(Recursos.FUENTE1,40,Color.ORANGE,true);
        menu.setPosition(850,170);
        menu.setTexto("");

        statsCompa=new Texto(Recursos.FUENTE1,30, Color.ORANGE,true);
        statsCompa.setPosition(650, 330);
        statsCompa.setTexto(compa.getNombre() + " \nHP: " + compa.getVida() + "\nMP: " + compa.getMana());

        accionCompa = new Texto(Recursos.FUENTE1, 30, Color.GREEN, true);
        accionCompa.setPosition(800, 300);
        accionCompa.setTexto("");

        statsEnemigo=new Texto(Recursos.FUENTE1,30, Color.ORANGE,true);
        statsEnemigo.setPosition(50, 650);
        statsEnemigo.setTexto("Chalm \nHP: " + enemigo.getHp() + "\nMP: " + enemigo.getMp());

        accionEnemigo = new Texto(Recursos.FUENTE1, 30, Color.RED, true);
        accionEnemigo.setPosition(180, 615);
        accionEnemigo.setTexto("");


    }

    private void menu() {
        menu.dibujar();
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            if(enemigo.getHp() > 0 && compa.getVida() > 0){
                descripcion.setTexto("Combate iniciado: " + compa.getNombre() + " vs " + enemigo.getNombre());
            }
            if ((!flag2)) {
                if(entrenador.mochila.getListaBolsillo().isEmpty()){
                    accion = random.nextInt(4);
                }else{
                    accion = random.nextInt(5);
                }
                switch (accion) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        menu.setTexto("Presione Espacio\nPara continuar");

                        //-----------------TURNO PLAYER------------------\\
                        flag = false;
                        danio = enemigo.getDanioRecibido(compa.habilidadAtaque(compa.habilidades[accion]));
                        if (compa.verificarMana(compa.habilidades[accion])) {
                            compa.setMana(compa.getMana() - compa.habilidades[accion].getCostoMP());
                            enemigo.golpeRematador(danio);
                        } else {
                            flag = true;
                        }
                        if (danio == 0) {
                            accionCompa.setTexto("Has fallado");
                        } else {
                            accionCompa.setTexto("Has lanzado\n" + compa.habilidades[accion].getNombre());
                        }
                        if (flag) {
                            accionCompa.setTexto("No tienes sufiente MP ");
                            danio = enemigo.getDanioRecibido(compa.habilidadAtaque(compa.habilidades[accion]));
                            enemigo.golpeRematador(danio);
                        }
                        if (accion == 0) {
                            compa.regenerarMP();
                        }
                        log.add(new Turno(compa.getNombre(), enemigo.getNombre(), danio, turno, compa.habilidades[accion].getNombre()));
                        break;
                    case 4:
                        op = compa.elegirItem(entrenador.getMochila());
                        if (op != -1) {
                            accionCompa.setTexto("Has Utilizado: " + entrenador.mochila.getBolsillos(op).getItem().getDescEfecto());
                            log.add(new Turno(compa.getNombre(), turno, entrenador.mochila.getBolsillos(op).getItem()));
                            entrenador.mochila.getBolsillos(op).usar(compa, op);
                        }
                        break;
                }

                //prints\\
                statsEnemigo.setTexto(enemigo.getNombre() + " \nHP: " + enemigo.getHp() + "\nMP: " + enemigo.getMp());
                statsCompa.setTexto(compa.getNombre() + " \nHP: " + compa.getVida() + "\nMP: " + compa.getMana());



                //------------------TURNO BOT----------------------\\
                accion2 = enemigo.botEnemigo();
                danio2 = compa.getDanioRecibido(enemigo.habilidadAtaque(enemigo.habilidades[accion2]));
                enemigo.setMp(enemigo.getMp() - enemigo.habilidades[accion2].getCostoMP());
                compa.golpeRematador(danio2);
                log.add(new Turno(enemigo.getNombre(), compa.getNombre(), danio2, turno, enemigo.habilidades[accion2].getNombre()));
                if (danio2 == 0) {
                    accionEnemigo.setTexto("El Enemigo ha fallado");
                } else {
                    accionEnemigo.setTexto("El enemigo ha lanzado \n" + enemigo.habilidades[accion2].getNombre());
                }
                if (accion2 == 0) {
                    enemigo.regenerarMP();
                }
                //prints\\
                statsEnemigo.setTexto(enemigo.getNombre() + " \nHP: " + enemigo.getHp() + "\nMP: " + enemigo.getMp());
                statsCompa.setTexto(compa.getNombre() + " \nHP: " + compa.getVida() + "\nMP: " + compa.getMana());
                System.out.println(log.get(turno).toString());
                turno++;

                if (enemigo.getHp() == 0) {
                    descripcion.setTexto("Has ganado la batalla\nPresiona Escape para volver");
                    menu.setTexto("");
                    flag2 = true;
                }
                if (compa.getVida() == 0) {
                    descripcion.setTexto("Has perdido la batalla\nPresiona Escape para volver");
                    menu.setTexto("");
                    flag2 = true;
                }

            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE) && flag2 && enemigo.getNombre().equals("Omnimon")) {
            compa.regenerar();
            setEntrenador(PantallaCreacion.itemKeys);
            musica.stop();
            Render.app.setScreen(new PantallaLaboratorio2());
        }

         if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE) && flag2 && enemigo.getNombre().equals("Devilmon")) {
            compa.regenerar();
            setEntrenador(PantallaCreacion.itemKeys);
            musica.stop();
            Render.app.setScreen(new PantallaMapa3());
        }

         if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE) && flag2 && enemigo.getNombre().equals("Mileniummon")) {
            compa.regenerar();
            setEntrenador(PantallaCreacion.itemKeys);
            musica.stop();
            Render.app.setScreen(new PantallaLaboratorio3());
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE) && flag2 && enemigo.getNombre().equals("Milenniummon") && compa.getNombre().equals("Omnimon")) {
            compa.regenerar();
            setEntrenador(PantallaCreacion.itemKeys);
            musica.stop();
            Render.app.setScreen(new PantallaLaboratorio3()); //créditos
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

        if(enemigo.getNombre().equals("Omnimon")){
            chalm.dibujar();
        }

       if(enemigo.getNombre().equals("Mileniummon")){
            mileniummon.dibujar();
        }
       if(enemigo.getNombre().equals("Devilmon")){
            devilmon.dibujar();
        }
       if(compa.getNombre().equals("Omnimon")){
           omnimon.dibujar();
       }
       else{
           if(isAgumon()){
               agumon.dibujar();
           }
           else{
               gabumon.dibujar();
           }
        }
        menu();
        accionCompa.dibujar();
        accionEnemigo.dibujar();
        descripcion.dibujar();
        statsCompa.dibujar();
        statsEnemigo.dibujar();
        b.end();
    }


    private void poner(Actor a){
        stage.addActor(a);
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
