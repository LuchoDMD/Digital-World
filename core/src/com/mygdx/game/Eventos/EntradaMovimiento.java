package com.mygdx.game.Eventos;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.Pantalla.PantallaBatalla;
import com.mygdx.game.Pantalla.PantallaHistoria;
import com.mygdx.game.Pantalla.PantallaLaboratorio;
import com.mygdx.game.Pantalla.PantallaMapa;

//TODO clase para setear el comportamiento de los botones a la pantalla del mapa

public class EntradaMovimiento implements InputProcessor {

    private boolean abajo=false, arriba=false, enter=false, izquierda=false,
            derecha = false, letraE=false,letraW=false;
    private PantallaMapa mapa;
    private PantallaHistoria historia;
    private PantallaLaboratorio laboratorio;

    public EntradaMovimiento(PantallaLaboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public EntradaMovimiento(PantallaHistoria historia) {
        this.historia = historia;
    }

    public EntradaMovimiento(PantallaMapa mapa){
        this.mapa=mapa;
    }


    public boolean isLetraW() {
        return letraW;}

    public boolean isIzquierda() {
        return izquierda;
    }

    public boolean isDerecha() {
        return derecha;
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

    public boolean isLetraE() {
        return letraE;
    }

    @Override
    public boolean keyDown(int keycode) {

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
        if(keycode==Keys.E){
            letraE=true;
        }
        if(keycode==Keys.W){
            letraW=true;
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
        if(keycode == Keys.E){
            letraE=false;
        }
        if(keycode == Keys.W){
            letraW=false;
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

