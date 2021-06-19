package com.mygdx.game.Pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Elementos.Imagen;
import com.mygdx.game.Utiles.Config;
import com.mygdx.game.Utiles.Recursos;
import com.mygdx.game.Utiles.Render;


public class PantallaCarga implements Screen {
    private Imagen fondo;
    private Imagen studio;
    private SpriteBatch b;
    private boolean fadeInTerminado=false, termina=false;
    private float a=0;
    private float contTiempo=0,contTiempoEspera=5;
    private float contTiempoTermina=0,tiempoTermina=5;
    private Music musica;

    @Override
    public void show() {
        musica= Gdx.audio.newMusic(Gdx.files.internal(Recursos.MUSICAINTRO));
        fondo = new Imagen(Recursos.FONDO);
        studio = new Imagen(Recursos.CARGA);
        fondo.setSize(Config.ANCHO,Config.ALTO);
        studio.setSize(Config.ANCHO,Config.ALTO);
        b= Render.batch;
        fondo.setTransparencia(a);
        studio.setTransparencia(a);

    }

    @Override
    public void render(float delta) {
        Render.limpiarPantalla(0,0,0);
        b.begin();
        fondo.dibujar();
        studio.dibujar();
        b.end();
        musica.setVolume(0.3f);
        musica.play();
        procesarFade();

    }

    private void procesarFade() {
        if(!fadeInTerminado){
            a+=0.004f;
            if(a>1){
                a=1;
                fadeInTerminado=true;
            }
        }
        else{
            contTiempo+=0.1f;
            if (contTiempo>contTiempoEspera){
                a-=0.01f;
                if(a<0) {
                    a = 0;
                    termina=true;
                }
            }

        }
        fondo.setTransparencia(a);
        studio.setTransparencia(a);
        if (termina){
            contTiempoTermina+=0.1f;
            if(contTiempoTermina>tiempoTermina){
                musica.stop();
                Render.app.setScreen(new PantallaMenu());
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
