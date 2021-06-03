package App;

public class Habilidad {
    private int danio;
    private int precision; // 0 - 100
    private int costoMP;
    private String nombre;

    public Habilidad(int danio, int precision, int costoMP, String nombre) {
        this.danio = danio;
        this.precision = precision;
        this.costoMP = costoMP;
        this.nombre = nombre;
    }
    //private String element;

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

    /*
    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

     */


    @Override
    public String toString() {
        return "Nombre habilidad: ['" + nombre + '\'' +
                "Daño: " + danio +
                ", Precision: " + precision +
                ", Costo MP: " + costoMP +
                ']';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        this.nombre = nombre;
    }
}