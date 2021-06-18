package com.mygdx.game.App;

import java.util.Map;
import java.util.Random;

public class Compa extends Digimon implements Combate {

    // ATRIBUTOS \\

    private final String nombre;

    private int vida; /*Vida actual del Digimon*/
    private int mana; /*Mana actual del Digimon*/
    private int experiencia; /*Experiencia*/


    // CONSTRUCTORES \\

    public Compa(int nivel, int hp, int mp, int ataque, int defensa, int velocidad, String nombre, int peso, Map mapaHabilidades, int[] keys)
    {
        super(nivel, hp, mp, ataque, defensa, velocidad, peso, mapaHabilidades, keys);
        this.vida = hp;
        this.mana = mp;
        this.experiencia = 0;
        this.nombre = nombre;
    }

    // GETTERS Y SETTERS \\

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
    public int getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }


    // METODOS \\

    public int elegirItem(Mochila mochila){
        if(!mochila.getListaBolsillo().isEmpty()){
            int bound = mochila.getListaBolsillo().size();
            Random random = new Random();
            return random.nextInt(bound);
        }
        return -1;
    }

    private int rangoExperiencia()/*Formula de Rango de experiencia de siguiente nivel*/
    {
        return (getNivel()*(getAtaque()+getDefensa()+getVelocidad()))/10;
    }

    private void subidaNivel()/*Subida de Nivel*/
    {
        if(experiencia==rangoExperiencia())
        {
            setExperiencia(0);
            setNivel(getNivel()+1);
            /*subeStats();*/
        }
    }

    @Override
    public boolean fallo(Habilidad habilidad){
        if(habilidadAtaque(habilidad) == 0){
            return true;
        }
        return false;
    }

    @Override
    public int atacar()
    {
        return getAtaque();
    }

    @Override
    public int defender()
    {
        setEstado(1);
        setDefensa(getDefensa() + 10); //aumenta la defensa en 10
        return 0;
    }

    @Override
    public boolean verificarMana(Habilidad habilidad){
        return this.getMana() > habilidad.getCostoMP();
    }

    //este método recibe el daño real y determina si es el último hit o no
    @Override
    public boolean golpeRematador(int danio){
        if(this.getVida() > danio){ //se puede conviertir en un método.
            this.setVida(this.getVida() - danio);
            return false;
        }
        else{
            this.setVida(0);
            return true;
        }
    }

    @Override
    public void regenerarMP(){
        setMana(getMana() + 10);
    }

    @Override
    public int habilidadAtaque(Habilidad habilidad){
        Random random = new Random();
        if(random.nextInt(100) <= habilidad.getPrecision()){  //agrega chances de que le erre
            return habilidad.getDanio();
        }
        return 0;
    }

    @Override
    public boolean esquivar()
    {
        int aux= (int) (Math.random()*100);
        return aux <= getVelocidad();
    }

    @Override
    public int getDanioRecibido(int danioRecibido){
        //formula
        if (danioRecibido-getDefensa() < 0){
            return 0;
        }

        return danioRecibido-getDefensa();
    }

    @Override
    public String toString() {
        return "Compa [" +
                "Nombre: '" + nombre + '\'' +
                ", Vida: " + vida +
                ", Mana: " + mana +
                ", XP: " + experiencia +
                ']';
    }
}

