package com.mygdx.game.Eventos;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.Pantalla.PantallaBatalla;


public class EntradaBatalla implements InputProcessor {

    private boolean abajo=false, arriba=false, enter=false, izquierda=false, derecha = false;
    private PantallaBatalla app;

    public EntradaBatalla(PantallaBatalla app) {
        this.app = app;
    }

    public boolean isAbajo() {
        return abajo;
    }

    public boolean isArriba() {
        return arriba;
    }

    public boolean isEnter() {
        return enter;
    }

    public boolean isIzquierda() {
        return izquierda;
    }

    public boolean isDerecha() {
        return derecha;
    }

    @Override
    public boolean keyDown(int keycode) {
        app.tiempo = 0.08f;

        if (keycode == Input.Keys.DOWN){
            abajo=true;
        }
        if (keycode == Input.Keys.UP){
            arriba=true;
        }
        if(keycode== Input.Keys.ENTER){
            enter=true;
        }
        if(keycode== Input.Keys.RIGHT){
            derecha=true;
        }
        if(keycode== Input.Keys.LEFT){
            izquierda=true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.DOWN){
            abajo=false;
        }
        if (keycode == Input.Keys.UP){
            arriba=false;
        }
        if (keycode == Input.Keys.ENTER){
            enter=false;
        }
        if (keycode == Input.Keys.RIGHT){
            derecha=false;
        }
        if (keycode == Input.Keys.LEFT){
            izquierda=false;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
