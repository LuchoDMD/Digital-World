package Objs.Entities;

import Objs.Actions.Combate;

public class Partner extends Digimon implements Combate
{
    private String nombre;
    private int vida, mana, xp;

    public Partner(String especie,String familia,String atributo,String etapa,int peso,int nivel,int hp,int mp,int atk,int def,int spd)
    {
        super(especie,familia,atributo,etapa,peso,nivel,hp,mp,atk,def,spd);
        this.nombre=especie;

    }

    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
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
    public int atacar(int index) {
        return (tecnicas.get(index).getPotencia()*atk*stab(tecnicas.get(index)))/(((int)Math.random()*2)*100);
    }

    @Override
    public int defender() {
        return (def * (peso / spd)) / (((int) Math.random()*2) * 100);
    }

    @Override
    public int esquivar() {
        return spd*((int)Math.random()*2)/(peso*(5/2));
    }
}

/*PLANTEAR EL CALCULO DEL ESQUIVAR Y DEFENDER PARA QUE PUEDAN REALIZARSE EN COMBATE*/