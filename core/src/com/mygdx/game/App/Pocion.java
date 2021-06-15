package com.mygdx.game.App;

public class Pocion extends Item{

    public Pocion(String descEfecto, int cantRestauracion) {
        this.descEfecto=descEfecto;
        this.cantRestauracion=cantRestauracion;
    }

    @Override
    public void usar(Compa partner) {
        if (partner.getVida() + cantRestauracion > partner.getHp()){
            partner.setVida(partner.getHp());
        } else {
            partner.setVida(partner.getVida() + cantRestauracion);
        }
    }


    @Override
    public String toString() {
        return "Pocion [" +
                "Desc. Efecto: '" + descEfecto + '\'' +
                ", Cant. Restauracion: " + cantRestauracion +
                ']';
    }
}
