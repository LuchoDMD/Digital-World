package App;

import java.util.Map;

public abstract class Digimon {
    
    // ATRIBUTOS \\
    private int nivel;
    private int hp;/*VIDA*/
    private int mp;/*MANA*/
    private int ataque;/*ATAQUE*/
    private int defensa;/*DEFENSA*/
    private int velocidad;/*VELOCIDAD*/ //poder de ataque
    private int estado;
    private final int peso;
    public Habilidad[] habilidades;

    // CONSTRUCTORES \\

    public Digimon(int nivel, int hp, int mp, int ataque, int defensa, int velocidad, int peso, Map mapaHabilidades, int[] keys) {
        this.nivel = nivel;
        this.peso = peso;
        this.hp = hp;
        this.mp = mp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.estado = 0;
        this.habilidades = new Habilidad[4];    //los digimon solo pueden tener 4 habilidades
        cargarHabilidades(mapaHabilidades, keys);
    }

    public void cargarHabilidades(Map mapaHabilidades, int[] keys){
        for (int i = 0 ; i < 4 ; i++){
            habilidades[i] = (Habilidad) mapaHabilidades.get(keys[i]);
        }
    }

    //método para saber si el hit va a ser el que remate o no (para evitar dejarlo con vida negativa)
    public abstract boolean golpeRematador(int danio);

    //check para saber si tiene mana suficiente para lanzar el skill
    public abstract boolean verificarMana(Habilidad habilidad);

    public void limpiarEstado(){    //método que se usa al terminar el turno para remover los status
        if (this.getEstado() == 1){
            this.setDefensa(this.getDefensa() - 10);
            this.setEstado(0);
        }
    }

    // GETTERS Y SETTERS \\

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if(nivel>101)
        {
            this.nivel = nivel;
        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if(hp<10000)
        {
            this.hp = hp;
        }
    }

    public int getMp()
    {
        return mp;
    }

    public void setMp(int mp)
    {
        if(mp<10000)
        {
            this.mp = mp;
        }
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        if(ataque<1000)
        {
            this.ataque = ataque;
        }
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa)
    {
        if(defensa<1000)
        {
            this.defensa = defensa;
        }
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        if(velocidad<1000)
        {
            this.velocidad = velocidad;
        }
    }

    public Habilidad[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Habilidad[] habilidades) {
        this.habilidades = habilidades;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}