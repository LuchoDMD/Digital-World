package com.mygdx.game.App;

public class Elixir extends Item{

    public Elixir(String descEfecto, int stock, int cantRestauracion) {
        this.descEfecto=descEfecto;
        this.stock=stock;
        this.cantRestauracion=cantRestauracion;
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
        return "Elixir [" +
                "Desc.: '" + descEfecto + '\'' +
                ", Stock: " + stock +
                ", Cant Restauracion: " + cantRestauracion +
                ']';
    }
}
