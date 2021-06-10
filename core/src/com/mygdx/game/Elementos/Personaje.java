package com.mygdx.game.Elementos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Utiles.Render;

//TODO esta clase el la que genera las animaciones a partir de una plantilla de imagenes png

public class Personaje {

    private float x,y;
    private Animation animation;
    private float tiempo;
    private TextureRegion [] movimiento;
    private Texture imagen;
    private TextureRegion frameActual;




    public Personaje(float x, float y, String ruta, int cantidad, float duracion){
        this.x=x;
        this.y=y;
        //todo accedes a la imagen la metes en una matriz, la dividis y despues la pasas a
        //todo array para poder recorrerla mas facil
        imagen=new Texture(Gdx.files.internal(ruta));
        TextureRegion[][] temporal= TextureRegion.split(imagen,
                imagen.getWidth()/cantidad,imagen.getHeight());

        movimiento= new TextureRegion[cantidad];
        for (int i=0; i<cantidad;i++){
            movimiento[i]=temporal[0][i];
        }
        animation=new Animation(duracion,movimiento);
        tiempo=0f;
    }

    public Personaje(String ruta, int cantidad, float duracion){

        //todo accedes a la imagen la metes en una matriz, la dividis y despues la pasas a
        //todo array para poder recorrerla mas facil
        imagen=new Texture(Gdx.files.internal(ruta));
        TextureRegion[][] temporal= TextureRegion.split(imagen,
                imagen.getWidth()/cantidad,imagen.getHeight());

        movimiento= new TextureRegion[cantidad];
        for (int i=0; i<cantidad;i++){
            movimiento[i]=temporal[0][i];
        }
        animation=new Animation(duracion,movimiento);
        tiempo=0f;
    }


    public void render(final SpriteBatch batch){
        tiempo+=Gdx.graphics.getDeltaTime();//tiempo que paso del ultimo render
        frameActual = (TextureRegion) animation.getKeyFrame(tiempo,true);
        batch.draw(frameActual,x,y);
    }

    public TextureRegion personajeEspera(){
        return movimiento[0];
    }


    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
}
