package Objs.Entities;

import Objs.Actions.Combate;

public class Enemy extends Digimon implements Combate
{
    private String terreno;

    public Enemy(String especie,String familia,String atributo,String etapa,int peso,int nivel,int hp,int mp,int atk,int def,int spd,String terreno)
    {
        super(especie,familia,atributo,etapa,peso,nivel,hp,mp,atk,def,spd);
        this.terreno=terreno;
    }

    public String getTerreno() {
        return terreno;
    }

    @Override
    public String toString() /*CAMBIARLO*/
    {
        return super.toString()+
                "\n>HP: "+hp+
                ".\n>MP: "+mp+
                ".\n>ATK: "+atk+
                ".\n>DEF: "+def+
                ".\n>SPD: "+spd+".";
    }

    @Override
    public int atacar(int index)
    {
        return (tecnicas.get(index).getPotencia()*atk*stab(tecnicas.get(index)))/(((int)Math.random()*2)*100);
    }

    @Override
    public int defender()
    {
        return (def * (peso / spd)) / (((int) Math.random()*2) * 100);
    }

    @Override
    public int esquivar()
    {
        return spd*((int)Math.random()*2)/(peso*(5/2));
    }
}
