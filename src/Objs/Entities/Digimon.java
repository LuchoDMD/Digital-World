package Objs.Entities;

import Objs.Items.Tecnica;
import java.util.List;

public abstract class Digimon
{
    protected String especie, familia, atributo, etapa;
    protected int peso,nivel,hp,mp,atk,def,spd;
    protected List<Tecnica> tecnicas; /*SOLO HASTA 3(PODRIAN SER CUATRO)*/

    public Digimon(String especie, String familia, String atributo, String etapa, int peso,int nivel, int hp, int mp, int atk, int def, int spd)
    {
        this.especie = especie;
        this.familia = familia;
        this.atributo = atributo;
        this.etapa = etapa;
        this.nivel = nivel;
        this.peso = peso;
        this.hp = hp;
        this.mp = mp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
        this.tecnicas = tecnicas;
    }

    public String getEspecie()
    {
        return especie;
    }
    public String getFamilia()
    {
        return familia;
    }
    public String getAtributo() {
        return atributo;
    }
    public String getEtapa() {
        return etapa;
    }
    public int getPeso()
    {
        return peso;
    }
    public void setPeso(int peso)
    {
        this.peso = peso;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getMp() {
        return mp;
    }
    public void setMp(int mp) {
        this.mp = mp;
    }
    public int getAtk() {
        return atk;
    }
    public void setAtk(int atk) {
        this.atk = atk;
    }
    public int getDef() {
        return def;
    }
    public void setDef(int def) {
        this.def = def;
    }
    public int getSpd() {
        return spd;
    }
    public void setSpd(int spd) {
        this.spd = spd;
    }

    public void agregarTecnica(Tecnica t, int limit)
    {
        if(tecnicas.size()<limit)
        {
            if(!tecnicas.contains(t))
            {
                tecnicas.add(t);
            }
        }
    }

    public String getNombreTecnica(int index)
    {
        return tecnicas.get(index).getNombre();
    }

    public int stab(Tecnica t)/*Es para el calculo: revisa si la familia tecnica pertenece a la misma familia del digimon*/
    {
        if(t.getFamilia().equals(familia))
        {
            return 2;
        }
        return 1;
    }

    @Override
    public String toString()/*CAMBIARLO*/
    {
        return "especie='" + especie + '\'' +
                ", familia='" + familia + '\'' +
                ", atributo='" + atributo + '\'' +
                ", etapa='" + etapa + '\'' +
                ", nivel=" + nivel +
                ", hp=" + hp +
                ", mp=" + mp +
                ", atk=" + atk +
                ", def=" + def +
                ", spd=" + spd +
                '}';
    }
}
