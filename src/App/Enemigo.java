package App;

public class Enemigo extends Digimon{

    // Variable para almacenar la cantidad de experiencia actual del partner

    int partnerXP;

    public Enemigo(String nombre, int partnerXP) {
        super(nombre, (int) (Math.random() * partnerXP + partnerXP/3 + 5), (int) (Math.random() * (partnerXP/4 + 2) + 1));
        this.partnerXP = partnerXP;
    }

    @Override
    public int atacar() {
        return (int) (Math.random() * partnerXP/4 + 1) + xp/4 + 3;
    }

    @Override
    public int defender() {
        return (int) (Math.random() * partnerXP/4 + 1) + xp/4 + 3;
    }
}

