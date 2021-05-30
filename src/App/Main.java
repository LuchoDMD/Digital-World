package App;

import Objs.Actions.Batalla;
import Objs.Entities.*;
import Objs.Items.Tecnica;

public class Main
{
    public static void main(String[] args)
    {
        Partner compa= new Partner("Agumon","Dragon","Vacuna","Novato",10,5,800,800,80,80,80);
        compa.setNombre("Torch");
        Enemy enemi=new Enemy("Goburimon","Bestia","Virus","Novato",15,5,850,750,80,90,80,"Bosque");
        compa.agregarTecnica(new Tecnica("Rasguño","Normal",10,100,0));
        compa.agregarTecnica(new Tecnica("Colm.Fuego","Dragon",15,100,10));
        compa.agregarTecnica(new Tecnica("Flama Bebe","Dragon",25,90,20));
        enemi.agregarTecnica(new Tecnica("Golpe","Normal",15,100,0));
        enemi.agregarTecnica(new Tecnica("Mini Tornado","Bestia",10,100,10));
        enemi.agregarTecnica(new Tecnica("GoburiBomb","Bestia",20,100,15));
        /*Agregar las Tecnicas Para cada uno*/
        Batalla combate=new Batalla(compa,enemi);
        combate.comenzarBatalla();
    }
}
