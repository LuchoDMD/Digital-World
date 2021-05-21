package com.company;
import java.util.List;

public class Enemy extends Digimon implements Combate {
    /*ATRIBUTOS*/
    private String terreno;/*Indica en el tipo de terreno que puede aparecer*/
    private int dinero;
    String name;



    int status; // 0.normal / 1.defensa / 2...
    /*Tendria una lista de Items Dropeables()*/

    /*CONSTRUCTOR*/
    public Enemy(int nivel, int hp, int mp, int atk, int def, int spd,  int dinero, String name)
    {
        super(nivel, hp, mp, atk, def, spd);
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int atacar() {
        //formula de daño
        return getAtk();
    }

    @Override
    public int getDmg(int dañoRecibido){
        //formula
        return dañoRecibido-getDef();
    }

    @Override
    public int defender() {
        setStatus(1);
        setDef(getDef() + 10); //aumenta la defensa en 10
        return 0;
    }



    @Override
    public int esquivar() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}