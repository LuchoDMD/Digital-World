package com.company;

public interface Combate {
    int atacar();
    int defender();
    int esquivar();
    int getDmg(int dmg);
    int skillAttack(Ability ability);

}
