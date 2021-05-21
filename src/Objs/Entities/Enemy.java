package Objs.Entities;

import Objs.Actions.Combate;

public class Enemy extends Digimon implements Combate
{
    private String terreno;

    public Enemy(String especie, String familia, String atributo, String etapa, int nivel, int hp, int mp, int atk, int def, int spd, String terreno)
    {
        super(especie, familia, atributo, etapa, nivel, hp, mp, atk, def, spd);
        this.terreno=terreno;
    }

    public String getTerreno() {
        return terreno;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "especie='" + especie + '\'' +
                ", familia='" + familia + '\'' +
                ", atributo='" + atributo + '\'' +
                ", etapa='" + etapa + '\'' +
                ", nivel=" + nivel +
                ", hp=" + hp +
                ", mp=" + mp +
                ", atk=" + atk +
                ", def=" + def +
                ", spd=" + spd +
                ", terreno='" + terreno + '\'' +
                '}';
    }

    @Override
    public int atacar() {
        return 0;
    }

    @Override
    public int defender() {
        return 0;
    }

    @Override
    public int esquivar() {
        return 0;
    }
}
