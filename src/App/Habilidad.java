package App;

public class Habilidad {

    // ATRIBUTOS \\

    private int danio;
    private int precision; // 0 - 100
    private int costoMP;
    private String nombre;

    // CONSTRUCTORES \\

    public Habilidad(int danio, int precision, int costoMP, String nombre) {
        this.danio = danio;
        this.precision = precision;
        this.costoMP = costoMP;
        this.nombre = nombre;
    }

    // GETTERS Y SETTERS \\

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getCostoMP() {
        return costoMP;
    }

    public void setCostoMP(int costoMP) {
        this.costoMP = costoMP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // METODOS \\

    @Override
    public String toString() {
        return "Nombre: ['" + nombre + '\'' +
                "Daño: " + danio +
                ", Precision: " + precision +
                ", Costo de MP: " + costoMP +
                ']';
    }
}