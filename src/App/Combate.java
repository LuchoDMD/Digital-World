package App;

public interface Combate {
    int atacar();
    int defender();
    boolean esquivar();
    int getDmg(int dmg);
    int skillAttack(Habilidad ability);
    void mpRegen();

}