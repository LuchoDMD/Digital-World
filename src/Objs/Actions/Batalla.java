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
        int dmg=-1;
        while(vidaEnemigo>0&&compa.getVida()>0)
        {
            if(enemigo.getSpd()>compa.getSpd())
            {
                dmg=enemigo.atacar((int)Math.random()*2);
                if(enemigo.esquivar()>compa.esquivar()&&((int)Math.random()*1)==0)
                {
                    compa.setVida(dmg-compa.defender());
                }
            }else
                {
                    dmg=compa.atacar(compa.seleccionarTecnica());
                    if(compa.esquivar()<compa.esquivar()&&((int)Math.random()*1)==0)
                    {
                        vidaEnemigo=dmg-enemigo.defender();
                    }
                }
        }
    }/*Falta agregar dos metodos que resten y agreguen mp al esquivar asi se recarga la
        energia para seguir atacando*/

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