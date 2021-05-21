package Objs;

public  class Compa extends Digimon implements ICombate{
    private String nombre;
    private int peso;
    private int vida;//vida que va a fluctuar
    private int mana;//mana que va a fluctuar
    private int xp;

    public Compa(String nombre, String especie, String familia, String atributo, String etapa, int nivel, int hp, int mp, int atk, int def, int spd, int peso, int vida, int mana, int xp) {
        super(especie, familia, atributo, etapa, nivel, hp, mp, atk, def, spd);
        this.nombre = nombre;
        this.peso = peso;
        this.vida = vida;
        this.mana = mana;
        this.xp = xp;
    }

    @Override
    public void atacar(){}

    @Override
    public void defender(){}

    @Override
    public void esquivar(){}

}
