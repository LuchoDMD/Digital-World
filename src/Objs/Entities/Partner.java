package Objs.Entities;

import Objs.Actions.Combate;
import java.util.Scanner;

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
    public String toString()/*CAMBIARLO*/
    {
        return ">"+nombre+":\n"+super.toString()+
                "\n>HP: "+hp+
                ".\n>MP: "+mp+
                ".\n>ATK: "+atk+
                ".\n>DEF: "+def+
                ".\n>SPD: "+spd+".";
    }

    public int seleccionarTecnica() /*El metodo solo existe para provar cosas*/
    {
        int rta=-1; Scanner s=new Scanner(System.in);
        System.out.println("1="+tecnicas.get(0).getNombre()+"\n2="+tecnicas.get(1).getNombre()+"\n3="+tecnicas.get(2).getNombre());
        while(!s.hasNextInt())
        {
            System.out.println("Valor no válido");
            s.next();
            System.out.println("1="+tecnicas.get(0).getNombre()+"\n2="+tecnicas.get(1).getNombre()+"\n3="+tecnicas.get(2).getNombre());
        }
        rta=s.nextInt();
        return rta;
    }

    private int expRank()/*Formula de Rango de experiencia de siguiente nivel*/
    {
        return (nivel*(atk+def+spd))/100;
    }

    private void levelUp()/*Subida de Nivel*/
    {
        if(xp==expRank())
        {
            setXp(0);
            setNivel(getNivel()+1);
            /*subeStats(int porcentaje);*/
        }
    }

    /*Podria haber un metodo que suba stadisticas y a medida que suba de nivel sube 1 o 0 las stats*/

    @Override
    public int atacar(int index)
    {
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

/*Revisar si los calculos satisfacen el concepto de combate*/