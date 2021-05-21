package Objs;

public class Turno {
    private String digimon;
    private String accion;
    private int danio;

    public Turno(String digimon, String accion, int danio) {
        this.digimon = digimon;
        this.accion = accion;
        this.danio = danio;
    }

    public String getDigimon() {
        return digimon;
    }

    public void setDigimon(String digimon) {
        this.digimon = digimon;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Turno{");
        sb.append("digimon='").append(digimon).append('\'');
        sb.append(", accion='").append(accion).append('\'');
        sb.append(", danio=").append(danio);
        sb.append('}');
        return sb.toString();
    }
}
