package Objs;

import java.util.HashMap;

public abstract class Digimon {
    private String especie;
    private String familia;
    private String atributo;
    private String etapa;
    private int nivel;
    private int hp;
    private int mp;
    private int atk;
    private int def;
    private int spd;
    private HashMap<Integer,Tecnica> tecnicas;

    public Digimon(String especie, String familia, String atributo, String etapa, int nivel, int hp, int mp, int atk, int def, int spd) {
        this.especie = especie;
        this.familia = familia;
        this.atributo = atributo;
        this.etapa = etapa;
        this.nivel = nivel;
        this.hp = hp;
        this.mp = mp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
        tecnicas=new HashMap<>();
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Digimon{");
        sb.append("especie='").append(especie).append('\'');
        sb.append(", familia='").append(familia).append('\'');
        sb.append(", atributo='").append(atributo).append('\'');
        sb.append(", etapa='").append(etapa).append('\'');
        sb.append(", nivel=").append(nivel);
        sb.append(", hp=").append(hp);
        sb.append(", mp=").append(mp);
        sb.append(", atk=").append(atk);
        sb.append(", def=").append(def);
        sb.append(", spd=").append(spd);
        sb.append(", tecnicas=").append(tecnicas);
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
