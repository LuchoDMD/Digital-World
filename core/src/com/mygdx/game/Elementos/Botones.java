package com.mygdx.game.Elementos;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.Utiles.Recursos;
import java.util.ArrayList;

//TODO crea un arraylist de botones para cuaqluier tipo de menu


public class Botones {
    private ArrayList<Texto> botones;

    public Botones(){
        botones=new ArrayList<>();
    }

    public void agregarBoton(Texto boton,String texto, int tamanio, int cantidad){
        boton=new Texto(Recursos.FUENTE1,tamanio, Color.WHITE,true);
        boton.setTexto(texto);
        if (botones.size()<cantidad){
            botones.add(boton);
        }
    }

    public void limpiar (){
        botones.clear();
    }

    public ArrayList<Texto> getBotones() {
        return botones;
    }
}
