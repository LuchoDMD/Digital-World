package Objs.Actions;

import Objs.Entities.*;
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
        this.turnos = new Vector<>(10,2);
    }

    public void comenzarBatalla()
    {
        /*print con partnerHUD+enemyHUD+"\n"+turno*/
        int vidaEnemigo=enemigo.getHp(); int manaEnemigo=enemigo.getMp();
        int dmg, tecnica; Turno t;
        while(vidaEnemigo>0&&compa.getVida()>0)
        {
            System.out.println(partnerHUD()+" "+enemyHUD(vidaEnemigo,manaEnemigo));
            if((Math.floor(Math.random()*3)>=1))
            {
                tecnica=((int)Math.random()*2);
                dmg=enemigo.atacar(tecnica);
                compa.setVida(compa.getVida()-(dmg-compa.defender()));
                t=new Turno(enemigo.getEspecie(),compa.getNombre(),enemigo.getNombreTecnica(tecnica),dmg);
            }else
            {
                tecnica=compa.seleccionarTecnica();
                dmg=compa.atacar(tecnica);
                vidaEnemigo=vidaEnemigo-(dmg-enemigo.defender());
                t=new Turno(compa.getNombre(),enemigo.getEspecie(), compa.getNombreTecnica(tecnica),dmg);
            }
            turnos.add(t);
            System.out.println(t);
        }
        /*Rehacerla*/

        /*FALTARIA UNA ULTIMA COMPROBACION DE SI ALGUNO QUEDO DEBILITADO SI QUEDA
         * EJ: SI ENEMIGO QUEDA DEBILITADO PROCEDE A DROPEAR EXPERIENCIA DINERO Y ITEMS(Si tiene)
         * CASO CONTRARIO SI COMPA QUEDA DEBILIDADO PASAMOS A CORRER A LA CIUDAD PRINCIPAL(C DIGIMON xD)*/
    }

    private String partnerHUD()
    {
        return ">"+compa.getNombre()+"=> HP: "+compa.getVida()+"/"+compa.getHp()+
                "- MP: "+compa.getMana()+"/"+compa.getMp();
    }

    private String enemyHUD(int vidaEnemigo, int manaEnemigo)
    {
        return ">"+enemigo.getEspecie()+"=> HP: "+vidaEnemigo+"/"+enemigo.getHp()+
                "- MP: "+manaEnemigo+"/"+enemigo.getMp();
    }

    /*Agregar metodos para comprobar si el ataque se realiza. Y uno por si esquiva.
     * */
}
