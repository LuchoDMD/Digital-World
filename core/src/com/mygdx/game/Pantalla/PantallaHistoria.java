package com.mygdx.game.Pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Elementos.GifDecoder;
import com.mygdx.game.Elementos.Imagen;
import com.mygdx.game.Elementos.Texto;
import com.mygdx.game.Utiles.Config;
import com.mygdx.game.Utiles.Recursos;
import com.mygdx.game.Utiles.Render;


public class PantallaHistoria implements Screen {

    private Texto historia;
    private SpriteBatch b;
    private float trancicion;
    private Animation<TextureRegion> animation;
    private float elapsed;
    private Music lluvia, rayo;


    @Override
    public void show() {
        lluvia= Gdx.audio.newMusic(Gdx.files.internal(Recursos.LLUVIA));
        rayo= Gdx.audio.newMusic(Gdx.files.internal(Recursos.RAYO));
        animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(Recursos.INTRODUCCION_FONDO).read());
        b=Render.batch;
        historia=new Texto(Recursos.FUENTE1,40, Color.WHITE,true);
        historia.setTexto(Recursos.INTRODUCCION);
    }

    @Override
    public void render(float delta) {
        trancicion+=0.7f;
        Render.limpiarPantalla(1,1,1);
        elapsed += Gdx.graphics.getDeltaTime();
        b.begin();
        lluvia.play();
        lluvia.setVolume(0.3f);
        b.draw(animation.getKeyFrame(elapsed),0,0, Config.ANCHO,Config.ALTO);
        historia.dibujar();
        historia.setPosition(35,trancicion);

        if (trancicion>350){rayo.play();rayo.setVolume(0.8F);}

        if(trancicion>1580){
            Render.app.setScreen(new PantallaCreacion());
            rayo.stop();
            lluvia.stop();
        }
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
