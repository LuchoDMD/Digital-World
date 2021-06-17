package com.mygdx.game.Pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.Elementos.GifDecoder;
import com.mygdx.game.Elementos.Imagen;
import com.mygdx.game.Elementos.Texto;
import com.mygdx.game.Eventos.EntradaMovimiento;
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
    private Imagen dialogo;
    private EntradaMovimiento entrada = new EntradaMovimiento(this);
    private ImageButton flechaDer,flechaIzq;
    private Skin skin;
    private Stage stage;
    private Texture flechaD, flechaI;
    private int op=0;

    @Override
    public void show() {


        lluvia= Gdx.audio.newMusic(Gdx.files.internal(Recursos.LLUVIA));
        rayo= Gdx.audio.newMusic(Gdx.files.internal(Recursos.RAYO));
        skin=new Skin(Gdx.files.internal("Skin/uiskin.json"));
        stage=new Stage();

        Gdx.input.setInputProcessor(stage);

        flechaD=new Texture(Recursos.FLECHADER);
        flechaI=new Texture(Recursos.FLECHAIZQ);
        TextureRegion textFlechaD=new TextureRegion(flechaD,141,138);
        TextureRegion textFlechaI=new TextureRegion(flechaI,141,138);
        TextureRegionDrawable textDrawD = new TextureRegionDrawable(textFlechaD);
        TextureRegionDrawable textDrawI = new TextureRegionDrawable(textFlechaI);

        flechaDer = new ImageButton(textDrawD);
        flechaIzq = new ImageButton(textDrawI);
        flechaDer.setSize(55,55);
        flechaIzq.setSize(55,55);
        flechaDer.setPosition(1110,10);
        flechaIzq.setPosition(flechaDer.getX()-flechaDer.getWidth(),10);
        poner(flechaDer);
        poner(flechaIzq);



        animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(Recursos.INTRODUCCION_FONDO).read());
        b=Render.batch;

        historia=new Texto(Recursos.FUENTE1,29, Color.ORANGE,true);
        historia.setTexto(Recursos.INTRODUCCION);
        historia.setPosition(35,155);


        dialogo=new Imagen(Recursos.DIALOGO);
        dialogo.setPosition(0,0);
        dialogo.setSize(Config.ANCHO,180);
    }


    private void poner(Actor a){
        stage.addActor(a);
    }

    private void transicionTexto(){

        /**BOTON DERECHA*/
        if (op==1 && historia.getTexto().equals(Recursos.INTRODUCCION)){
            historia.setTexto(Recursos.INTRODUCCION1);
            op=0;
        }
        if (op==1 && historia.getTexto().equals(Recursos.INTRODUCCION1)){
            historia.setTexto(Recursos.INTRODUCCION2);
            op=0;
        }
        if (op==1 && historia.getTexto().equals(Recursos.INTRODUCCION2)){
            historia.setTexto(Recursos.INTRODUCCION3);
            op=0;
        }
        if (op==1 && historia.getTexto().equals(Recursos.INTRODUCCION3)){
            lluvia.stop();
            rayo.stop();
            Render.app.setScreen(new PantallaCreacion());
            rayo.stop();
            lluvia.stop();
        }

        /**BOTON IZQUIERDA*/

        if (op==2 && historia.getTexto().equals(Recursos.INTRODUCCION1)){
            historia.setTexto(Recursos.INTRODUCCION);
            op=0;
        }
        if (op==2 && historia.getTexto().equals(Recursos.INTRODUCCION2)){
            historia.setTexto(Recursos.INTRODUCCION1);
            op=0;
        }
        if (op==2 && historia.getTexto().equals(Recursos.INTRODUCCION3)){
            historia.setTexto(Recursos.INTRODUCCION2);
            op=0;
        }
    }

    private void botonFlechaDer(){
        flechaDer.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                op=1;
            }
        });
    }

    private void botonFlechaIzq(){
        flechaIzq.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                op=2;
            }
        });
    }



    @Override
    public void render(float delta) {
        trancicion+=0.7f;
        Render.limpiarPantalla(1,1,1);
        elapsed += Gdx.graphics.getDeltaTime();
        b.begin();
        dialogo.dibujar();
        lluvia.play();
        lluvia.setVolume(0.3f);
        b.draw(animation.getKeyFrame(elapsed),0,180, Config.ANCHO,Config.ALTO-180);
        historia.dibujar();
        if (trancicion>350){rayo.play();rayo.setVolume(0.8F);}
        stage.act();
        botonFlechaDer();
        botonFlechaIzq();
        transicionTexto();
        stage.draw();
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
