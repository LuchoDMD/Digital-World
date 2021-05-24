package Objs.Actions;

import Objs.Entities.Digimon;
import Objs.Entities.Enemy;
import Objs.Entities.Partner;
import Objs.Items.Tecnica;
import com.sun.security.jgss.GSSUtil;

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
        int dmg=-1, tecnica=0; Turno t;
        while(vidaEnemigo>0&&compa.getVida()>0)
        {
            System.out.println(partnerHUD()+" "+enemyHUD(vidaEnemigo,manaEnemigo));
            if(enemigo.getSpd()>compa.getSpd())
            {
                tecnica=((int)Math.random()*2);
                dmg=enemigo.atacar(tecnica);
                if(enemigo.esquivar()>compa.esquivar()&&((int)Math.random()*1)==1)
                {/*Aca pido 2ble conprobacion para que sea mas realista el esquivar*/
                    compa.setVida(dmg-compa.defender());
                    t=new Turno(enemigo.getEspecie(),compa.getNombre(),enemigo.getNombreTecnica(tecnica),dmg);
                    turnos.add(t);
                }else
                    {
                        t=new Turno(enemigo.getEspecie(),compa.getNombre(),compa.getNombre()+" lo ha esquivado",0);
                        turnos.add(t);
                        if(compa.getMana()<compa.getMp())
                        {
                            compa.setMana(compa.getMana()+(compa.getNivel()*10));
                        }else if (compa.getMana()>compa.getMp())
                            {
                                compa.setMana(compa.getMp());
                            }
                    }
                    System.out.println(t);
            }else
                {
                    tecnica=compa.seleccionarTecnica();
                    dmg=compa.atacar(tecnica);
                    if(compa.esquivar()<compa.esquivar()&&((int)Math.random()*1)==1)
                    {/*Aca pido 2ble conprobacion para que sea mas realista el esquivar*/
                        vidaEnemigo=dmg-enemigo.defender();
                        t=new Turno(compa.getNombre(),enemigo.getEspecie(), compa.getNombreTecnica(tecnica),dmg);
                        turnos.add(t);
                    }else
                        {
                            t=new Turno(enemigo.getEspecie(),compa.getNombre(),compa.getNombre()+" lo ha esquivado",0);
                            turnos.add(t);
                            if(manaEnemigo<enemigo.getMp())
                            {
                                manaEnemigo=manaEnemigo+(compa.getNivel()*10);
                            }else if(manaEnemigo>enemigo.getMp())
                            {
                                manaEnemigo=compa.getMp();
                            }
                        }
                    System.out.println(t);
                }
        }

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
        return ">"+enemigo+"=> HP: "+vidaEnemigo+"/"+enemigo.getHp()+
                "- MP: "+manaEnemigo+"/"+enemigo.getMp();
    }
}

/*NO TOMEN EN CUENTA ESTA CLASE DE MI REPOSITORIO Y SI VEN ALGO UTIL DE ACA AVISEN*/