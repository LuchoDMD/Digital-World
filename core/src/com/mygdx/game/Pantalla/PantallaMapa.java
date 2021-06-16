package com.mygdx.game.Pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Elementos.Imagen;
import com.mygdx.game.Elementos.Personaje;
import com.mygdx.game.Elementos.Texto;
import com.mygdx.game.Eventos.EntradaMovimiento;
import com.mygdx.game.Utiles.Recursos;
import com.mygdx.game.Utiles.Render;



public class PantallaMapa implements Screen {

    private SpriteBatch b;
    private EntradaMovimiento entada = new EntradaMovimiento(this);
    private Personaje crisEspalda,crisFrente,crisIzq,crisDer;
    private TextureRegion quieto;
    private float xActual=37;
    private float yActual=97;
    private Texto frase;
    private int op=0;
    private Imagen mapa,nombreM;
    private float cont=0;


    @Override
    public void show() {
        b = Render.batch;
        Gdx.input.setInputProcessor(entada);

        mapa= new Imagen(Recursos.MAPA);
        nombreM= new Imagen(Recursos.NOMBRE_MAPA);
        nombreM.setPosition(30,670);
        nombreM.setSize(150,15);


        crisEspalda = new Personaje(Recursos.CRIS_ESPALDA,3,0.1f);
        crisFrente  = new Personaje(Recursos.CRIS_FRENTE,3,0.1f);
        crisIzq  = new Personaje(Recursos.CRIS_IZQ,3,0.1f);
        crisDer  = new Personaje(Recursos.CRIS_DER,3,0.1f);
        quieto = new TextureRegion();
        frase=new Texto(Recursos.FUENTE1,13, Color.WHITE,false);
    }

    @Override
    public void render(float delta) {
        cont+=delta/2;
        Render.limpiarPantalla(1, 1, 1);
        b.begin();
        mapa.dibujar();
        nombreM.dibujar();

        if (cont<1){
            nombreM.setTransparencia(1-cont);
        }

        moverse();
        System.out.println("x:" + xActual + "y:" + yActual);
        System.out.println(delta);
        b.end();
    }

    private void colision(){
        if (xActual==198 || yActual==198){
            Render.app.setScreen(new PantallaBatalla());
        }
    }

    private void moverse(){

            if (entada.isArriba()) {
                crisEspalda.setX(xActual);
                crisEspalda.setY(yActual + 2);
                crisEspalda.render(b);
                yActual = crisEspalda.getY();
                op = 1;
            } else if (entada.isAbajo()) {
                crisFrente.setX(xActual);
                crisFrente.setY(yActual - 2);
                crisFrente.render(b);
                yActual = crisFrente.getY();
                op = 2;
            } else if (entada.isIzquierda()) {
                crisIzq.setX(xActual - 2);
                crisIzq.setY(yActual);
                crisIzq.render(b);
                xActual = crisIzq.getX();
                op = 3;
            } else if (entada.isDerecha()) {
                crisDer.setX(xActual + 2);
                crisDer.setY(yActual);
                crisDer.render(b);
                xActual = crisDer.getX();
                op = 4;
            }
            else if (entada.isLetraE()) {
                frase.setPosition(xActual + 65, yActual + 57);
                frase.setTexto("Donde va el padre,\nva el hijo.");
                quieto = crisFrente.personajeEspera();
                b.draw(quieto, xActual, yActual);
                frase.dibujar();
            } else {
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


