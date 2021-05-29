package Objs.Items;

public class Tecnica
{
    private String nombre, familia;
    private int potencia, precision, costoMP;
    /*Pensar como agregar el efecto si posee y crear unos metodos que los apliquen*/
    public Tecnica(String nombre, String familia, int potencia, int precision, int costoMP)
    {
        this.nombre = nombre;
        this.familia = familia;
        this.potencia = potencia;
        this.precision = precision;
        this.costoMP = costoMP;
    }

    public String getNombre() {
        return nombre;
    }
    public String getFamilia() {
        return familia;
    }
    public int getPotencia() {
        return potencia;
    }
    public int getPrecision() {
        return precision;
    }
    public int getCostoMP() {
        return costoMP;
    }

    @Override
    public String toString() {
        return  ">Nombre: " +nombre +
                ".\n>Familia: "+familia +
                ".\n>Potencia: "+potencia +
                ".\n>Precision: "+precision+
                ".\n>CostoMP: " +costoMP+".";
    }
}
