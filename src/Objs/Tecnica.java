package Objs;

public class Tecnica {
    private String familia;
    private int potencia;
    private int presicion;
    private String categoria;
    private int costoMP;

    public Tecnica(String familia, int potencia, int presicion, String categoria, int costoMP) {
        this.familia = familia;
        this.potencia = potencia;
        this.presicion = presicion;
        this.categoria = categoria;
        this.costoMP = costoMP;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getPresicion() {
        return presicion;
    }

    public void setPresicion(int presicion) {
        this.presicion = presicion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCostoMP() {
        return costoMP;
    }

    public void setCostoMP(int costoMP) {
        this.costoMP = costoMP;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tecnica\n");
        sb.append(" Familia: ").append(familia);
        sb.append(", Potencia: ").append(potencia);
        sb.append(", Presicion: ").append(presicion);
        sb.append(", Categoria: ").append(categoria);
        sb.append(", CostoMP: ").append(costoMP);
        return sb.toString();
    }
}
