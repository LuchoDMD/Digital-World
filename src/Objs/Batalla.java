package Objs;

import java.util.ArrayList;
import java.util.List;

public class Batalla {
    private List<Turno>turnos;
    private Compa digimon;
    private Enemigo enemigo;

    public Batalla(Compa digimon, Enemigo enemigo) {
        this.digimon = digimon;
        this.enemigo = enemigo;
        turnos=new ArrayList<>();
    }
}
