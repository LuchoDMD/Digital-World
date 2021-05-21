package Objs.Actions;

import Objs.Entities.Enemy;
import Objs.Entities.Partner;
import java.util.List;
import java.util.Vector;

public class Batalla
{
    private Partner compa;
    private Enemy enemigo;
    private int vidaEnemigo, manaEnemigo;
    private List<Turno> turnos;

    public Batalla(Partner compa, Enemy enemigo)
    {
        this.compa = compa;
        this.enemigo = enemigo;
        turnos = new Vector<>(10,2);
    }

    public void comenzarBatalla()
    {
        System.out.println(primeHUD());
        compa.setVida(compa.getHp()); compa.setMana(compa.getMp());
        vidaEnemigo=enemigo.getHp(); manaEnemigo=enemigo.getMp();
        while(vidaEnemigo>0&&compa.getVida()>0)
        {

        }
    }

    private String partnerHUD()
    {
        return ">"+compa.getNombre()+"=> HP: "+compa.getVida()+"/"+compa.getHp()+
                "- MP: "+compa.getMana()+"/"+compa.getMp();
    }
    private String enemyHUD()
    {
        return ">"+enemigo+"=> HP: "+vidaEnemigo+"/"+enemigo.getHp()+
                "- MP: "+manaEnemigo+"/"+enemigo.getMp();
    }
    public String primeHUD()
    {
        return partnerHUD()+"\n"+enemyHUD();
    }

}
