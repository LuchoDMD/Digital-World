package com.mygdx.game.Elementos;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Utiles.Render;

//TODO clase para trabajar mas comodo con los textos

public class Texto {
    private BitmapFont fuente;
    private float x=0,y=0;
    private String texto="";
    private GlyphLayout layout;



    public Texto(String rutaFuente, int dimension, Color color, boolean sombra) {
        generarTexto(rutaFuente,dimension,color,sombra);
    }

    public void generarTexto(String rutaFuente, int tamanio, Color color, boolean sombra){
        //todo para cargar fuentes del estilo .ttf
        FreeTypeFontGenerator generador= new FreeTypeFontGenerator(Gdx.files.internal(rutaFuente));
        FreeTypeFontGenerator.FreeTypeFontParameter parametro= new FreeTypeFontGenerator.FreeTypeFontParameter();
        parametro.size=tamanio;
        parametro.color= color;
        if(sombra){
            parametro.shadowColor=Color.BLACK;
            parametro.shadowOffsetX=1;
            parametro.shadowOffsetY=1;
            parametro.borderGamma=1.8f;
        }
        fuente = generador.generateFont(parametro);
        layout= new GlyphLayout();
    }


    public void setColor(Color color) {
       fuente.setColor(color);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setPosition(float x,float y){
        this.x=x;
        this.y=y;
    }

    public void setTexto(String texto) {
        this.texto = texto;
        layout.setText(fuente,texto);
    }

    public String getTexto() {
        return texto;
    }

    public void dibujar(){
        fuente.draw(Render.batch,getTexto(),getX(),getY());
    }

    public float getAncho(){
        return layout.width;
    }

    public float getAlto(){
        return layout.height;
    }

    public Vector2 getDimension(){
        return new Vector2(layout.width,layout.height);
    }
    public Vector2 getPosicion(){
        return new Vector2(x,y);
    }

}
