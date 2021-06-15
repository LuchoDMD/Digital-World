package com.mygdx.game.App;

public class Bolsillo {

    private Item item;
    private int stock;

    public Bolsillo(Item item) {
        this.item = item;
        this.stock = 1;
    }

    public Item getItem() {
        return item;
    }

    public void agregarItem() {
        stock++;
    }

    public Item quitarItem() throws Exception {
        if (stock > 0){
            stock--;
            return item;
        } else {
            throw new Exception("No hay stock disponible");
        }
    }

    public void tirarItem(int cantidad) {
        if (cantidad > this.stock) {
            this.stock = 0;
        } else {
            this.stock = this.stock - cantidad;
        }
    }

    @Override
    public String toString() {
        return "Bolsillo [" +
                "Tipo de item: " + item +
                ", Stock: " + stock +
                ']' + "\n";
    }
}
