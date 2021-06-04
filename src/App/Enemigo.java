package App;

import java.util.*;
import java.util.Map;

public class Enemigo extends Digimon implements Combate {

    // ATRIBUTOS \\

    private String terreno; /** Indica en el tipo de terreno que puede aparecer */
    private String nombre;
    private int estado; // 0.normal / 1.defensa / 2...
    /*Tendria una lista de Items Dropeables()*/

    // CONSTRUCTOR \\

    public Enemigo(int nivel, int hp, int mp, int ataque, int defensa, int velocidad, String nombre, int peso, Map mapaHabilidades, int[] keys) {
        super(nivel, hp, mp, ataque, defensa, velocidad, peso, mapaHabilidades, keys);
        //this.terreno = terreno;
        this.nombre = nombre;
        this.estado = 0;
    }

    // GETTERS Y SETTERS \\

    public String getTerreno()
    {
        return terreno;
    }

    public void setTerreno(String terreno)
    {
        this.terreno = terreno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // METODOS \\

    @Override
    public boolean verificarMana(Habilidad habilidad){
        return this.getMp() > habilidad.getCostoMP();
    }

    @Override
    public int atacar() {
        //formula de daño
        return getAtaque();
    }

    @Override
    public int getDanioRecibido(int danioRecibido){
        //formula
        if (danioRecibido-getDefensa() < 0){
            return 0;
        }

        return danioRecibido-getDefensa();
    }

    @Override
    public int defender() {
        setEstado(1);
        setDefensa(getDefensa() + 10); //aumenta la defensa en 10
        return 0;
    }

    @Override
    public int habilidadAtaque(Habilidad habilidad){
        Random random = new Random();
        if(random.nextInt(100) <= habilidad.getPrecision()){  //agrega chances de que le erre
            return habilidad.getDanio();
        }
        return 0;
    }


    //este método recibe el daño real y determina si es el último hit o no
    @Override
    public boolean golpeRematador(int danio){
        if(this.getHp() > danio){ //se puede conviertir en un método.
            this.setHp(this.getHp() - danio);
            return false;
        }
        else{
            this.setHp(0);
            return true;
        }
    }

    @Override
    public void regenerarMP(){
        setMp(getMp() + 10);
    }


    @Override
    public boolean esquivar() {
        int aux= (int) (Math.random()*100);
        return aux <= getVelocidad();
    }

}

