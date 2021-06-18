package com.mygdx.game.Pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Elementos.ColisionMapa;
import com.mygdx.game.Elementos.Imagen;
import com.mygdx.game.Elementos.Personaje;
import com.mygdx.game.Elementos.Texto;
import com.mygdx.game.Utiles.Recursos;
import com.mygdx.game.Utiles.Render;

import java.lang.invoke.MutableCallSite;


public class PantallaMapa1 extends Stage implements Screen {

    private SpriteBatch b;
    private Personaje crisEspalda,crisFrente,crisIzq,crisDer;
    private TextureRegion quieto;
    private float xActual=10;
    private float yActual=229;
    private Texto frase, zona;
    private int op=4;
    private static Music NecoMusic, puerta;
    private Imagen mapa,nombreM;
    private float cont=0;
    private Rectangle personaje;
    private ColisionMapa colision1,colision2,colision3,colision4,colision5,colision6,colision7,colision8,colision9,
            colision10,colision11,colision12,colision13,colision14,colision15,colision16,colision17;


    public static void turnOff(){
        NecoMusic.stop();
    }


    @Override
    public void show() {
        b = Render.batch;

        NecoMusic= Gdx.audio.newMusic(Gdx.files.internal(Recursos.MUSICANECOCITY));
        //puerta= Gdx.audio.newMusic(Gdx.files.internal(Recursos.PUERTASONIDO));

        mapa= new Imagen(Recursos.MAPA);
        nombreM= new Imagen(Recursos.NOMBRE_MAPA);
        nombreM.setPosition(30,670);
        nombreM.setSize(150,15);
        zona = new Texto(Recursos.FUENTE1,40, Color.WHITE,true);
        zona.setTexto("NecoCity()");
        zona.setPosition(550, 700);

        /**SETEO DE PERSONAJE*/
        crisEspalda = new Personaje(Recursos.HERO_M_ESPALDA,3,0.1f);
        crisFrente  = new Personaje(Recursos.HERO_M_FRENTE,3,0.1f);
        crisIzq  = new Personaje(Recursos.HERO_M_IZQ,3,0.1f);
        crisDer  = new Personaje(Recursos.HERO_M_DER,3,0.1f);
        quieto = new TextureRegion();
        frase=new Texto(Recursos.FUENTE1,13, Color.WHITE,false);


        /**SETEO DE RECTANGULO DE COLISION PARA PERSONAJE*/
        personaje=new Rectangle();
        personaje.width=1;
        personaje.height=1;


        /**GENERANDO LAS COLISIONES*/
        colision1 = new ColisionMapa(-100,0,130,219);
        colision2 = new ColisionMapa(52,27,230,192);
        colision3 = new ColisionMapa(-26,251,142,316);
        colision4 = new ColisionMapa(116,567,114,134);
        colision5 = new ColisionMapa(224,249,762,318);
        colision6 = new ColisionMapa(310,29,195,190);
        colision7 = new ColisionMapa(535,29,190,190);
        colision8 = new ColisionMapa(760,29,230,190);
        colision9 = new ColisionMapa(990,29,110,95);
        colision10 = new ColisionMapa(1135,-6,105,125);
        colision11 = new ColisionMapa(1025,159,180,160);
        colision12 = new ColisionMapa(1000,340,91,380);
        colision13 = new ColisionMapa(-12,0,2,720);
        colision14 = new ColisionMapa(0,-1,1280,2);
        colision15 = new ColisionMapa(1238,0,2,720);
        colision16 = new ColisionMapa(1115,340,165,380);
        colision17 = new ColisionMapa(1092,450,15,40);
    }

    @Override
    public void render(float delta) {
        cont+=delta/8;
        Render.limpiarPantalla(0, 0, 0);
        b.begin();
        NecoMusic.setVolume(0.3f);
        NecoMusic.play();
        mapa.dibujar();
        zona.dibujar();
        nombreM.fadeOutImagen(nombreM,cont);
        personaje.setPosition(xActual,yActual);
        colision();
        cambioMapa();
        mapaBosque();
        b.end();
    }

    private void cambioMapa(){
        if(personaje.overlaps(colision17)){
            dispose();
            Render.app.setScreen(new PantallaLaboratorio());
        }
    }



    private void mapaBosque(){
        if(personaje.overlaps(colision4)){
            Render.app.setScreen(new PantallaBosque());
        }
    }



    private void colision() {
        if(personaje.overlaps(colision1) || personaje.overlaps(colision2) || personaje.overlaps(colision3) || personaje.overlaps(colision5) ||
                personaje.overlaps(colision6)|| personaje.overlaps(colision7) || personaje.overlaps(colision8)|| personaje.overlaps(colision9) || personaje.overlaps(colision10)
                || personaje.overlaps(colision12)|| personaje.overlaps(colision11 )|| personaje.overlaps(colision13)|| personaje.overlaps(colision14 )|| personaje.overlaps(colision15)||personaje.overlaps(colision16)){
            quietoS();
            switch (op){
                case 1:
                    movIzq();
                    movDer();
                    movAbajo();
                    break;
                case 2:
                    movIzq();
                    movDer();
                    movArriba();
                    break;
                case 3:
                    movDer();
                    movArriba();
                    movAbajo();
                    break;
                case 4:
                    movIzq();
                    movArriba();
                    movAbajo();
                    break;
            }
        }
        else {
            moverse();
        }
    }

    private void movArriba() {
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
        crisEspalda.setX(xActual);
        crisEspalda.setY(yActual + 5);
        crisEspalda.render(b);
        yActual = crisEspalda.getY();
        op=1;
        }
    }

    private void movAbajo() {
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
        crisEspalda.setX(xActual);
        crisEspalda.setY(yActual - 5);
        crisEspalda.render(b);
        yActual = crisEspalda.getY();
        op=2;
        }
    }

    private void movIzq() {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            crisIzq.setX(xActual - 5);
            crisIzq.setY(yActual);
            crisIzq.render(b);
            xActual = crisIzq.getX();
            op = 3;
        }
    }

    private void movDer(){
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            crisDer.setX(xActual + 5);
            crisDer.setY(yActual);
            crisDer.render(b);
            xActual = crisDer.getX();
            op = 4;
        }
    }

    private void quietoS(){
        switch (op) {
            case 0:
            case 1:
                quieto = crisEspalda.personajeEspera();
                b.draw(quieto, xActual, yActual);
                break;
            case 2:
                quieto = crisFrente.personajeEspera();
                b.draw(quieto, xActual, yActual);
                break;
            case 3:
                quieto = crisIzq.personajeEspera();
                b.draw(quieto, xActual, yActual);
                break;
            case 4:
                quieto = crisDer.personajeEspera();
                b.draw(quieto, xActual, yActual);
                break;
        }
    }

    private void moverse(){
            int veloc = 3;
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                crisEspalda.setX(xActual);
                crisEspalda.setY(yActual + veloc);
                crisEspalda.render(b);
                yActual = crisEspalda.getY();
                op = 1;
            } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                crisFrente.setX(xActual);
                crisFrente.setY(yActual - veloc);
                crisFrente.render(b);
                yActual = crisFrente.getY();
                op = 2;
            } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                crisIzq.setX(xActual - veloc);
                crisIzq.setY(yActual);
                crisIzq.render(b);
                xActual = crisIzq.getX();
                op = 3;
            } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                crisDer.setX(xActual + veloc);
                crisDer.setY(yActual);
                crisDer.render(b);
                xActual = crisDer.getX();
                op = 4;
            }else{
                switch (op) {
                    case 0:
                    case 1:
                        quieto = crisEspalda.personajeEspera();
                        b.draw(quieto, xActual, yActual);
                        break;
                    case 2:
                        quieto = crisFrente.personajeEspera();
                        b.draw(quieto, xActual, yActual);
                        break;
                    case 3:
                        quieto = crisIzq.personajeEspera();
                        b.draw(quieto, xActual, yActual);
                        break;
                    case 4:
                        quieto = crisDer.personajeEspera();
                        b.draw(quieto, xActual, yActual);
                        break;
                }
            }
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


