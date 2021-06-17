package com.mygdx.game.Eventos;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.Pantalla.PantallaBatalla;
import com.mygdx.game.Pantalla.PantallaMenu;

//TODO clase para setearle el comportamiento al menu

public class Entrada implements InputProcessor {

    private boolean abajo=false, arriba=false, enter=false, izquierda=false, derecha = false;
    private PantallaMenu app;


    public Entrada(PantallaMenu app){
        this.app=app;
    }


    public boolean isEnter() {
        return enter;
    }

    public boolean isAbajo() {
        return abajo;
    }

    public boolean isArriba() {
        return arriba;
    }

    @Override
    public boolean keyDown(int keycode) {
        app.tiempo = 0.08f;

        if (keycode == Keys.DOWN){
            abajo=true;
        }
        if (keycode == Keys.UP){
            arriba=true;
        }
        if(keycode==Keys.ENTER){
            enter=true;
        }
        if(keycode==Keys.RIGHT){
            derecha=true;
        }
        if(keycode==Keys.LEFT){
            izquierda=true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Keys.DOWN){
            abajo=false;
        }
        if (keycode == Keys.UP){
            arriba=false;
        }
        if (keycode == Keys.ENTER){
            enter=false;
        }
        if (keycode == Keys.RIGHT){
            derecha=false;
        }
        if (keycode == Keys.LEFT){
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
