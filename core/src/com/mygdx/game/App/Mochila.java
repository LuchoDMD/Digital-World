package com.mygdx.game.App;

import java.util.ArrayList;
import java.util.List;

public class Mochila<T> {

    private List<T> bolsillo;

    public List<T> getBolsillo() {
        return bolsillo;
    }

    public void setBolsillo(List<T> bolsillo) {
        this.bolsillo = bolsillo;
    }

    public Mochila() {
        bolsillo = new ArrayList<>();
    }


    public void agregarItems(T item){
        boolean flag = false;
        int aux = 0;
        for(T variable : bolsillo){
            if(variable == item){
                flag = true;
                break;
            }
            aux ++;
        }
        if (flag){
            Item it = (Item) bolsillo.get(aux);
            it.setStock(it.getStock() + 1);
        }
        else{
            bolsillo.add(item);
        }
    }


    public void usarItem(int index){

    }

    public T mostrarItem(int index){
        return bolsillo.get(index);
    }

    @Override
    public String toString() {
        return "Mochila [" +
                "Contenido: " + bolsillo +
                ']';
    }


}
