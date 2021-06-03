package App;

public class Pocion extends Item{

    public Pocion(String descEfecto, int stock, int cantRestauracion) {
        this.descEfecto=descEfecto;
        this.stock=stock;
        this.cantRestauracion=cantRestauracion;
    }

    @Override
    public void usar(Companiero companiero) {
        if (companiero.getVida() + cantRestauracion > companiero.getHp()){
            companiero.setVida(companiero.getHp());
        } else {
            companiero.setVida(companiero.getVida() + cantRestauracion);
        }
        stock--;
    }

    @Override
    public String toString() {
        return "Pocion [" +
                "Desc.: '" + descEfecto + '\'' +
                ", Stock: " + stock +
                ", Cant. Restauracion: " + cantRestauracion +
                ']';
    }


}
