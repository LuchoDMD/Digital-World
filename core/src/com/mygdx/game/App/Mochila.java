package com.mygdx.game.App;

import java.util.ArrayList;
import java.util.List;

public class Mochila {

    private List<Item> bolsillo;


    public Mochila() {
        this.bolsillo = new ArrayList<>();
    }

    public Mochila (Mochila m){
        int aux=0;
        while(!m.getBolsillo().isEmpty()){
            this.bolsillo.add(m.getBolsillo().get(aux));
            aux++;
        }
    }

    public Mochila(List<Item> lista){
        this.bolsillo = new ArrayList<Item>();
        this.bolsillo = lista;
    }


    public void agregarItems(Item item){
        boolean flag = false;
        int aux = 0;
        for(Item variable : bolsillo){
            if(variable == item){
                flag = true;
                break;
            }
            aux ++;
        }
        if (flag){
            Item it = bolsillo.get(aux);
            it.setStock(it.getStock() + 1);
        }
        else{
            bolsillo.add(item);
        }
    }


    public void usarItem(int index){

    }

    public Item mostrarItem(int index){
        return bolsillo.get(index);
    }

    @Override
    public String toString() {
        return "Mochila [" +
                "Contenido: " + bolsillo +
                ']';
    }


    public List<Item> getBolsillo() {
        return bolsillo;
    }

    public void setBolsillo(List<Item> bolsillo) {
        this.bolsillo = bolsillo;
    }
}
