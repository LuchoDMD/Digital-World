package com.mygdx.game.App;

public abstract class Item
{

    protected String descEfecto;
    private int cantRestauracion;

    public int getCantRestauracion()
    {
        return cantRestauracion;
    }

    public void setCantRestauracion(int cantRestauracion)
    {
        this.cantRestauracion = cantRestauracion;
    }
    public String getDescEfecto()
    {
        return descEfecto;
    }

    public void setDescEfecto(String descEfecto)
    {
        this.descEfecto = descEfecto;
    }
}

