package com.mygdx.game.Pantalla;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Elementos.Imagen;
import com.mygdx.game.Elementos.Texto;
import com.mygdx.game.Utiles.Recursos;
import com.mygdx.game.Utiles.Render;


public class PantallaHistoria implements Screen {

    private Texto historia;
    private Imagen fondo;
    private SpriteBatch b;
    private float trancicion;


    @Override
    public void show() {
        b=Render.batch;
        historia=new Texto(Recursos.FUENTE1,50, Color.BLACK,false);
        historia.setTexto("Inicias tu aventura seleccionando \na tu compañero Digimon y habiendolo\nbautizado con un hermoso nombre.\n" +
                "Tu deber como entrenador  \nes derrotar a todos tus enemigos \npara alzarte con la victoria.\n" +
                "La aventura comienza ahora!\nCuidado con las fuerzas malignas \ndel general Peron!.");

        //fondo=new Imagen();

    }

    @Override
    public void render(float delta) {
        trancicion+=1f;
        Render.limpiarPantalla(1,1,1);
        b.begin();
        //fondo.dibujar();
        historia.dibujar();
        historia.setPosition(70,trancicion);
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
