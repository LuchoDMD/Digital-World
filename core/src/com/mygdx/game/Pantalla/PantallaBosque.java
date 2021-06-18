package com.mygdx.game.Pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.App.Carga;
import com.mygdx.game.App.Enemigo;
import com.mygdx.game.Elementos.ColisionMapa;
import com.mygdx.game.Elementos.Imagen;
import com.mygdx.game.Elementos.Personaje;
import com.mygdx.game.Elementos.Texto;
import com.mygdx.game.Utiles.Recursos;
import com.mygdx.game.Utiles.Render;


public class PantallaBosque implements Screen {
    private SpriteBatch b;
    private Imagen fondo;
    private float cont;
    private Personaje heroEspalda,heroFrente,heroIzq,heroDer;
    private TextureRegion quietoH;
    private float xActual=210;
    private float yActual=110;
    private int op;
    private Personaje mileniunmon;
    private Rectangle personaje;
    private ColisionMapa colision1,colision2,colision3,colision4,colision5,colision6,colision7;
    private Texto texto,zona;


    @Override
    public void show() {
        b= Render.batch;
        fondo=new Imagen(Recursos.BOSQUE);
        mileniunmon=new Personaje(950,400,Recursos.MILENIUNMON,5,0.15f);
        heroEspalda = new Personaje(Recursos.HERO_M_ESPALDA,3,0.1f);
        heroFrente  = new Personaje(Recursos.HERO_M_FRENTE,3,0.1f);
        heroIzq  = new Personaje(Recursos.HERO_M_IZQ,3,0.1f);
        heroDer  = new Personaje(Recursos.HERO_M_DER,3,0.1f);
        quietoH=new TextureRegion();

        zona = new Texto(Recursos.FUENTE1,40, Color.WHITE,true);
        zona.setTexto("Bosque();");
        zona.setPosition(550, 700);


        personaje=new Rectangle();
        personaje.width=1;
        personaje.height=1;

        colision1 = new ColisionMapa(100,110,62,300);
        colision2 = new ColisionMapa(258,100,230,135);
        colision3 = new ColisionMapa(162,329,156,450);
        colision4 = new ColisionMapa(318,476,650,200);
        colision5 = new ColisionMapa(385,245,650,96);
        colision6 = new ColisionMapa(162,38,96,72);
        colision7 = new ColisionMapa(903,341,100,200);

        texto=new Texto(Recursos.FUENTE1,15, Color.WHITE,true);
        texto.setPosition(xActual+50,yActual+64);
        texto.setTexto("Parece que\ntengo que pelear");
    }

    @Override
    public void render(float delta) {
        Render.limpiarPantalla(0,0,0);
        cont+=delta/2;
        b.begin();
        fondo.fadeInImagen(fondo,cont);
        fondo.dibujar();
        zona.dibujar();
        personaje.setPosition(xActual,yActual);
        mileniunmon.render(b);
        noPodesEscapar();
        pelea();
        colision();
        b.end();
        System.out.println(xActual+" "+yActual);
    }



    private void moverse(){
        int veloc = 3;
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            heroEspalda.setX(xActual);
            heroEspalda.setY(yActual + veloc);
            heroEspalda.render(b);
            yActual = heroEspalda.getY();
            op = 1;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            heroFrente.setX(xActual);
            heroFrente.setY(yActual - veloc);
            heroFrente.render(b);
            yActual = heroFrente.getY();
            op = 2;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            heroIzq.setX(xActual - veloc);
            heroIzq.setY(yActual);
            heroIzq.render(b);
            xActual = heroIzq.getX();
            op = 3;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            heroDer.setX(xActual + veloc);
            heroDer.setY(yActual);
            heroDer.render(b);
            xActual = heroDer.getX();
            op = 4;
        }
        else{
            switch (op) {
                case 0:
                case 1:
                    quietoH = heroEspalda.personajeEspera();
                    b.draw(quietoH, xActual, yActual);
                    break;
                case 2:
                    quietoH = heroFrente.personajeEspera();
                    b.draw(quietoH, xActual, yActual);
                    break;
                case 3:
                    quietoH = heroIzq.personajeEspera();
                    b.draw(quietoH, xActual, yActual);
                    break;
                case 4:
                    quietoH = heroDer.personajeEspera();
                    b.draw(quietoH, xActual, yActual);
                    break;
            }
        }
    }

    private void noPodesEscapar(){
        if(personaje.overlaps(colision6)){
        texto.dibujar();
        }
    }
    private void pelea(){
        if(personaje.overlaps(colision7)){
            int[] milleniumskills = {15,4,5,6};
            PantallaBatalla.setEnemigo(new Enemigo(99, 1600,1250,80,50,60, "Milleniummon", 75, Carga.cargarHabilidades("Habilidades.json"), milleniumskills));
            Render.app.setScreen(new PantallaBatalla());
        }
    }


    private void colision() {
        if(personaje.overlaps(colision1) || personaje.overlaps(colision2) || personaje.overlaps(colision3) || personaje.overlaps(colision4) || personaje.overlaps(colision5) || personaje.overlaps(colision6)|| personaje.overlaps(colision7)){
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
            heroEspalda.setX(xActual);
            heroEspalda.setY(yActual + 5);
            heroEspalda.render(b);
            yActual = heroEspalda.getY();
            op=1;
        }
    }

    private void movAbajo() {
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            heroFrente.setX(xActual);
            heroFrente.setY(yActual - 5);
            heroFrente.render(b);
            yActual = heroFrente.getY();
            op=2;
        }
    }

    private void movIzq() {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            heroIzq.setX(xActual - 5);
            heroIzq.setY(yActual);
            heroIzq.render(b);
            xActual = heroIzq.getX();
            op = 3;
        }
    }

    private void movDer(){
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            heroDer.setX(xActual + 5);
            heroDer.setY(yActual);
            heroDer.render(b);
            xActual = heroDer.getX();
            op = 4;
        }
    }

    private void quietoS(){
        switch (op) {
            case 0:
            case 1:
                quietoH = heroEspalda.personajeEspera();
                b.draw(quietoH, xActual, yActual);
                break;
            case 2:
                quietoH = heroFrente.personajeEspera();
                b.draw(quietoH, xActual, yActual);
                break;
            case 3:
                quietoH = heroIzq.personajeEspera();
                b.draw(quietoH, xActual, yActual);
                break;
            case 4:
                quietoH = heroDer.personajeEspera();
                b.draw(quietoH, xActual, yActual);
                break;
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
