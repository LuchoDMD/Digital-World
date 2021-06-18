package com.mygdx.game.Pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Elementos.Imagen;
import com.mygdx.game.Elementos.Personaje;
import com.mygdx.game.Eventos.EntradaMovimiento;
import com.mygdx.game.Utiles.Recursos;
import com.mygdx.game.Utiles.Render;

public class PantallaLaboratorio implements Screen {
    private SpriteBatch b;
    private Imagen laboratorio;
    private TextureRegion quieto;
    private float cont=0;
    private EntradaMovimiento entada = new EntradaMovimiento(this);
    private Personaje crisEspalda,crisFrente,crisIzq,crisDer;
    private float xActual=638;
    private float yActual=300;
    private int op=0;


    @Override
    public void show() {
       b= Render.batch;
        Gdx.input.setInputProcessor(entada);
       laboratorio = new Imagen(Recursos.LABORATORIO);

        crisEspalda = new Personaje(Recursos.CRIS_ESPALDA,3,0.1f);
        crisFrente  = new Personaje(Recursos.CRIS_FRENTE,3,0.1f);
        crisIzq  = new Personaje(Recursos.CRIS_IZQ,3,0.1f);
        crisDer  = new Personaje(Recursos.CRIS_DER,3,0.1f);
        quieto = new TextureRegion();

    }

    @Override
    public void render(float delta) {
        Render.limpiarPantalla(0,0,0);
        cont+=delta/2;
        b.begin();
        laboratorio.fadeInImagen(laboratorio,cont);
        laboratorio.dibujar();
        ponerEnMapa();
        b.end();
    }


    private void ponerEnMapa(){
        quieto=crisFrente.personajeEspera();
        b.draw(quieto,xActual,yActual);
    }

    private void movArriba() {
            crisEspalda.setX(xActual);
            crisEspalda.setY(yActual + 2);
            crisEspalda.render(b);
            yActual = crisEspalda.getY();
        }

    private void movAbajo() {

            crisEspalda.setX(xActual);
            crisEspalda.setY(yActual - 2);
            crisEspalda.render(b);
            yActual = crisEspalda.getY();
    }

    private void movIzq() {
            crisIzq.setX(xActual - 2);
            crisIzq.setY(yActual);
            crisIzq.render(b);
            xActual = crisIzq.getX();
    }

    private void movDer(){
            crisDer.setX(xActual + 2);
            crisDer.setY(yActual);
            crisDer.render(b);
            xActual = crisDer.getX();
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
