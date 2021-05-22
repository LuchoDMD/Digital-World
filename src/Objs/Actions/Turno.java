package Objs.Actions;

import Objs.Items.Tecnica;

public class Turno
{
    private String digimon1, digimon2, accion;
    private int dmg;

    public Turno()
    {
        this.digimon1="";
        this.digimon2="";
        this.accion="";
        this.dmg=0;
    }

    public Turno(String digimon1, String digimon2, String accion, int dmg)
    {
        this.digimon1 = digimon1;
        this.digimon2 = digimon2;
        this.accion = accion;
        this.dmg = dmg;
    }

    @Override
    public String toString()
    {
        return digimon1+" realizo "+accion+", "+dmg+" puntos de daño a "+digimon2+".";
    }
}
