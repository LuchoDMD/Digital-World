package App;

public class Turno {
    String atacante;
    String defensor;
    int damage;
    int turno;
    String ataque;

    public Turno(String atacante, String defensor, int damage, int turno) {
        this.atacante = atacante;
        this.defensor = defensor;
        this.damage = damage;
        this.turno = turno;
        this.ataque = "Ataque Básico";
    }

    //este constructor obtiene el nombre de la habilidad lanzada
    public Turno(String atacante, String defensor, int damage, int turno, String ataque) {
        this.atacante = atacante;
        this.defensor = defensor;
        this.damage = damage;
        this.turno = turno;
        this.ataque = ataque;
    }


    public String getAtacante() {
        return atacante;
    }

    public void setAtacante(String atacante) {
        this.atacante = atacante;
    }

    public String getDefensor() {
        return defensor;
    }

    public void setDefensor(String defensor) {
        this.defensor = defensor;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Turno{" +
                atacante + " atacó a " + defensor + " por un daño de: " + damage + " con " + ataque +
                '}';
    }
}
