package com.company;
import java.util.*;
import java.util.Map;

public class Enemy extends Digimon implements Combate {
    /*ATRIBUTOS*/
    private String terreno;/*Indica en el tipo de terreno que puede aparecer*/
    private int dinero;
    String name;



    int status; // 0.normal / 1.defensa / 2...
    /*Tendria una lista de Items Dropeables()*/

    /*CONSTRUCTOR*/
    public Enemy(int nivel, int hp, int mp, int atk, int def, int spd,  int dinero, String name, int peso, Map abilityMap, int[] keys)
    {
        super(nivel, hp, mp, atk, def, spd, peso, abilityMap, keys);
        //this.terreno = terreno;
        this.name = name;
        this.dinero = dinero;
        this.status = 0;
    }



    /*METODOS*/

    public String getTerreno()
    {
        return terreno;
    }

    public void setTerreno(String terreno)
    {
        this.terreno = terreno;
    }

    public int getDinero()
    {
        return dinero;
    }

    public void setDinero(int dinero)
    {
        this.dinero = dinero;
    }


    @Override
    public boolean checkMana(Ability ability){
        if (this.getMp() > ability.getMPcost()){
            return true;
        }
        return false;
    }

    @Override
    public int atacar() {
        //formula de daño
        return getAtk();
    }

    @Override
    public int getDmg(int dañoRecibido){
        //formula
        if (dañoRecibido-getDef() < 0){
            return 0;
        }

        return dañoRecibido-getDef();
    }

    @Override
    public int defender() {
        setStatus(1);
        setDef(getDef() + 10); //aumenta la defensa en 10
        return 0;
    }

    @Override
    public int skillAttack(Ability ability){
        Random random = new Random();
        if(random.nextInt(100) <= ability.getPrecision()){  //agrega chances de que le erre
            return ability.getDamage();
        }
        return 0;
    }


    //este método recibe el daño real y determina si es el último hit o no
    @Override
    public boolean killingBlow(int dmg){
        if(this.getHp() > dmg){ //se puede conviertir en un método.
            this.setHp(this.getHp() - dmg);
            return false;
        }
        else{
            this.setHp(0);
            return true;
        }
    }

    @Override
    public void mpRegen(){
        setMp(getMp() + 10);
    }


    @Override
    public boolean esquivar() {
        int aux= (int) (Math.random()*100);
        if (aux<=getSpd()){
            return true;
        }
        else{
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}