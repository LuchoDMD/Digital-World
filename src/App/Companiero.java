package App;

import java.util.Map;
import java.util.Random;

public class Companiero extends Digimon implements Combate {
    /*ATRIBUTOS*/
    private final String nombre;
    private int vida;/*Vida actual del Digimon*/
    private int mana;/*Mana actual del Digimon*/
    private int exp;/*Experiencia*/
    //private int aptitud;


    public Companiero(int nivel, int hp, int mp, int ataque, int defensa, int velocidad, String nombre, int peso, Map mapaHabilidades, int[] keys)
    {
        super(nivel, hp, mp, ataque, defensa, velocidad, peso, mapaHabilidades, keys);
        this.vida = hp;
        this.mana = mp;
        this.exp = 0;
        this.nombre = nombre;
    }

    /*GETTERS AND SETTERS*/
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        nombre = nombre;
    }
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }


    @Override
    public int atacar()
    {
        return getAtaque();
    }

    @Override
    public int defender()
    {
        setEstado(1);
        setDefensa(getDefensa() + 10); //aumenta la defensa en 10
        return 0;
    }

    @Override
    public boolean verificarMana(Habilidad habilidad){
        return this.getMana() > habilidad.getCostoMP();
    }

    //este método recibe el daño real y determina si es el último hit o no
    @Override
    public boolean golpeRematador(int danio){
        if(this.getVida() > danio){ //se puede conviertir en un método.
            this.setVida(this.getVida() - danio);
            return false;
        }
        else{
            this.setVida(0);
            return true;
        }
    }

    @Override
    public void regenerarMP(){
        setMana(getMana() + 10);
    }

    @Override
    public int habilidadAtaque(Habilidad habilidad){
        Random random = new Random();
        if(random.nextInt(100) <= habilidad.getPrecision()){  //agrega chances de que le erre
            return habilidad.getDanio();
        }
        return 0;
    }

    @Override
    public boolean esquivar()
    {
        int aux= (int) (Math.random()*100);
        return aux <= getVelocidad();
    }

    @Override
    public int getDanio(int danio){
        //formula
        if (danio-getDefensa() < 0){
            return 0;
        }

        return danio-getDefensa();
    }

    @Override
    public String toString() {
        return "Companiero [" +
                "Nombre: '" + nombre + '\'' +
                ", Vida: " + vida +
                ", Mana: " + mana +
                ", XP: " + exp +
                ']';
    }
}

