package com.mygdx.game.Pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.*;
import com.mygdx.game.Elementos.Botones;
import com.mygdx.game.Elementos.GifDecoder;
import com.mygdx.game.Elementos.Texto;
import com.mygdx.game.Eventos.Entrada;
import com.mygdx.game.Utiles.Config;
import com.mygdx.game.Utiles.Recursos;
import com.mygdx.game.Utiles.Render;



public class PantallaMenu implements Screen {
    private Animation<TextureRegion> animation;
    private float elapsed;
    private SpriteBatch b;
    private Texto titulo;
    private Texto o1,o2,o3;
    private Botones botones;
    private Music musica;
    private Entrada entada = new Entrada(this);
    public float tiempo;
    private int cont=0;

    @Override
    public void show() {
        musica= Gdx.audio.newMusic(Gdx.files.internal(Recursos.MUSICAMENU));
        animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(Recursos.CIRCUITOS1).read());
        b= Render.batch;
        botones=new Botones();
        Gdx.input.setInputProcessor(entada);

        titulo=new Texto(Recursos.FUENTE1,70, Color.ORANGE,true);
        titulo.setTexto("Digimon Sol Naranja");
        titulo.setPosition((Config.ANCHO/2f)-(titulo.getAncho()/2),Config.ALTO-100);

        botones.agregarBoton(o1,"Nueva Partida",40,4);
        botones.agregarBoton(o2,"Donar unos Dolares",40,4);
        botones.agregarBoton(o3,"Salir",40,4);
    }


    @Override
    public void render(float delta) {
        elapsed += Gdx.graphics.getDeltaTime();
        b.begin();
        b.draw(animation.getKeyFrame(elapsed),0,0,Config.ANCHO,Config.ALTO);
        titulo.dibujar();
        posicionBotonera();
        musica.setVolume(0.3f);
        musica.play();
        tiempo+=delta;
        accionBotonera();
        b.end();
    }

    public void accionBotonera(){
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

        if(cont==1 && entada.isEnter())
        {
            musica.stop();
            Render.app.setScreen(new PantallaHistoria());
        }

        if(cont==3 && entada.isEnter()){
            b.dispose();
        }


        for (int i=0; i<botones.getBotones().size();i++){
            if(i==(cont-1)){
                botones.getBotones().get(i).setColor(Color.ORANGE);
            }else{
                botones.getBotones().get(i).setColor(Color.WHITE);
            }
        }
    }

    public void posicionBotonera(){
        float dist=60;
        float i=0;
        float posInY=(Config.ALTO/2f)-(botones.getBotones().get(0).getAlto()/2-50);
        for (Texto aux:botones.getBotones()){
            aux.setPosition((Config.ANCHO/2f)-(aux.getAncho()/2),posInY-dist*i);
            aux.dibujar();
            i++;
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
