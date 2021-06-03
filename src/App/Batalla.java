package App;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Batalla extends Texto
{
    /*ATRIBUTOS*/
    protected Companiero companiero;
    protected Enemigo enemigo;
    private final List<CombatLog> log;    //logs del combate

    /*CONSTRUCTOR*/
    public Batalla(Companiero companiero, Enemigo enemigo)
    {
        this.companiero = companiero;
        this.enemigo = enemigo;
        log = new ArrayList<>();
    }

    public boolean esMasRapido(){      //clase que compara la velocidad del compa con la velocidad del enemigo
        boolean flag = companiero.getVelocidad() > enemigo.getVelocidad();   //por defecto devuelve False si el enemigo es más rapido
        //siempre que devuelva true será porque el compa es más rápido
        return flag;
    }

    public void comenzarBatalla(){      //Método donde se realizará el bucle de combate
        int turno = 1;
        imprimirMenuEstados();
        while ((enemigo.getHp() > 0 ) && (companiero.getVida() > 0)){    //Cuando alguno de los dos tenga 0 o menos de vida, termina el combate
            if(esMasRapido()){     //si el player es más rápido, ataca primero
                companiero.limpiarEstados();
                switch (menuCombate()){     //TURNO PLAYER
                    case 1:
                        boolean flag = false;   //variable de control para el MP
                        while(!flag){       //bucle para poder volver a elegir en caso de no tener suficiente MP para lanzar el hechizo
                            int accion = menuHabilidades();
                            int danio = enemigo.getDanio(companiero.habilidadAtaque(companiero.habilidades[accion-1]));
                            if (companiero.verificarMana(companiero.habilidades[accion-1])){ //checkea que tenga mana suficiente
                                companiero.setMana(companiero.getMana() - companiero.habilidades[accion - 1].getCostoMP());   //resta el mana
                                enemigo.golpeRematador(danio); //método que resta la vida al enemigo (tambien checkea si es el último hit para ponerle la vida en 0)
                                flag = true;
                            }
                            else{
                                System.out.println("MP insuficiente");
                            }
                            if (flag){  //lo metí adentro del bucle porque si no no me toma las variables dmg y action
                                log.add(new CombatLog(companiero.getNombre(), enemigo.getNombre(), danio, turno, companiero.habilidades[accion-1].getNombre()));
                                limpiarPantalla();
                                System.out.println("Has lanzado " + companiero.habilidades[accion - 1]);
                            }
                            if (accion == 1){       //si el ataque es un básico, se regenera MP
                                companiero.regenerarMP();
                            }
                        }
                        break;
                    case 2:
                        companiero.defender();
                        companiero.regenerarMP();
                        break;
                    case 3:
                        companiero.esquivar();
                        companiero.regenerarMP();
                        break;
                    case 4:
                        break;

                }
                if(enemigo.getHp() >= 0){

                    enemigo.limpiarEstados();
                    int accion = botEnemy();
                    switch (accion){        //TURNO BOT
                        case 0: case 1: case 2: case 3:
                            System.out.println("EL BOT LANZA" + enemigo.habilidades[accion]);
                            int danio = companiero.getDanio(enemigo.habilidadAtaque(enemigo.habilidades[accion]));
                            enemigo.setMp(enemigo.getMp() - enemigo.habilidades[accion].getCostoMP());   //resta el mana
                            companiero.golpeRematador(danio);
                            log.add(new CombatLog(enemigo.getNombre(), companiero.getNombre(), danio, turno, enemigo.habilidades[accion].getNombre()));
                            if(accion == 0){        //si el ataque es un básico, se regenera MP
                                enemigo.regenerarMP();
                            }
                            break;
                        case 4:
                            enemigo.defender();
                            System.out.println("EL BOT se prepara para defender");
                            enemigo.regenerarMP();
                            break;
                        case 5:
                            System.out.println("EL BOT se prepara para esquivar");
                            enemigo.regenerarMP();
                            enemigo.esquivar();
                            break;
                    }
                    imprimirMenuEstados();
                }

            }

            else{           //si el bot es más rápido ataca primero
                enemigo.limpiarEstados();
                int accion = botEnemy();
                switch (accion){        //TURNO BOT
                    case 0: case 1: case 2: case 3:
                        System.out.println("EL BOT ATACA");
                        int danio = companiero.getDanio(enemigo.habilidadAtaque(enemigo.habilidades[accion]));
                        enemigo.setMp(enemigo.getMp() - enemigo.habilidades[accion].getCostoMP());   //resta el mana
                        companiero.golpeRematador(danio);
                        log.add(new CombatLog(enemigo.getNombre(), companiero.getNombre(), danio, turno, enemigo.habilidades[accion].getNombre()));
                        if(accion == 0){    //si el ataque es un básico, se regenera MP
                            enemigo.regenerarMP();
                        }
                        break;
                    case 4:
                        enemigo.defender();
                        enemigo.regenerarMP();
                        System.out.println("EL BOT se prepara para defender");
                        break;
                    case 5:
                        System.out.println("EL BOT se prepara para esquivar");
                        enemigo.regenerarMP();
                        enemigo.esquivar();
                        break;
                }
                imprimirMenuEstados();
                companiero.limpiarEstados();
                switch (menuCombate()){     //TURNO PLAYER
                    case 1:
                        boolean flag = false;   //variable de control para el MP
                        while(!flag){       //bucle para poder volver a elegir en caso de no tener suficiente MP para lanzar el hechizo
                            int accion2 = menuHabilidades();
                            int danio = enemigo.getDanio(companiero.habilidadAtaque(companiero.habilidades[accion2-1]));
                            if (companiero.verificarMana(companiero.habilidades[accion2-1])){ //checkea que tenga mana suficiente
                                companiero.setMana(companiero.getMana() - companiero.habilidades[accion2 - 1].getCostoMP());   //resta el mana
                                enemigo.golpeRematador(danio); //método que resta la vida al enemigo (tambien checkea si es el último hit para ponerle la vida en 0)
                                flag = true;
                            }
                            else{
                                System.out.println("MP insuficiente");
                            }
                            if (flag){  //lo metí adentro del bucle porque si no no me toma las variables dmg y action
                                log.add(new CombatLog(companiero.getNombre(), enemigo.getNombre(), danio, turno, companiero.habilidades[accion2-1].getNombre()));
                                limpiarPantalla();
                                System.out.println("Has lanzado " + companiero.habilidades[accion2 - 1]);
                            }
                            if (accion2 == 1){       //si el ataque es un básico, se regenera MP
                                companiero.regenerarMP();
                            }
                        }
                        break;
                    case 2:
                        companiero.defender();
                        companiero.regenerarMP();
                        break;
                    case 3:
                        companiero.esquivar();
                        companiero.regenerarMP();
                        break;
                    case 4:
                        break;

                }

            }
            turno++;
        }
        limpiarPantalla();
        imprimirMenuEstados();
        System.out.println(imprimirLog());

    }

    private String imprimirLog(){
        String rda = "";
        for(CombatLog variable : log){
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
        int accion = random.nextInt(6); // 0, 1 , 2, 3, 4, 5
        if(accion <= 3){
            if (enemigo.verificarMana(enemigo.habilidades[accion])){
                return accion;
            }
            else {
                return 0;
            }
        }
        return accion;
    }



    public int menuCombate(){      //
        int input = -1; //variable de control
        while(input != 1 && input != 2 && input != 3 && input != 4){
            imprimirMenuCombate();
            Scanner scan = new Scanner(System.in);
            input = scan.nextInt();
        }
        return input;
    }

    //menuCombate y menuHabilidades es distinto ya que MenuCombate va a tener más opciones en un futuro
    //mientras que menuHabilidades siempre va a ser del 1 al 4

    public int menuHabilidades(){
        int input = -1; //variable de control
        while(input != 1 && input != 2 && input != 3 && input != 4){
            imprimirMenuHabilidades();
            Scanner scan = new Scanner(System.in);
            input = scan.nextInt();
        }
        return input;
    }

    public void imprimirMenuEstados(){
        System.out.println("Enemigo:                      Player:");
        System.out.println("HP: " + enemigo.getHp() + "                     HP: " + companiero.getVida());
        System.out.println("MP: " + enemigo.getMp() + "                     MP: " + companiero.getMana());
    }

    public static void limpiarPantalla(){
        for(int i = 0; i < 50 ; i++){
            System.out.println(" ");
        }
    }

    public void imprimirMenuCombate(){
        System.out.println("Ingrese un comando de la lista:\n");
        System.out.println("1) Atacar.");
        System.out.println("2) Defender.");
        System.out.println("3) Esquivar.");
        System.out.println("4) Comprobar inventario.");

    }

    public void imprimirMenuHabilidades(){
        System.out.println("Lista de habilidades disponibles. Elija una:\n");
        System.out.println("1) " + companiero.habilidades[0].toString());
        System.out.println("2) " + companiero.habilidades[1].toString());
        System.out.println("3) " + companiero.habilidades[2].toString());
        System.out.println("4) " + companiero.habilidades[3].toString());
    }


}
