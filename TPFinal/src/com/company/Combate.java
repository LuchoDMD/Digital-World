package com.company;

public interface Combate {
    int atacar();
    int defender();
    boolean esquivar();
    int getDmg(int dmg);
    int skillAttack(Ability ability);
    void mpRegen();

}
