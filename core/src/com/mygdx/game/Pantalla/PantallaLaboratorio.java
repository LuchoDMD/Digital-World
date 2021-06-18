package com.mygdx.game.Pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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

public class PantallaLaboratorio implements Screen {
    private SpriteBatch b;
    private Imagen laboratorio;
    private TextureRegion quieto,quietoH;
    private float cont=0;
    private EntradaMovimiento entada = new EntradaMovimiento(this);
    private Personaje heroEspalda,heroFrente,heroIzq,heroDer,crisFrente;
    private float xActual=638;
    private float yActual=70;
    private int op=0, op1=0;
    private Imagen dialogo;
    private Texto texto;



    @Override
    public void show() {
       b= Render.batch;
        Gdx.input.setInputProcessor(entada);
       laboratorio = new Imagen(Recursos.LABORATORIO);
        dialogo=new Imagen(Recursos.DIALOGO);
        dialogo.setSize(1280,150);
        heroEspalda = new Personaje(Recursos.HERO_M_ESPALDA,3,0.1f);
        heroFrente  = new Personaje(Recursos.HERO_M_FRENTE,3,0.1f);
        crisFrente  = new Personaje(Recursos.CRIS_FRENTE,3,0.1f);
        heroIzq  = new Personaje(Recursos.HERO_M_IZQ,3,0.1f);
        heroDer  = new Personaje(Recursos.HERO_M_DER,3,0.1f);
        quietoH=new TextureRegion();
        quieto = new TextureRegion();
        texto=new Texto(Recursos.FUENTE1,30, Color.ORANGE,true);
        texto.setTexto(Recursos.DIALOGO_CHALM);
        texto.setPosition(50,120);
    }

    @Override
    public void render(float delta) {
        Render.limpiarPantalla(0,0,0);
        cont+=delta/2;
        b.begin();
        laboratorio.fadeInImagen(laboratorio,cont);
        laboratorio.dibujar();
        personaje();
        ponerEnMapa();
        b.end();
    }

    private void ponerEnMapa(){
        quieto=crisFrente.personajeEspera();
        b.draw(quieto,638,300);
    }

    private void personaje(){
        if (yActual<220){
        moverseArriba();}
        else{
            quietoS();
            dialogo.dibujar();
            texto.dibujar();
            transicionTexto();
        }
    }

    private void pasarTextoAdelante(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.E)){
            System.out.println(op1);
            op1=1;
        }
    }

    private void pasarTextoAtras(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.W)){
            op1=2;
        }
    }


    private void transicionTexto(){
        pasarTextoAdelante();
        pasarTextoAtras();

        /**BOTON DERECHA*/
        if (op1==1 && texto.getTexto().equals(Recursos.DIALOGO_CHALM)){
            texto.setTexto(Recursos.DIALOGO_CHALM1);
            op1=0;
        }
        if (op1==1 && texto.getTexto().equals(Recursos.DIALOGO_CHALM1)){
            texto.setTexto(Recursos.DIALOGO_CHALM2);
            op1=0;
        }
        if (op1==1 && texto.getTexto().equals(Recursos.DIALOGO_CHALM2)){
            texto.setTexto(Recursos.DIALOGO_CHALM3);
            op1=0;
        }
        if (op1==1 && texto.getTexto().equals(Recursos.DIALOGO_CHALM3)){
            texto.setTexto(Recursos.DIALOGO_CHALM4);
            op1=0;
        }
        if (op1==1 && texto.getTexto().equals(Recursos.DIALOGO_CHALM4)){
            texto.setTexto(Recursos.DIALOGO_CHALM5);
            op1=0;
        }
        if (op1==1 && texto.getTexto().equals(Recursos.DIALOGO_CHALM5)){
            texto.setTexto(Recursos.DIALOGO_CHALM6);
            op1=0;
        }
        if (op1==1 && texto.getTexto().equals(Recursos.DIALOGO_CHALM6)){
            texto.setTexto(Recursos.DIALOGO_CHALM7);
            op1=0;
        }
        if(op1==1 && texto.getTexto().equals(Recursos.DIALOGO_CHALM7)){
            texto.setTexto("");
            dialogo.setTransparencia(0);
            Render.app.setScreen(new PantallaMapaDestruida());
        }

        /**BOTON IZQUIERDA*/

        if (op1==2 && texto.getTexto().equals(Recursos.DIALOGO_CHALM1)){
            texto.setTexto(Recursos.DIALOGO_CHALM);
            op1=0;
        }
        if (op1==2 && texto.getTexto().equals(Recursos.DIALOGO_CHALM2)){
            texto.setTexto(Recursos.DIALOGO_CHALM1);
            op1=0;
        }
        if (op1==2 && texto.getTexto().equals(Recursos.DIALOGO_CHALM3)){
            texto.setTexto(Recursos.DIALOGO_CHALM2);
            op1=0;
        }
        if (op1==2 && texto.getTexto().equals(Recursos.DIALOGO_CHALM4)){
            texto.setTexto(Recursos.DIALOGO_CHALM3);
            op1=0;
        }
        if (op1==2 && texto.getTexto().equals(Recursos.DIALOGO_CHALM5)){
            texto.setTexto(Recursos.DIALOGO_CHALM4);
            op1=0;
        }
        if (op1==2 && texto.getTexto().equals(Recursos.DIALOGO_CHALM6)){
            texto.setTexto(Recursos.DIALOGO_CHALM5);
            op1=0;
        }
        if (op1==2 && texto.getTexto().equals(Recursos.DIALOGO_CHALM7)){
            texto.setTexto(Recursos.DIALOGO_CHALM6);
            op1=0;
        }
    }


    private void quietoS(){
        switch (op) {
            case 0:
            case 1:
                quieto = heroEspalda.personajeEspera();
                b.draw(quieto, xActual, yActual);
                break;
            case 2:
                quieto = heroFrente.personajeEspera();
                b.draw(quieto, xActual, yActual);
                break;
            case 3:
                quieto = heroIzq.personajeEspera();
                b.draw(quieto, xActual, yActual);
                break;
            case 4:
                quieto = heroDer.personajeEspera();
                b.draw(quieto, xActual, yActual);
                break;
        }
    }


    private void moverseArriba(){
        int veloc = 3;
        if (entada.isArriba()) {
            heroEspalda.setX(xActual);
            heroEspalda.setY(yActual + veloc);
            heroEspalda.render(b);
            yActual = heroEspalda.getY();
            op = 1;
        } else if (entada.isAbajo()) {
            heroFrente.setX(xActual);
            heroFrente.setY(yActual - veloc);
            heroFrente.render(b);
            yActual = heroFrente.getY();
            op = 2;
        } else if (entada.isIzquierda()) {
            heroIzq.setX(xActual);
            heroIzq.setY(yActual);
            heroIzq.render(b);
            xActual = heroIzq.getX();
            op = 3;
        } else if (entada.isDerecha()) {
            heroDer.setX(xActual);
            heroDer.setY(yActual);
            heroDer.render(b);
            xActual = heroDer.getX();
            op = 4;
        }
        else{
            switch (op) {
                case 0:
                case 1:
                    quieto = heroEspalda.personajeEspera();
                    b.draw(quieto, xActual, yActual);
                    break;
                case 2:
                    quieto = heroFrente.personajeEspera();
                    b.draw(quieto, xActual, yActual);
                    break;
                case 3:
                    quieto = heroIzq.personajeEspera();
                    b.draw(quieto, xActual, yActual);
                    break;
                case 4:
                    quieto = heroDer.personajeEspera();
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
