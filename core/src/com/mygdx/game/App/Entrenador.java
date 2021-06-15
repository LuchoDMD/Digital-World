package com.mygdx.game.App;

public class Entrenador {
    //ATRIBUTOS\\
    public Mochila mochila;
    //public double x,y; posiblemente se use en otra clase y no en esta (mapa o zona)
    public String nombre;

    //CONSTRUCTOR\\
    public Entrenador(Mochila mochila) {
        this.mochila = mochila;
    }


    //GETTERS & SETTERS\\
    public void nuevoItem(Item item){       //método para agregarle un item a la mochila del entrenador
        mochila.agregarItems(item);
    }

    public Mochila getMochila() {
        return mochila;
    }

    public void setMochila(Mochila mochila) {
        this.mochila = mochila;
    }

    /*
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

     */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
