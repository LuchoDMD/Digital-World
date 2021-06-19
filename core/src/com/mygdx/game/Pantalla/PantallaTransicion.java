package com.mygdx.game.Pantalla;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Elementos.Imagen;
import com.mygdx.game.Utiles.Recursos;
import com.mygdx.game.Utiles.Render;

public class PantallaTransicion implements Screen {
    private SpriteBatch b;
    private Imagen fondo;
    private float cont;

    @Override
    public void show() {
        b= Render.batch;
        fondo=new Imagen(Recursos.PANTALLA_NEGRA);
    }

    @Override
    public void render(float delta) {
        System.out.println(delta);
        cont+=delta/4;
        Render.limpiarPantalla(1,1,1);
        b.begin();
        fondo.fadeOutImagen(fondo,cont);
        b.end();
        if (cont>0.7f){
            Render.app.setScreen(new PantallaBatalla());
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
