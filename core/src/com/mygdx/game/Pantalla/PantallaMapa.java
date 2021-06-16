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
    private Personaje heroEspalda,heroFrente,heroIzq,heroDer;
    private TextureRegion quieto;
    private TextureRegion quietoH;
    private float xActual=37;
    private float yActual=97;
    private float xActualH=xActual;
    private float yActualH=yActual-60;
    private Texto frase;
    private int op=0;
    private Imagen mapa;


    @Override
    public void show() {
        b = Render.batch;
        Gdx.input.setInputProcessor(entada);

        mapa= new Imagen(Recursos.MAPA);

        crisEspalda = new Personaje(Recursos.CRIS_ESPALDA,3,0.1f);
        crisFrente  = new Personaje(Recursos.CRIS_FRENTE,3,0.1f);
        crisIzq  = new Personaje(Recursos.CRIS_IZQ,3,0.1f);
        crisDer  = new Personaje(Recursos.CRIS_DER,3,0.1f);
        quieto = new TextureRegion();
        frase=new Texto(Recursos.FUENTE1,13, Color.WHITE,false);

        heroEspalda  = new Personaje(Recursos.HERO_M_ESPALDA,3,0.1f);
        heroFrente  = new Personaje(Recursos.HERO_M_FRENTE,3,0.1f);
        heroIzq  = new Personaje(Recursos.HERO_M_IZQ,3,0.1f);
        heroDer  = new Personaje(Recursos.HERO_M_DER,3,0.1f);
        quietoH = new TextureRegion();
    }

    @Override
    public void render(float delta) {

        Render.limpiarPantalla(1, 1, 1);
        b.begin();
        mapa.dibujar();
        moverse();
        //quietoH=heroFrente.personajeEspera();
        //b.draw(quietoH,200,200);
        //colision();
        System.out.println("x:" + xActual + "y:" + yActual);
        b.end();
    }

    private void colision(){
        if (xActual==198 || yActual==198){
            Render.app.setScreen(new PantallaBatalla());
        }
    }

    private void moverse(){
        if (entada.isArriba()){
            crisEspalda.setX(xActual);
            crisEspalda.setY(yActual+2);
            crisEspalda.render(b);
            yActual= crisEspalda.getY();

           /* heroEspalda.setX(xActualH);
            heroEspalda.setY(yActualH+1);
            heroEspalda.render(b);
            yActualH=heroEspalda.getY();*/
            op=1;
        }

        else if (entada.isAbajo()){
            crisFrente.setX(xActual);
            crisFrente.setY(yActual-2);
            crisFrente.render(b);
            yActual=crisFrente.getY();

            /*heroFrente.setX(xActualH);
            heroFrente.setY(yActualH-1);
            heroFrente.render(b);
            yActualH=heroFrente.getY();*/
            op=2;
        }
        else if (entada.isIzquierda()){
            crisIzq.setX(xActual-2);
            crisIzq.setY(yActual);
            crisIzq.render(b);
            xActual=crisIzq.getX();

           /*heroIzq.setX(xActualH-1);
            heroIzq.setY(yActualH);
            heroIzq.render(b);
            xActualH=heroIzq.getX();*/
            op=3;
        }
        else if (entada.isDerecha()){
            crisDer.setX(xActual+2);
            crisDer.setY(yActual);
            crisDer.render(b);
            xActual=crisDer.getX();

            /*heroDer.setX(xActualH+1);
            heroDer.setY(yActualH);
            heroDer.render(b);
            xActualH=heroDer.getX();*/

            op=4;
        }
        else if(entada.isLetraE()){
            frase.setPosition(xActual+65,yActual+57);
            frase.setTexto("Donde va el padre,\nva el hijo.");
            quieto=crisFrente.personajeEspera();
            b.draw(quieto,xActual,yActual);
            frase.dibujar();
        }
        else{
            switch (op){
                case 0:
                case 1:
                    quieto= crisEspalda.personajeEspera();
                    b.draw(quieto,xActual,yActual);

                    //quietoH=heroEspalda.personajeEspera();
                    //b.draw(quietoH,xActualH,yActualH);
                    break;
                case 2:
                    quieto=crisFrente.personajeEspera();
                    b.draw(quieto,xActual,yActual);

                    //quietoH=heroFrente.personajeEspera();
                    //b.draw(quietoH,xActualH,yActualH);
                    break;
                case 3:
                    quieto=crisIzq.personajeEspera();
                    b.draw(quieto,xActual,yActual);

                    //quietoH=heroIzq.personajeEspera();
                    //b.draw(quietoH,xActualH,yActualH);
                    break;
                case 4:
                    quieto=crisDer.personajeEspera();
                    b.draw(quieto,xActual,yActual);

                    //quietoH=heroDer.personajeEspera();
                    //b.draw(quietoH,xActualH,yActualH);
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


