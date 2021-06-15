package com.mygdx.game.App;

public abstract class Item implements Acciones {

    protected String descEfecto;
    protected int cantRestauracion;

    public int getCantRestauracion() {
        return cantRestauracion;
    }

    public String getDescEfecto() {
        return descEfecto;
    }

    public void setDescEfecto(String descEfecto) {
        this.descEfecto = descEfecto;
    }

    @Override
    public abstract void usar(Compa partner);
}