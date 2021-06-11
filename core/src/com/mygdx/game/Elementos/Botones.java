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

    public void agregarBoton(Texto boton,String texto){
        boton=new Texto(Recursos.FUENTE1,30, Color.WHITE,true);
        boton.setTexto(texto);
        if (botones.size()<4){
            botones.add(boton);
        }
    }

    public ArrayList<Texto> getBotones() {
        return botones;
    }
}
