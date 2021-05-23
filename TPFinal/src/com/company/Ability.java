package com.company;

public class Ability {
    private int damage;
    private int precision; // 0 - 100
    private int MPcost;
    private String name;

    public Ability(int damage, int precision, int MPcost, String name) {
        this.damage = damage;
        this.precision = precision;
        this.MPcost = MPcost;
        this.name = name;
    }
    //private String element;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getMPcost() {
        return MPcost;
    }

    public void setMPcost(int MPcost) {
        this.MPcost = MPcost;
    }

    /*
    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

     */


    @Override
    public String toString() {
        return "Name='" + name + '\'' +
                "damage=" + damage +
                ", precision=" + precision +
                ", MPcost=" + MPcost +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


