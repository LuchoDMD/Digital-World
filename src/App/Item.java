package App;

public abstract class Item implements Acciones {

    protected String descEfecto;
    protected int stock;
    protected int cantRestauracion;


    public String getDescEfecto() {
        return descEfecto;
    }

    public void setDescEfecto(String descEfecto) {
        this.descEfecto = descEfecto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCantRestauracion() {
        return cantRestauracion;
    }

    public void setCantRestauracion(int cantRestauracion) {
        this.cantRestauracion = cantRestauracion;
    }

    @Override
    public void tirar(int cantidad) {
        if (cantidad > this.stock) {
            this.stock = 0;
        } else {
            this.stock = this.stock - cantidad;
        }
    }
}