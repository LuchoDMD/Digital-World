package com.mygdx.game.App;

public class Elixir extends Item{

    public Elixir(String descEfecto, int cantRestauracion) {
        setDescEfecto(descEfecto);
        setCantRestauracion(cantRestauracion);
    }

    /*
    @Override
    public void usar(Compa partner) {
        if (partner.getMana() + cantRestauracion > partner.getMp()){
            partner.setMana(partner.getMp());
        } else {
            partner.setMana(partner.getMana() + cantRestauracion);
        }
        stock--;
    }

     */

    @Override
    public String toString() {
        return "Pocion [" +
                "Desc.: '" + getDescEfecto() + '\'' +
                ", Cant. Restauracion: " + getCantRestauracion() +
                ']';
    }
}
