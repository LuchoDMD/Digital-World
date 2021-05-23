package com.company;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Partner extends Digimon implements Combate {
    /*ATRIBUTOS*/
    private String nombre;
    private int vida;/*Vida actual del Digimon*/
    private int mana;/*Mana actual del Digimon*/
    private int exp;/*Experiencia*/
    private int status;
    //private int aptitud;


    public Partner(int nivel, int hp, int mp, int atk, int def, int spd, String nombre, Map abilityMap, int[] keys)
    {
        super(nivel, hp, mp, atk, def, spd, abilityMap, keys);
        this.vida = hp;
        this.mana = mp;
        this.exp = 0;
        this.nombre = nombre;
        this.status = 0;
    }

    /*GETTERS AND SETTERS*/
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        nombre = nombre;
    }
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int atacar()
    {
        return getAtk();
    }
    @Override
    public int defender()
    {
        setStatus(1);
        setDef(getDef() + 10); //aumenta la defensa en 10
        return 0;
    }

    @Override
    public int skillAttack(Ability ability){
        setMana(getMana() - ability.getMPcost());
        Random random = new Random();
        if(random.nextInt(100) <= ability.getPrecision()){  //agrega chances de que le erre
            return ability.getDamage();
        }
        return 0;
    }

    @Override
    public int esquivar()
    {
        return 0;
    }
    @Override
    public int getDmg(int dañoRecibido){
        //formula
        return dañoRecibido-getDef();
    }
}