package Objs.Actions;

public class Turno
{
    private String digimon1, digimon2, accion;
    private int dmg;

    public Turno(String digimon1, String digimon2, String accion, int dmg)
    {
        this.digimon1 = digimon1;
        this.digimon2 = digimon2;
        this.accion = accion;
        this.dmg = dmg;
    }

    /*Podria haber 2 constructores mas: uno por si falla el ataque y otro por si el ataque es esquivado*/

    @Override
    public String toString()
    {
        return digimon1+" realizo "+accion+", "+dmg+" puntos de daño a "+digimon2+".";
    }
}
