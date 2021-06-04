package App;

public interface Combate {
    int atacar();
    int defender();
    boolean esquivar();
    int getDanioRecibido(int danio);
    int habilidadAtaque(Habilidad habilidad);
    void regenerarMP();

}