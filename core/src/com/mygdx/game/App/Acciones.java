package com.mygdx.game.App;

public interface Acciones {

    boolean usar(Item item, Compa partner); /**Compa como parametro*/
    void tirar(int cantidad);

}
