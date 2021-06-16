package com.mygdx.game.Pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.Elementos.Imagen;
import com.mygdx.game.Elementos.Texto;
import com.mygdx.game.Eventos.EntradaBatalla;
import com.mygdx.game.Utiles.Recursos;
import com.mygdx.game.Utiles.Render;


public class PantallaBatalla implements Screen {

    private SpriteBatch b;
    private int ancho=200, alto=30;
    private Imagen fondo;
    private Texto descripcion;
    private EntradaBatalla entada = new EntradaBatalla(this);
    private TextButton luchar,mochila,huir,hab1,hab2,hab3,hab4,atras;
    private Stage stage;
    private Skin skin;


    @Override
    public void show() {

        stage=new Stage();
        Gdx.input.setInputProcessor(stage);
        skin=new Skin(Gdx.files.internal("Skin/uiskin.json"));

        /**-----------------------------------BOTONES DE OPCIONES------------------------------------*/
        luchar= new TextButton("Luchar",skin);
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
        hab1= new TextButton("Habilidad1",skin);
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
        atras.setVisible(false);


        b= Render.batch;
        fondo= new Imagen(Recursos.BATALLA);

        descripcion=new Texto(Recursos.FUENTE1,40, Color.ORANGE,true);
        descripcion.setTexto("¿Que deberia hacer -----?");
        descripcion.setPosition(80,150);

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
    public void render(float delta) {
        Render.limpiarPantalla(1,1,1);
        b.begin();
        fondo.dibujar();
        descripcion.dibujar();
        stage.act();
        stage.draw();
        botonLuchar();
        botonHuir();
        botonAtras();
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
