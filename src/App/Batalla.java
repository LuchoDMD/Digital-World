package App;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Batalla
{
    /*ATRIBUTOS*/
    protected Compa compa;
    protected Enemigo enemigo;
    private final List<Turno> log;    //logs del combate

    /*CONSTRUCTOR*/
    public Batalla(Compa compa, Enemigo enemigo)
    {
        this.compa = compa;
        this.enemigo = enemigo;
        log = new ArrayList<>();
    }

    public boolean isFaster(){      //clase que compara la velocidad del compa con la velocidad del enemigo
        boolean flag = compa.getSpd() > enemigo.getSpd();   //por defecto devuelve False si el enemigo es más rapido
        //siempre que devuelva true será porque el compa es más rápido
        return flag;
    }

    public void comenzarBatalla(){      //Método donde se realizará el bucle de combate
        int turno = 1;
        printMenuStatus();
        while ((enemigo.getHp() > 0 ) && (compa.getVida() > 0)){    //Cuando alguno de los dos tenga 0 o menos de vida, termina el combate
            if(isFaster()){     //si el player es más rápido, ataca primero
                compa.clearStatus();
                switch (MenuCombate()){     //TURNO PLAYER
                    case 1:
                        boolean flag = false;   //variable de control para el MP
                        while(!flag){       //bucle para poder volver a elegir en caso de no tener suficiente MP para lanzar el hechizo
                            int action = menuSkills();
                            int dmg = enemigo.getDmg(compa.skillAttack(compa.abilities[action-1]));
                            if (compa.checkMana(compa.abilities[action-1])){ //checkea que tenga mana suficiente
                                compa.setMana(compa.getMana() - compa.abilities[action - 1].getMPcost());   //resta el mana
                                enemigo.killingBlow(dmg); //método que resta la vida al enemigo (tambien checkea si es el último hit para ponerle la vida en 0)
                                flag = true;
                            }
                            else{
                                System.out.println("MP insuficiente");
                            }
                            if (flag){  //lo metí adentro del bucle porque si no no me toma las variables dmg y action
                                log.add(new Turno(compa.getNombre(), enemigo.getName(), dmg, turno, compa.abilities[action-1].getName()));
                                clearSrc();
                                System.out.println("Has lanzado " + compa.abilities[action - 1]);
                            }
                            if (action == 1){       //si el ataque es un básico, se regenera MP
                                compa.mpRegen();
                            }
                        }
                        break;
                    case 2:
                        compa.defender();
                        compa.mpRegen();
                        break;
                    case 3:
                        compa.esquivar();
                        compa.mpRegen();
                        break;
                    case 4:
                        break;

                }
                if(enemigo.getHp() >= 0){

                    enemigo.clearStatus();
                    int action = botEnemy();
                    switch (action){        //TURNO BOT
                        case 0: case 1: case 2: case 3:
                            System.out.println("EL BOT LANZA" + enemigo.abilities[action]);
                            int dmg = compa.getDmg(enemigo.skillAttack(enemigo.abilities[action]));
                            enemigo.setMp(enemigo.getMp() - enemigo.abilities[action].getMPcost());   //resta el mana
                            compa.killingBlow(dmg);
                            log.add(new Turno(enemigo.getName(), compa.getNombre(), dmg, turno, enemigo.abilities[action].getName()));
                            if(action == 0){        //si el ataque es un básico, se regenera MP
                                enemigo.mpRegen();
                            }
                            break;
                        case 4:
                            enemigo.defender();
                            System.out.println("EL BOT se prepara para defender");
                            enemigo.mpRegen();
                            break;
                        case 5:
                            System.out.println("EL BOT se prepara para esquivar");
                            enemigo.mpRegen();
                            enemigo.esquivar();
                            break;
                    }
                    printMenuStatus();
                }

            }

            else{           //si el bot es más rápido ataca primero
                enemigo.clearStatus();
                int action = botEnemy();
                switch (action){        //TURNO BOT
                    case 0: case 1: case 2: case 3:
                        System.out.println("EL BOT ATACA");
                        int dmg = compa.getDmg(enemigo.skillAttack(enemigo.abilities[action]));
                        enemigo.setMp(enemigo.getMp() - enemigo.abilities[action].getMPcost());   //resta el mana
                        compa.killingBlow(dmg);
                        log.add(new Turno(enemigo.getName(), compa.getNombre(), dmg, turno, enemigo.abilities[action].getName()));
                        if(action == 0){    //si el ataque es un básico, se regenera MP
                            enemigo.mpRegen();
                        }
                        break;
                    case 4:
                        enemigo.defender();
                        enemigo.mpRegen();
                        System.out.println("EL BOT se prepara para defender");
                        break;
                    case 5:
                        System.out.println("EL BOT se prepara para esquivar");
                        enemigo.mpRegen();
                        enemigo.esquivar();
                        break;
                }
                printMenuStatus();
                compa.clearStatus();
                switch (MenuCombate()){     //TURNO PLAYER
                    case 1:
                        boolean flag = false;   //variable de control para el MP
                        while(!flag){       //bucle para poder volver a elegir en caso de no tener suficiente MP para lanzar el hechizo
                            int action2 = menuSkills();
                            int dmg = enemigo.getDmg(compa.skillAttack(compa.abilities[action2-1]));
                            if (compa.checkMana(compa.abilities[action2-1])){ //checkea que tenga mana suficiente
                                compa.setMana(compa.getMana() - compa.abilities[action2 - 1].getMPcost());   //resta el mana
                                enemigo.killingBlow(dmg); //método que resta la vida al enemigo (tambien checkea si es el último hit para ponerle la vida en 0)
                                flag = true;
                            }
                            else{
                                System.out.println("MP insuficiente");
                            }
                            if (flag){  //lo metí adentro del bucle porque si no no me toma las variables dmg y action
                                log.add(new Turno(compa.getNombre(), enemigo.getName(), dmg, turno, compa.abilities[action2-1].getName()));
                                clearSrc();
                                System.out.println("Has lanzado " + compa.abilities[action2 - 1]);
                            }
                            if (action2 == 1){       //si el ataque es un básico, se regenera MP
                                compa.mpRegen();
                            }
                        }
                        break;
                    case 2:
                        compa.defender();
                        compa.mpRegen();
                        break;
                    case 3:
                        compa.esquivar();
                        compa.mpRegen();
                        break;
                    case 4:
                        break;

                }

            }
            turno++;
        }
        clearSrc();
        printMenuStatus();
        System.out.println(printLog());

    }

    private String printLog(){
        String rda = "";
        for(Turno variable : log){
            rda = rda + variable.toString() + "\n";
        }
        return rda;
    }

    public int botEnemy(){  //bot actúa semi aleatorio
        /* COMANDOS DEL BOT:
        0 : Habilidad 1 //ataque básico
        1 : Habilidad 2
        2 : Habilidad 3
        3 : habilidad 4
        4 : Defiende
        5 : Esquiva
         */
        Random random = new Random();
        int action = random.nextInt(6); // 0, 1 , 2, 3, 4, 5
        if(action <= 3){
            if (enemigo.checkMana(enemigo.abilities[action])){
                return action;
            }
            else {
                return 0;
            }
        }
        return action;
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




    /*PRINTS*/
    public void printMenuStatus(){
        System.out.println("Enemigo:                      Player:");
        System.out.println("HP: " + enemigo.getHp() + "                     HP: " + compa.getVida());
        System.out.println("MP: " + enemigo.getMp() + "                     MP: " + compa.getMana());
    }

    public static void clearSrc(){
        for(int i = 0; i < 50 ; i++){
            System.out.println(" ");
        }
    }

    public void imprimirMenuCombate(){
        System.out.println("presione 1 para Atacar");
        System.out.println("presione 2 para Defender");
        System.out.println("presione 3 para Esquivar");
        System.out.println("presione 4 para ver Inventario");

    }

    public void printMenuSkills(){
        System.out.println("1 :" + compa.abilities[0].toString());
        System.out.println("2 :" + compa.abilities[1].toString());
        System.out.println("3 :" + compa.abilities[2].toString());
        System.out.println("4 :" + compa.abilities[3].toString());
        System.out.print("Seleccione habilidad para lanzar: ");
    }

}
