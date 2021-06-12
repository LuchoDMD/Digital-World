package App;

public enum TamanioItem {
    CHICO (30),
    MEDIANO (70),
    GRANDE (100);

    private int recuperacion;

    TamanioItem(int recuperacion) {
        this.recuperacion = recuperacion;
    }

    public int getRecuperacion() {
        return recuperacion;
    }

    /** Se implementó la utilización de un enumerador para llevar registro de la cantidad de tamaños de todos los
     items que puedan ser creados, facilitando asi el poder recordar cuanto restaura cada uno */
}
