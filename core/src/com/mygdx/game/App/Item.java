package com.mygdx.game.App;

public class Item
{


    protected String descEfecto;
    private int cantRestauracion;

    public Item(String descEfecto, int cantRestauracion) {
        this.descEfecto = descEfecto;
        this.cantRestauracion = cantRestauracion;
    }

    public Item() {
    }

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

    @Override
    public String toString() {
        return "Item{" +
                "descEfecto='" + descEfecto + '\'' +
                ", cantRestauracion=" + cantRestauracion +
                '}';
    }
}

