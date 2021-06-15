package com.mygdx.game.App;

public abstract class Item implements Acciones {

    protected String descEfecto;
    protected int stock;
    protected int cantRestauracion;

    public String getDescEfecto() {
        return descEfecto;
    }

    public void setDescEfecto(String descEfecto) {
        this.descEfecto = descEfecto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if(this.stock < 100){
            this.stock = stock;
        }
        else{
            System.out.println("Inventario lleno");
        }
    }


    @Override
    public boolean usar(Item item, Compa partner){
        boolean flag = true;
        if (item instanceof Pocion){
            if(item.getStock() > 0){
                if (partner.getVida() + cantRestauracion > partner.getHp()){
                    partner.setVida(partner.getHp());
                } else {
                    partner.setVida(partner.getVida() + cantRestauracion);
                }
                stock--;
            }
            else{
                System.out.println("No posee más de este item");
                flag = false;
            }
        }
        if (item instanceof Elixir){
            if(item.getStock() > 0){
                if (partner.getMana() + cantRestauracion > partner.getMp()){
                    partner.setMana(partner.getMp());
                } else {
                    partner.setMana(partner.getMana() + cantRestauracion);
                }
                stock--;
            }
            else{
                System.out.println("No posee más de este item");
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public void tirar(int cantidad) {
        if (cantidad > this.stock) {
            this.stock = 0;
        } else {
            this.stock = this.stock - cantidad;
        }
    }


}