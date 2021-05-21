package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Batalla
{
    /*ATRIBUTOS*/
    protected Partner compa;
    protected Enemy enemigo;
    private List<CombatLog> log;    //logs del combate

    /*CONSTRUCTOR*/
    public Batalla(Partner compa, Enemy enemigo)
    {
        this.compa = compa;
        this.enemigo = enemigo;
        log = new ArrayList<>();
    }

    public boolean isFaster(){      //clase que compara la velocidad del compa con la velocidad del enemigo
        boolean flag = false;   //por defecto devuelve False si el enemigo es más rapido
        if (compa.getSpd() > enemigo.getSpd()){
            flag = true;        //siempre que devuelva true será porque el compa es más rápido
        }
        return flag;
    }

    public void comenzarBatalla(){      //Método donde se realizará el bucle de combate
        int turno = 1;
        while ((enemigo.getHp() > 0 ) && (compa.getVida() > 0)){    //Cuando alguno de los dos tenga 0 o menos de vida, termina el combate
            if(isFaster()){
                clearPartnerStatus();
                switch (MenuCombate()){
                    case 1:
                        enemigo.setHp(enemigo.getHp() - enemigo.getDmg(compa.atacar()));
                        log.add(new CombatLog(compa.getNombre(), enemigo.getName(), enemigo.getDmg(compa.atacar()), turno));
                        break;
                    case 2:
                        compa.defender();
                        break;
                    case 3:
                        compa.esquivar();
                        break;
                }
                clearEnemyStatus();
                switch (botEnemy()){
                    case 0:
                        System.out.println("EL BOT ATACA");
                        compa.setVida(compa.getVida() - compa.getDmg(enemigo.atacar()));
                        log.add(new CombatLog(enemigo.getName(), compa.getNombre(), compa.getDmg(enemigo.atacar()), turno));
                        break;
                    case 1:
                        enemigo.defender();
                        System.out.println("EL BOT se prepara para defender");
                        break;
                    case 2:
                        System.out.println("EL BOT se prepara para esquivar");
                        enemigo.esquivar();
                        break;
                }
                printMenuStatus();
            }
            else{
                clearEnemyStatus();
                switch (botEnemy()){
                    case 0:
                        System.out.println("EL BOT ATACA");
                        compa.setVida(compa.getVida() - compa.getDmg(enemigo.atacar()));
                        log.add(new CombatLog(enemigo.getName(), compa.getNombre(), compa.getDmg(enemigo.atacar()), turno));
                        break;
                    case 1:
                        enemigo.defender();
                        System.out.println("EL BOT se prepara para defender");
                        break;
                    case 2:
                        enemigo.esquivar();
                        System.out.println("EL BOT se prepara para esquivar");
                        break;
                }
                printMenuStatus();
                clearPartnerStatus();
                switch (MenuCombate()){
                    case 1:
                        enemigo.setHp(enemigo.getHp() - enemigo.getDmg(compa.atacar()));
                        log.add(new CombatLog(compa.getNombre(), enemigo.getName(), enemigo.getDmg(compa.atacar()), turno));
                        break;
                    case 2:
                        compa.defender();
                        break;
                    case 3:
                        compa.esquivar();
                        break;
                }
            }
            turno++;
        }
        System.out.println(printLog());


    }

    private String printLog(){
        String rda = "";
        for(CombatLog variable : log){
            rda = rda + variable.toString() + "\n";
        }
        return rda;
    }

    public int botEnemy(){  //bot actúa semi aleatorio
        Random random = new Random();
        if(compa.getVida() < compa.getVida() / 3){  //el bot ataca cuando el player tiene menos de 1/3 de vida
            return 0; //full tryhard se pone el bot
        }
        if (compa.getStatus() == 1 && isFaster()){  //si el jugador se defiende primero, el BOT tambien
            return 1;
        }
        else{
            int action = random.nextInt(3); // 0, 1 , 2
            return action;
        }
    }

    public void printMenuStatus(){
        System.out.println("Enemy:                      Player:");
        System.out.println("HP: " + enemigo.getHp() + "                     HP: " + compa.getVida());
    }

    public int MenuCombate(){      //
        int input = -1; //variable de control
        while(input != 1 && input != 2 && input != 3){
            imprimirMenuCombate();
            Scanner scan = new Scanner(System.in);
            input = scan.nextInt();
        }
        return input;
    }

    public void clearEnemyStatus(){    //método que se usa al terminar el turno para remover los status
        if (enemigo.getStatus() == 1){
            enemigo.setDef(enemigo.getDef() - 10);
            enemigo.setStatus(0);
        }
    }

    public void clearPartnerStatus(){    //método que se usa al terminar el turno para remover los status
        if (compa.getStatus() == 1){
            compa.setDef(compa.getDef() - 10);
            compa.setStatus(0);
        }
    }

    public void imprimirMenuCombate(){
        System.out.println("presione 1 para Atacar");
        System.out.println("presione 2 para Defender");
        System.out.println("presione 3 para Esquivar");
    }

    /*METODOS*/

}