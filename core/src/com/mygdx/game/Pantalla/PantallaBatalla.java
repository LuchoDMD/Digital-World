package com.mygdx.game.Pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.game.Utiles.Config;
import com.mygdx.game.Utiles.Render;

public class PantallaBatalla implements Screen {

    private SpriteBatch b;
    private TextButton luchar, mochila, huir;
    private Stage stage;
    private TextField n;
    private Skin skin;
    private int ancho=200, alto=30;


    @Override
    public void show() {
        b= Render.batch;
        stage= new Stage();
        skin=new Skin(Gdx.files.internal("Skin/uiskin.json"));
        Gdx.input.setInputProcessor(stage);
        n=new TextField("",skin);

        luchar  = new TextButton("LUCHAR",skin);
        luchar.setPosition(700,150);
        luchar.setWidth(ancho);
        luchar.setHeight(alto);

        mochila  = new TextButton("MOCHILA",skin);
        mochila.setPosition(900,150);
        mochila.setWidth(ancho);
        mochila.setHeight(alto);

        huir  = new TextButton("HUIR",skin);
        huir.setPosition(700,luchar.getY()-luchar.getHeight());
        huir.setWidth(ancho);
        huir.setHeight(alto);

        poner(luchar);
        poner(mochila);
        poner(huir);
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
