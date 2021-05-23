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
                    case 4:
                        int action = menuSkills();
                        enemigo.setHp(enemigo.getHp() - enemigo.getDmg(compa.skillAttack(compa.abilities[action-1])));
                        log.add(new CombatLog(compa.getNombre(), enemigo.getName(), enemigo.getDmg(compa.skillAttack(compa.abilities[action-1])), turno, compa.abilities[action-1].getName()));
                        break;
                }
                clearSrc();
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
                    case 4:
                        int action = menuSkills();
                        enemigo.setHp(enemigo.getHp() - enemigo.getDmg(compa.skillAttack(compa.abilities[action-1])));
                        log.add(new CombatLog(compa.getNombre(), enemigo.getName(), enemigo.getDmg(compa.skillAttack(compa.abilities[action-1])), turno, compa.abilities[action-1].getName()));
                        break;
                }

            }
            turno++;
        }
        clearSrc();
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
        /* COMANDOS DEL BOT:
        0 : Ataca
        1 : Defiende
        2 : Esquiva
        3 : Habilidad 1
        4 : Habilidad 2
        5 : Habilidad 3
        6 : habilidad 4
         */
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
        while(input != 1 && input != 2 && input != 3 && input != 4){
            imprimirMenuCombate();
            Scanner scan = new Scanner(System.in);
            input = scan.nextInt();
        }
        return input;
    }

    //MenuCombate y menuSkills es distinto ya que MenuCombate va a tener más opciones en un futuro
    //mientras que menuSkills siempre va a ser del 1 al 4

    public int menuSkills(){
        int input = -1; //variable de control
        while(input != 1 && input != 2 && input != 3 && input != 4){
            printMenuSkills();
            Scanner scan = new Scanner(System.in);
            input = scan.nextInt();
        }
        return input;
    }

    public void printMenuSkills(){
        System.out.println("1 :" + compa.abilities[0].toString());
        System.out.println("2 :" + compa.abilities[1].toString());
        System.out.println("3 :" + compa.abilities[2].toString());
        System.out.println("4 :" + compa.abilities[3].toString());
        System.out.print("Seleccione habilidad para lanzar: ");
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
        System.out.println("presione 4 para ver Habilidades");

    }

    public static void clearSrc(){
        for(int i = 0; i < 50 ; i++){
            System.out.println(" ");
        }
    }

    /*METODOS*/

}