package App;

public class Elixir extends Item{

    public Elixir(String descEfecto, int stock, int cantRestauracion) {
        this.descEfecto=descEfecto;
        this.stock=stock;
        this.cantRestauracion=cantRestauracion;
    }

    @Override
    public void usar(Companiero companiero) {
        if (companiero.getMana() + cantRestauracion > companiero.getMp()){
            companiero.setMana(companiero.getMp());
        } else {
            companiero.setMana(companiero.getMana() + cantRestauracion);
        }
        stock--;
    }

    @Override
    public String toString() {
        return "Elixir [" +
                "Desc.: '" + descEfecto + '\'' +
                ", Stock: " + stock +
                ", Cant Restauracion: " + cantRestauracion +
                ']';
    }
}
