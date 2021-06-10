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
        if(this.stock < 100){
            this.stock = stock;
        }
        else{
            System.out.println("Inventario lleno");
        }
    }


    @Override
    public void usar(Item item, Compa partner){
        if (item instanceof Pocion){
            if (partner.getVida() + cantRestauracion > partner.getHp()){
                partner.setVida(partner.getHp());
            } else {
                partner.setVida(partner.getVida() + cantRestauracion);
            }
            stock--;
        }
        if (item instanceof Elixir){
            if (partner.getMana() + cantRestauracion > partner.getMp()){
                partner.setMana(partner.getMp());
            } else {
                partner.setMana(partner.getMana() + cantRestauracion);
            }
            stock--;
        }
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