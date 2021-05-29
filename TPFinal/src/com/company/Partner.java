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
    //private int aptitud;


    public Partner(int nivel, int hp, int mp, int atk, int def, int spd, String nombre, int peso, Map abilityMap, int[] keys)
    {
        super(nivel, hp, mp, atk, def, spd, peso, abilityMap, keys);
        this.vida = hp;
        this.mana = mp;
        this.exp = 0;
        this.nombre = nombre;
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
    public boolean checkMana(Ability ability){
        if (this.getMana() > ability.getMPcost()){
            return true;
        }
        return false;
    }

    //este método recibe el daño real y determina si es el último hit o no
    @Override
    public boolean killingBlow(int dmg){
        if(this.getVida() > dmg){ //se puede conviertir en un método.
            this.setVida(this.getVida() - dmg);
            return false;
        }
        else{
            this.setVida(0);
            return true;
        }
    }

    @Override
    public void mpRegen(){
        setMana(getMana() + 10);
    }

    @Override
    public int skillAttack(Ability ability){
        Random random = new Random();
        if(random.nextInt(100) <= ability.getPrecision()){  //agrega chances de que le erre
            return ability.getDamage();
        }
        return 0;
    }

    @Override
    public boolean esquivar()
    {
        int aux= (int) (Math.random()*100);
        if (aux<=getSpd()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int getDmg(int dañoRecibido){
        //formula
        if (dañoRecibido-getDef() < 0){
            return 0;
        }

        return dañoRecibido-getDef();
    }
}