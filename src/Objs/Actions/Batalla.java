package Objs.Actions;

import Objs.Entities.Enemy;
import Objs.Entities.Partner;
import java.util.List;
import java.util.Vector;

public class Batalla
{
    private Partner compa;
    private Enemy enemigo;
    private List<Turno> turnos;

    public Batalla(Partner compa, Enemy enemigo)
    {
        this.compa = compa;
        this.enemigo = enemigo;
        turnos = new Vector<>(10,2);
    }

    public void comenzarBatalla()
    {
        /*print con partnerHUD+enemyHUD+"\n"+turno*/
        compa.setVida(compa.getHp()); compa.setMana(compa.getMp());
        int vidaEnemigo=enemigo.getHp(); int manaEnemigo=enemigo.getMp();
        while(vidaEnemigo>0&&compa.getVida()>0)
        {

        }
    }

    private String partnerHUD()
    {
        return ">"+compa.getNombre()+"=> HP: "+compa.getVida()+"/"+compa.getHp()+
                "- MP: "+compa.getMana()+"/"+compa.getMp();
    }
    private String enemyHUD(int vidaEnemigo, int manaEnemigo)
    {
        return ">"+enemigo+"=> HP: "+vidaEnemigo+"/"+enemigo.getHp()+
                "- MP: "+manaEnemigo+"/"+enemigo.getMp();
    }
}

/*ACA ME FALTA LA "INTELIGENCIA ARTIFICIAL" DE LOS DIGIMONS(COMPA Y ENEMIGO)*/