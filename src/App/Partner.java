package App;

public class Partner extends Digimon {

    // Entero para almacenar el numero de tecnicas

    public int cantTecnicasOfensivas;
    public int cantTecnicasDefensivas;

    // Arreglo para almacenar la lista de tecnicas del Digimon

    public String[] tecnicaOfensiva = {"Corte de trompa", "Patada voladora", "Coletazo infernal", "Mega rayo destructivo", "Extincion"};
    public String[] tecnicaDefensiva = {"Piel de acero", "Barrera de luz", "Proteccion divina", "Manto de tierra", "Invisibilidad temporal"};

    // Constructor para la clase Partner

    public Partner(String nombre, int maxHp, int xp) {
        super(nombre, maxHp, xp);
        // Seteando la cantidad de tecnicas a cero.
        this.cantTecnicasOfensivas = 0;
        this.cantTecnicasDefensivas = 0;
        // Elegir tecnicas
        elegirTecnicas();
    }

    // Metodos especificos de la clase Partner

    @Override
    public int atacar() {
        return (int) (Math.random() * (xp/4 + cantTecnicasOfensivas * 3 + 3) + cantTecnicasOfensivas * 2 + cantTecnicasDefensivas + 1);
    }

    @Override
    public int defender() {
        return (int) (Math.random() * (xp/4 + cantTecnicasDefensivas * 3 + 3) + cantTecnicasDefensivas * 2 + cantTecnicasOfensivas + 1);
    }

    public void elegirTecnicas() {
        GameLogic.limpiarConsola();
        GameLogic.imprimirEncabezado("Elija una tecnica disponible (ofensiva o defensiva): ");
        System.out.println("1) " + tecnicaOfensiva[cantTecnicasOfensivas]);
        System.out.println("2) " + tecnicaDefensiva[cantTecnicasDefensivas]);
        int aux = tecnicaDefensiva.length;

        int input = GameLogic.leerInput("---> ", aux);
        GameLogic.limpiarConsola();

        if (input == 1) {
            GameLogic.imprimirEncabezado("Usted ha elegido: " + tecnicaOfensiva[cantTecnicasOfensivas] + "!");
            cantTecnicasOfensivas++;
        } else {
            GameLogic.imprimirEncabezado("Usted ha elegido: " + tecnicaDefensiva[cantTecnicasDefensivas] + "!");
            cantTecnicasDefensivas++;
        }
        GameLogic.systemPause();
    }
}

