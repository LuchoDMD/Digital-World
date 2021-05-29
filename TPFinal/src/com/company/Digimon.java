package com.company;

import java.util.HashMap;
import java.util.Map;

public abstract class Digimon {
    /*ATRIBUTOS*/
    /*
    protected String especie;
    protected String familia;//Similar al elemento en pokemon
    protected String atributo;//TIPO: VIRUS - VACUNA - DATOS
    protected String etapa; //Bebe - Novato - Campeon - Adulto - Perfecto
     */

    private int nivel;
    private int hp;/*VIDA*/
    private int mp;/*MANA*/
    private int atk;/*ATAQUE*/
    private int def;/*DEFENSA*/
    private int spd;/*VELOCIDAD*/ //poder de ataque
    private int status;
    private int peso;
    public Ability[] abilities;


    public Digimon(int nivel, int hp, int mp, int atk, int def, int spd, int peso, Map abilityMap, int[] keys) {
        this.nivel = nivel;
        this.peso = peso;
        this.hp = hp;
        this.mp = mp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
        this.status = 0;
        this.abilities = new Ability[4];    //los digimon solo pueden tener 4 habilidades
        loadSkills(abilityMap, keys);
    }

    public void loadSkills(Map abilityMap, int[] keys){
        for (int i = 0 ; i < 4 ; i++){
            abilities[i] = (Ability) abilityMap.get(keys[i]);
        }
    }

    //método para saber si el hit va a ser el que remate o no (para evitar dejarlo con vida negativa)
    public abstract boolean killingBlow(int dmg);

    //check para saber si tiene mana suficiente para lanzar el skill
    public abstract boolean checkMana(Ability ability);



    public void clearStatus(){    //método que se usa al terminar el turno para remover los status
        if (this.getStatus() == 1){
            this.setDef(this.getDef() - 10);
            this.setStatus(0);
        }
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

    public Ability[] getAbilities() {
        return abilities;
    }

    public void setAbilities(Ability[] abilities) {
        this.abilities = abilities;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

