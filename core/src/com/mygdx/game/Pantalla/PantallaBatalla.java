package com.mygdx.game.Pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.App.Habilidad;
import com.mygdx.game.Utiles.Config;
import com.mygdx.game.Utiles.Render;
import java.util.HashMap;
import java.util.Map;

public class PantallaBatalla implements Screen {

    private SpriteBatch b;
    private TextButton luchar, mochila, huir;
    private Stage stage;
    private Skin skin;
    private float ancho=90;

    Map<Integer, Habilidad> habilidades = new HashMap<>();


    @Override
    public void show() {

        habilidades.put(1, new Habilidad(100, 95, 20, "Ataque Relámpago"));
        habilidades.put(2, new Habilidad(70, 100, 15, "Fuego Elemental"));

        b= Render.batch;
        stage= new Stage();
        Gdx.input.setInputProcessor(stage);
        skin=new Skin(Gdx.files.internal("Skin/uiskin.json"));



        luchar  = new TextButton("LUCHAR",skin);
        luchar.setPosition(Config.ANCHO/2,100);
        luchar.setWidth(ancho);

        mochila = new TextButton("MOCHILA",skin);
        mochila.setPosition(Config.ANCHO/2+luchar.getWidth(),100);
        mochila.setWidth(ancho);

        huir  = new TextButton("HUIR",skin);
        huir.setPosition(Config.ANCHO/2,luchar.getY()-luchar.getHeight());
        huir.setWidth(ancho);


    }

    private TextButton nombreBoton(int index){
        String nombre=habilidades.get(index).getNombre();
        TextButton habilidad = new TextButton(nombre,skin);
        habilidad.setPosition(Config.ANCHO/2,100);
        return habilidad;
    }

    private void botonesHab(){

    }

    private void botonLuchar(){
        luchar.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                mochila.setVisible(false);
                huir.setVisible(false);
                luchar.setVisible(false);

            }
        });
    }

    private void hudBatalla(){
        poner(mochila);
        poner(luchar);
        poner(huir);
        botonLuchar();
    }

    private void poner(Actor a){
        stage.addActor(a);
    }

    @Override
    public void render(float delta) {
        Render.limpiarPantalla(1,1,1);
        b.begin();
        stage.act();
        stage.draw();
        hudBatalla();
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
