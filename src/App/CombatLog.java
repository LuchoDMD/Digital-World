package App;

public class CombatLog {
    String atacante;
    String defensor;
    int danio;
    int turno;
    String ataque;

    public CombatLog(String atacante, String defensor, int danio, int turno) {
        this.atacante = atacante;
        this.defensor = defensor;
        this.danio = danio;
        this.turno = turno;
        this.ataque = "Ataque Básico";
    }

    //este constructor obtiene el nombre de la habilidad lanzada
    public CombatLog(String atacante, String defensor, int danio, int turno, String ataque) {
        this.atacante = atacante;
        this.defensor = defensor;
        this.danio = danio;
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

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "CombatLog [" +
                atacante + " atacó a " + defensor + " por un daño de: " + danio + " con " + ataque +
                ']';
    }
}
