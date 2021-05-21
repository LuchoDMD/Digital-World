package Objs.Entities;

import Objs.Actions.Combate;

public class Partner extends Digimon implements Combate
{
    private String nombre;
    private int peso, vida, mana, xp;

    public Partner(String especie, String familia, String atributo, String etapa, int nivel, int hp, int mp, int atk, int def, int spd, int peso)
    {
        super(especie, familia, atributo, etapa, nivel, hp, mp, atk, def, spd);
        this.nombre=especie;
        this.peso=peso;
    }

    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public int getPeso()
    {
        return peso;
    }
    public void setPeso(int peso)
    {
        this.peso = peso;
    }
    public int getVida()
    {
        return vida;
    }
    public void setVida(int vida)
    {
        this.vida = vida;
    }
    public int getMana()
    {
        return mana;
    }
    public void setMana(int mana)
    {
        this.mana = mana;
    }
    public int getXp()
    {
        return xp;
    }
    public void setXp(int xp)
    {
        this.xp = xp;
    }

    @Override
    public String toString() {
        return "Partner{"+super.toString()+
                "nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", vida=" + vida +
                ", mana=" + mana +
                ", xp=" + xp +
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

/*PLANTEAR EL CALCULO DEL ESQUIVAR Y DEFENDER PARA QUE PUEDAN REALIZARSE EN COMBATE*/