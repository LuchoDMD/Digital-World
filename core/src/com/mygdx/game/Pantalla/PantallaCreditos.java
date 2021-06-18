package com.mygdx.game.Pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Elementos.GifDecoder;
import com.mygdx.game.Elementos.Texto;
import com.mygdx.game.Utiles.Config;
import com.mygdx.game.Utiles.Recursos;
import com.mygdx.game.Utiles.Render;

public class PantallaCreditos implements Screen {
    private SpriteBatch b;
    private Texto credito,postCreditos,gracias;
    private float transicion=0;
    private Animation<TextureRegion> animation;
    private float elapsed;
    private Music creditoM;
    private float cont;

    @Override
    public void show() {
        b= Render.batch;
        animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(Recursos.FONDO_CREDITO).read());
        credito= new Texto(Recursos.FUENTE1,50, Color.WHITE,true);
        credito.setTexto(Recursos.TEXTO_CREDITOS);

        postCreditos= new Texto(Recursos.FUENTE1,50, Color.WHITE,true);
        postCreditos.setTexto(Recursos.TEXTO_POSTCREDITOS);

        gracias= new Texto(Recursos.FUENTE1,50, Color.WHITE,true);
        gracias.setTexto("Goracias Por Jugar");


        creditoM=Gdx.audio.newMusic(Gdx.files.internal(Recursos.CREDITO_MUSICA));
    }

    @Override
    public void render(float delta) {
        Render.limpiarPantalla(1,1,1);
        cont+=delta;
        b.begin();
        elapsed += Gdx.graphics.getDeltaTime();
        b.draw(animation.getKeyFrame(elapsed),0,0, Config.ANCHO,Config.ALTO);
        transicion+=1;
        creditoM.setVolume(0.3f);
        creditoM.play();
        postCreditos.dibujar();
        postCreditos.setPosition(200,transicion);
        if(cont>27){
            credito.setPosition(350,transicion-1750);
        }
        credito.dibujar();
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
