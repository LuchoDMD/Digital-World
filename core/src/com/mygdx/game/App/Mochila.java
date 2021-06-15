package com.mygdx.game.App;

import java.util.ArrayList;
import java.util.List;

public class Mochila {

    private List<Bolsillo> pociones;
    private List<Bolsillo> elixires;

    public Mochila() {
        this.pociones = new ArrayList<>();
        this.elixires = new ArrayList<>();
    }

    public List<Bolsillo> getPociones() {
        return pociones;
    }

    public List<Bolsillo> getElixires() {
        return elixires;
    }

    public void agregarItems(Item item) {
        List<Bolsillo> temp = null;

        if (item instanceof Pocion) {
            temp = pociones;
        }

        if (item instanceof Elixir) {
            temp = elixires;
        }

        if (temp != null) {
            boolean existe = false;

            for (Bolsillo i : temp) {
                if (i.getItem().getCantRestauracion() == item.getCantRestauracion()) {
                    i.agregarItem();
                    existe = true;
                }
            }
            if (!existe) {
                Bolsillo bolsillo = new Bolsillo(item);
                temp.add(bolsillo);
            }
        }
    }

    public Item tomarItem(Item item) {
        try {
            List<Bolsillo> temp = null;

            if (item instanceof Pocion) {
                temp = pociones;
            }

            if (item instanceof Elixir) {
                temp = elixires;
            }

            if (temp != null) {
                for (Bolsillo b : temp) {
                    if (b.getItem().getCantRestauracion() == item.getCantRestauracion()) {
                        return b.quitarItem();
                    }
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Mochila{" +
                "pociones=" + pociones +
                ", elixires=" + elixires +
                '}';
    }
}



