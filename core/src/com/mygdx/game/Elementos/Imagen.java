package com.mygdx.game.Elementos;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Utiles.Render;


//TODO la clase imagen esta hecha para trabajar mas comodo con las imagenes y poder personalizarlas mejor

public class Imagen {

    private Texture t;
    private Sprite s;
    private float ancho,alto;
    private float x,y;

    public Imagen(String ruta){
        t= new Texture(ruta);
        s=new Sprite(t);
    }


    public Sprite getS() {
        return s;
    }

    public void dibujar(){
        s.draw(Render.batch);
    }

    public void setTransparencia(float a){
        s.setAlpha(a);
    }

    public void rotar(int grados){
        s.rotate(grados);
    }

    public void girar(){
        s.flip(true,false);
    }

    public void setSize(float ancho, float alto){
        this.ancho=ancho;
        this.alto=alto;
        s.setSize(ancho,alto);
    }

    public float getAncho() {
        return this.ancho;
    }

    public float getAlto() {
        return this.alto;
    }

    public void setPosition(float x,float y){
        this.x=x;
        this.y=y;
        s.setPosition(x, y);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
