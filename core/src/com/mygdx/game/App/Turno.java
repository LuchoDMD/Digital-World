package com.mygdx.game.App;

public class Turno {
    private String atacante;
    private String defensor;
    private int danio;
    private int turno;
    private String ataque;
    private Item item;

    //CONSTRUCTOR\\
    public Turno(String atacante, String defensor, int danio, int turno, String ataque) {
        this.atacante = atacante;
        this.defensor = defensor;
        this.danio = danio;
        this.turno = turno;
        this.ataque = ataque;
        this.item = null;
    }

    public Turno(String atacante, int turno, Item i){

    }

    //MÉTODOS\\

    public String getAtacante() {
        return atacante;
    }

    public void setAtacante(String atacante) {
        this.atacante = atacante;
    }

    public String getDefensor() {
        return defensor;
    }

    public void setDefensor(String defensor) {
        this.defensor = defensor;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    //OVERRIDE\\

    @Override
    public String toString() {
        if(item == null){
            return "Turno " + turno + " [" +
                    atacante + " ataco a " + defensor + " haciendo un dmg de: " + danio + " con " + ataque +
                    ']';
        }
        return "Turno [" +
                atacante + " usó " + item.getDescEfecto() + " curandose por " + item.getCantRestauracion() +
                ']';

    }
}
