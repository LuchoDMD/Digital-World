package com.mygdx.game.Pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.App.Entrenador;
import com.mygdx.game.App.Mochila;
import com.mygdx.game.Elementos.Imagen;
import com.mygdx.game.Elementos.Personaje;
import com.mygdx.game.Elementos.Texto;
import com.mygdx.game.Utiles.Config;
import com.mygdx.game.Utiles.Recursos;
import com.mygdx.game.Utiles.Render;




public class PantallaCreacion implements Screen {

    private SpriteBatch b;
    private Personaje agumon,gabumon;
    private Texto texto;
    private Skin skin;
    private Stage stage;
    private String nombre;
    private TextButton ok;
    private TextButton agumonB,gabumonB, masculino, femenino;
    private TextField n;
    private Boolean flag=false, gen=false;
    private Imagen heroeM,heroeF;
    private float trancicion;
    private Entrenador entrenador;
    private Mochila mochila;
    private Imagen fondo;


    @Override
    public void show() {
        fondo = new Imagen(Recursos.FONDO_CREACION);
        mochila=new Mochila();
        entrenador=new Entrenador(mochila);
        stage=new Stage();
        Gdx.input.setInputProcessor(stage);

        skin=new Skin(Gdx.files.internal("Skin/uiskin.json"));



        texto=new Texto(Recursos.FUENTE1,60, Color.ORANGE,true);
        texto.setTexto("Como te identificas?");
        texto.setPosition(Config.ANCHO/2-texto.getAncho()/2,550);



        n= new TextField("",skin);
        n.setPosition(Config.ANCHO/2-n.getWidth()/2,400);


        ok=new TextButton("Aceptar",skin);
        ok.setPosition(n.getX()+n.getWidth()+10,400);
        ok.setHeight(n.getHeight());


        heroeM=new Imagen(Recursos.HERO_M_GRANDE);
        heroeM.setPosition(texto.getX()+140,80);
        heroeM.setSize(200,260);

        heroeF=new Imagen(Recursos.HERO_F_GRANDE);
        heroeF.setPosition(texto.getX()+400,75);
        heroeF.setSize(200,260);

        masculino= new TextButton("MASCULINO",skin);
        masculino.setPosition(heroeM.getX()+50,heroeM.getY()-25);
        masculino.setHeight(n.getHeight());
        poner(masculino);

        femenino= new TextButton("FEMENINO",skin);
        femenino.setPosition(heroeF.getX()+50,heroeF.getY()-20);
        femenino.setHeight(n.getHeight());
        poner(femenino);


        gen=botonMasculino();
        gen=botonFemenino();
        flag=botonAceptar();

        agumon= new Personaje(masculino.getX(),90, Recursos.AGUMON,5,0.15f);
        gabumon= new Personaje(femenino.getX(),90, Recursos.GABUMON,5,0.15f);

        agumonB= new TextButton("AGUMON",skin);
        agumonB.setPosition(agumon.getX()+20,agumon.getY()-30);
        agumonB.setWidth(100);
        agumonB.setHeight(n.getHeight());

        gabumonB= new TextButton("GABUMON",skin);
        gabumonB.setPosition(gabumon.getX()+10,gabumon.getY()-30);
        gabumonB.setWidth(100);
        gabumonB.setHeight(n.getHeight());

        b= Render.batch;
    }

    private void poner(Actor a){
        stage.addActor(a);
    }

    private boolean botonMasculino(){
        masculino.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                texto.setTexto("Ingresa tu Nombre");
                texto.setPosition(Config.ANCHO/2-texto.getAncho()/2,550);
                heroeM.setTransparencia(0);
                heroeF.setTransparencia(0);
                masculino.setVisible(false);
                femenino.setVisible(false);
                poner(ok);
                poner(n);
                gen=true;
            }
        });
        return gen;
    }

    private boolean botonFemenino(){
        femenino.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                texto.setTexto("Ingresa tu Nombre");
                texto.setPosition(Config.ANCHO/2-texto.getAncho()/2,600);
                heroeM.setTransparencia(0);
                heroeF.setTransparencia(0);
                masculino.setVisible(false);
                femenino.setVisible(false);
                poner(ok);
                poner(n);
            }
        });
        return gen;
    }

    private boolean botonAceptar(){
        ok.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                nombre=null;
                nombre = n.getText();
                if (nombre!=null) {
                    entrenador.setNombre(nombre);
                    n.setVisible(false);
                    ok.setVisible(false);
                    if(gen){
                        texto.setTexto("Bienvenido" +" \""+ nombre +"\" "+ "\n¿estas preparado para\nla nueva aventura?.\nSelecciona tu digimon.");
                    }else{
                        texto.setTexto("Bienvenida" +" \""+ nombre +"\" "+ "\n¿estas preparada para\nla nueva aventura?.\nSelecciona tu digimon.");

                    }
                    texto.setPosition(Config.ANCHO/2-texto.getAncho()/2,550);
                    flag=true;
                }
            }
        });
        return flag;
    }

    private void botonAgumon(){
        agumonB.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Render.app.setScreen(new PantallaMapa());
            }
        });
    }

    private void botonGabumon(){
        gabumonB.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                 Render.app.setScreen(new PantallaMapa());
            }
        });
    }

    private void eleccionDigimon(){
        if(flag){
            agumon.render(b);
            gabumon.render(b);
            poner(agumonB);
            poner(gabumonB);
            botonAgumon();
            botonGabumon();
        }
    }



    @Override
    public void render(float delta) {
        trancicion+=1f;
        Render.limpiarPantalla(1,1,1);
        b.begin();
        fondo.dibujar();
        texto.dibujar();
        stage.act();
        stage.draw();
        eleccionDigimon();
        heroeM.dibujar();
        heroeF.dibujar();
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
