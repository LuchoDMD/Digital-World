package com.mygdx.game.Eventos;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.Pantalla.PantallaBatalla;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;


public class EntradaBatalla implements InputProcessor {

    private boolean abajo=false, arriba=false, enter=false, izquierda=false, derecha = false;
    private boolean bot0=false,bot1=false,bot2=false,bot3=false,bot4=false,bot5=false,bot6=false, botq=false,botw=false,bote=false, botEspacio=false;
    private PantallaBatalla app;

    public EntradaBatalla(PantallaBatalla app) {
        this.app = app;
    }



    public boolean isBotEspacio() {
        return botEspacio;
    }

    public void setBotEspacio(boolean botEspacio) {
        this.botEspacio = botEspacio;
    }

    public void blockKey(){

    }

    public boolean isBot0() {
        return bot0;
    }

    public boolean isBot1() {
        return bot1;
    }

    public boolean isBot2() {
        return bot2;
    }

    public boolean isBot3() {
        return bot3;
    }

    public boolean isBot4() {
        return bot4;
    }

    public boolean isBot5() {
        return bot5;
    }

    public boolean isBot6() {
        return bot6;
    }

    public void setBot1(boolean bot1) {
        this.bot1 = bot1;
    }

    public void setBot2(boolean bot2) {
        this.bot2 = bot2;
    }

    public void setBot3(boolean bot3) {
        this.bot3 = bot3;
    }

    public void setBot4(boolean bot4) {
        this.bot4 = bot4;
    }

    public void setBot5(boolean bot5) {
        this.bot5 = bot5;
    }

    public void setBot6(boolean bot6) {
        this.bot6 = bot6;
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

    public void setEnter(boolean enter) {
        this.enter = enter;
    }

    public boolean isDerecha() {
        return derecha;
    }

    public boolean isBotq() {
        return botq;
    }

    public boolean isBotw() {
        return botw;
    }

    public boolean isBote() {
        return bote;
    }

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Input.Keys.SPACE){
            abajo=true;
        }

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

        if (keycode == Input.Keys.NUM_0){
            bot0=true;
        }
        if (keycode == Input.Keys.NUM_1){
            bot1=true;
        }
        if (keycode == Input.Keys.NUM_2){
            bot2=true;
        }
        if (keycode == Input.Keys.NUM_3){
            bot3=true;
        }
        if (keycode == Input.Keys.NUM_4){
            bot4=true;
        }
        if (keycode == Input.Keys.NUM_5){
            bot5=true;
        }
        if (keycode == Input.Keys.NUM_6){
            bot6=true;
        }
        if (keycode == Input.Keys.Q){
            botq=true;
        }
        if (keycode == Input.Keys.W){
            botw=true;
        }
        if (keycode == Input.Keys.E){
            bote=true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.SPACE){
            abajo=false;
        }

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

        if (keycode == Input.Keys.NUM_0){
            bot0=false;
        }
        if (keycode == Input.Keys.NUM_1){
            bot1=false;
        }
        if (keycode == Input.Keys.NUM_2){
            bot2=false;
        }
        if (keycode == Input.Keys.NUM_3){
            bot3=false;
        }
        if (keycode == Input.Keys.NUM_4){
            bot4=false;
        }
        if (keycode == Input.Keys.NUM_5){
            bot5=false;
        }
        if (keycode == Input.Keys.NUM_6){
            bot6=false;
        }
        if (keycode == Input.Keys.Q){
            botq=false;
        }
        if (keycode == Input.Keys.W){
            botw=false;
        }
        if (keycode == Input.Keys.E){
            bote=false;
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
