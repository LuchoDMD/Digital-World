package com.mygdx.game.App;

public class Pocion extends Item{

    public Pocion(String descEfecto, int stock, int cantRestauracion) {
        this.descEfecto=descEfecto;
        this.stock=stock;
        this.cantRestauracion=cantRestauracion;
    }

    /*
    @Override
    public void usar(Compa partner) {
        if (partner.getVida() + cantRestauracion > partner.getHp()){
            partner.setVida(partner.getHp());
        } else {
            partner.setVida(partner.getVida() + cantRestauracion);
        }
        stock--;
    }

     */

    @Override
    public String toString() {
        return "Pocion [" +
                "Desc.: '" + descEfecto + '\'' +
                ", Stock: " + stock +
                ", Cant. Restauracion: " + cantRestauracion +
                ']';
    }


}
