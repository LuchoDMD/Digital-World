package com.company;

public class Digimon {
    /*ATRIBUTOS*/
    /*
    protected String especie;
    protected String familia;//Similar al elemento en pokemon
    protected String atributo;//TIPO: VIRUS - VACUNA - DATOS
    protected String etapa; //Bebe - Novato - Campeon - Adulto - Perfecto
     */

    protected int nivel;
    protected int hp;/*VIDA*/
    protected int mp;/*MANA*/
    protected int atk;/*ATAQUE*/
    protected int def;/*DEFENSA*/
    protected int spd;/*VELOCIDAD*/ //poder de ataque
    //private Ability[] abilities;

    //private int peso;

    /*CONSTRUTOR
    public Digimon(String especie, String familia, String atributo, String etapa, int nivel, int hp, int mp, int atk, int def, int spd)
    {

        this.especie = especie;
        this.familia = familia;
        this.atributo = atributo;
        this.etapa = etapa;


        this.nivel = nivel;
        this.hp = hp;
        this.mp = mp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
    }
    */

    public Digimon(int nivel, int hp, int mp, int atk, int def, int spd /*Ability[] abilities*/) {
        this.nivel = nivel;
        this.hp = hp;
        this.mp = mp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
        //this.abilities = abilities;    //los pokemons solo pueden tener 4 habilidades
    }



    /*GETTERS AND SETTERS*/


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
}