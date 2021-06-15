package com.mygdx.game.App;

public class Elixir extends Item{

    public Elixir(String descEfecto, int cantRestauracion) {
        this.descEfecto=descEfecto;
        this.cantRestauracion=cantRestauracion;
    }

    @Override
    public void usar(Compa partner) {
        if (partner.getMana() + cantRestauracion > partner.getMp()){
            partner.setMana(partner.getMp());
        } else {
            partner.setMana(partner.getMana() + cantRestauracion);
        }
    }

    @Override
    public String toString() {
        return "Elixir [" +
                "Desc. Efecto: '" + descEfecto + '\'' +
                ", Cant. Restauracion: " + cantRestauracion +
                ']';
    }
}
