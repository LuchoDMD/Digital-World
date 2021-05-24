package App;

public abstract class Digimon {

    // Atributos comunes a todos los Digimon

    protected String nombre;
    protected int maxHp;
    protected int hp;
    protected int xp;

    // Constructor para el Digimon

    public Digimon (String nombre, int maxHp, int xp) {
        this.nombre = nombre;
        this.maxHp = maxHp;
        this.xp = xp;
        this.hp = maxHp;
    }

    // Metodos comunes a todos los Digimon

    public abstract int atacar();
    public abstract int defender();


}