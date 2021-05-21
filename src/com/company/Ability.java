package com.company;

public class Ability {
    private int damage;
    private int precision;
    private int MPcost;
    private String element;

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

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "damage=" + damage +
                ", precision=" + precision +
                ", MPcost=" + MPcost +
                ", element='" + element + '\'' +
                '}';
    }
}