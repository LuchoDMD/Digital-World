package Objs;

public class Enemigo extends Digimon implements ICombate{
    private String terreno;
    //private Item/Enum item;
    //private int oro;


    public Enemigo(String especie, String familia, String atributo, String etapa, int nivel, int hp, int mp, int atk, int def, int spd, String terreno) {
        super(especie, familia, atributo, etapa, nivel, hp, mp, atk, def, spd);
        this.terreno = terreno;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }



    @Override
    public void atacar() {

    }

    @Override
    public void defender() {

    }

    @Override
    public void esquivar() {

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Enemigo{");
        sb.append(super.toString());
        sb.append("terreno='").append(terreno).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
