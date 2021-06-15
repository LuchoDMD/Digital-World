package com.mygdx.game.App;

import java.util.*;


public class Batalla
{
    public Compa compa;
    public Enemigo enemigo;
    private final List<Turno> log;    //logs del combate
    private Entrenador entrenador;

    // CONSTRUCTORES \\

    public Batalla(Compa compa, Enemigo enemigo, Entrenador entrenador) {
        this.compa = compa;
        this.enemigo = enemigo;
        log = new ArrayList<>();
        this.entrenador = entrenador;
    }

    // METODOS \\

    public void comenzarBatalla(){      //Método donde se realizará el bucle de combate
        int turno = 1;
        Texto.printMenuStatus(enemigo, compa);
        label: while ((enemigo.getHp() > 0 ) && (compa.getVida() > 0)) {    //Cuando alguno de los dos tenga 0 o menos de vida, termina el combate
                if (esMasRapido()) {     //si el player es más rápido, ataca primero
                    compa.limpiarEstado();
                    switch (menuCombate()) {     //TURNO PLAYER
                        case 1:
                            boolean flag = false;   //variable de control para el MP
                            while (!flag) {       //bucle para poder volver a elegir en caso de no tener suficiente MP para lanzar el hechizo
                                int accion = menuHabilidades();
                                if (accion == 5){
                                    continue label;
                                }
                                int danio = enemigo.getDanioRecibido(compa.habilidadAtaque(compa.habilidades[accion - 1]));
                                if (compa.verificarMana(compa.habilidades[accion - 1])) { //checkea que tenga mana suficiente
                                    compa.setMana(compa.getMana() - compa.habilidades[accion - 1].getCostoMP());   //resta el mana
                                    enemigo.golpeRematador(danio); //método que resta la vida al enemigo (tambien checkea si es el último hit para ponerle la vida en 0)
                                    flag = true;
                                } else {
                                    System.out.println("MP insuficiente");
                                }
                                if (flag) {  //lo metí adentro del bucle porque si no no me toma las variables dmg y action
                                    log.add(new Turno(compa.getNombre(), enemigo.getNombre(), danio, turno, compa.habilidades[accion - 1].getNombre()));
                                    Texto.limpiarPantalla();
                                    System.out.println("Has lanzado " + compa.habilidades[accion - 1]);
                                }
                                if (accion == 1) {       //si el ataque es un básico, se regenera MP
                                    compa.regenerarMP();
                                }
                            }
                            break;
                        case 2:
                            compa.defender();
                            compa.regenerarMP();
                            break;
                        case 3:
                            compa.esquivar();
                            compa.regenerarMP();
                            break;
                        case 4:
                            Texto.printMenuStatus(enemigo, compa);
                            continue label;
                        case 5:
                            int opcion = menuMochila();

                            Mochila mochila = entrenador.getMochila();

                            List<Bolsillo> bolsillo = null;

                            switch (opcion) {
                                case 1:
                                    bolsillo = mochila.getPociones();
                                    System.out.println(mochila.getPociones());
                                    break;
                                case 2:
                                    bolsillo = mochila.getElixires();
                                    System.out.println(mochila.getElixires());
                                    break;
                                case 3:
                                    continue label;
                            }
                            int tipoItem = menuInventario();
                            assert bolsillo != null;
                            Item item = mochila.tomarItem(bolsillo.get(tipoItem-1).getItem());
                            item.usar(compa);
                            break;
                        case 6:
                            Texto.huirBatalla();
                            break;
                    }
                    if (enemigo.getHp() >= 0) {

                        enemigo.limpiarEstado();
                        int accion = botEnemy();
                        switch (accion) {        //TURNO BOT
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                                System.out.println("El enemigo lanza " + enemigo.habilidades[accion]);
                                int danio = compa.getDanioRecibido(enemigo.habilidadAtaque(enemigo.habilidades[accion]));
                                enemigo.setMp(enemigo.getMp() - enemigo.habilidades[accion].getCostoMP());   //resta el mana
                                compa.golpeRematador(danio);
                                log.add(new Turno(enemigo.getNombre(), compa.getNombre(), danio, turno, enemigo.habilidades[accion].getNombre()));
                                if (accion == 0) {        //si el ataque es un básico, se regenera MP
                                    enemigo.regenerarMP();
                                }
                                break;
                            case 4:
                                enemigo.defender();
                                System.out.println("El enemigo se prepara para defender");
                                enemigo.regenerarMP();
                                break;
                            case 5:
                                System.out.println("El enemigo se prepara para esquivar");
                                enemigo.regenerarMP();
                                enemigo.esquivar();
                                break;
                        }
                        Texto.printMenuStatus(enemigo, compa);
                    }

                } else {           //si el bot es más rápido ataca primero
                    enemigo.limpiarEstado();
                    int accion = botEnemy();
                    switch (accion) {        //TURNO BOT
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            System.out.println("El enemigo lanza " + enemigo.habilidades[accion]);
                            int danio = compa.getDanioRecibido(enemigo.habilidadAtaque(enemigo.habilidades[accion]));
                            enemigo.setMp(enemigo.getMp() - enemigo.habilidades[accion].getCostoMP());   //resta el mana
                            compa.golpeRematador(danio);
                            log.add(new Turno(enemigo.getNombre(), compa.getNombre(), danio, turno, enemigo.habilidades[accion].getNombre()));
                            if (accion == 0) {    //si el ataque es un básico, se regenera MP
                                enemigo.regenerarMP();
                            }
                            break;
                        case 4:
                            enemigo.defender();
                            enemigo.regenerarMP();
                            System.out.println("El enemigo se prepara para defender");
                            break;
                        case 5:
                            System.out.println("El enemigo se prepara para esquivar");
                            enemigo.regenerarMP();
                            enemigo.esquivar();
                            break;
                    }
                    Texto.printMenuStatus(enemigo, compa);
                    compa.limpiarEstado();
                    boolean flag3 = false;  //flag para poder usar el label2
                    label2: while(!flag3){
                        switch (menuCombate()) {     //TURNO PLAYER
                            case 1:
                                boolean flag = false;   //variable de control para el MP
                                while (!flag) {       //bucle para poder volver a elegir en caso de no tener suficiente MP para lanzar el hechizo
                                    int accion2 = menuHabilidades();
                                    if (accion2 == 5) {
                                        continue label2;
                                    }
                                    int danio = enemigo.getDanioRecibido(compa.habilidadAtaque(compa.habilidades[accion2 - 1]));
                                    if (compa.verificarMana(compa.habilidades[accion2 - 1])) { //checkea que tenga mana suficiente
                                        compa.setMana(compa.getMana() - compa.habilidades[accion2 - 1].getCostoMP());   //resta el mana
                                        enemigo.golpeRematador(danio); //método que resta la vida al enemigo (tambien checkea si es el último hit para ponerle la vida en 0)
                                        flag = true;
                                    } else {
                                        System.out.println("MP insuficiente");
                                    }
                                    if (flag) {  //lo metí adentro del bucle porque si no no me toma las variables dmg y action
                                        log.add(new Turno(compa.getNombre(), enemigo.getNombre(), danio, turno, compa.habilidades[accion2 - 1].getNombre()));
                                        Texto.limpiarPantalla();
                                        System.out.println("Has lanzado " + compa.habilidades[accion2 - 1]);
                                    }
                                    if (accion2 == 1) {       //si el ataque es un básico, se regenera MP
                                        compa.regenerarMP();
                                    }
                                }
                                break;
                            case 2:
                                compa.defender();
                                compa.regenerarMP();
                                break;
                            case 3:
                                compa.esquivar();
                                compa.regenerarMP();
                                break;
                            case 4:
                                Texto.printMenuStatus(enemigo, compa);
                                continue label2;
                            case 5:
                                int opcion = menuMochila();

                                Mochila mochila = entrenador.getMochila();

                                List<Bolsillo> bolsillo = null;

                                switch (opcion) {
                                    case 1:
                                        bolsillo = mochila.getPociones();
                                        System.out.println(mochila.getPociones());
                                        break;
                                    case 2:
                                        bolsillo = mochila.getElixires();
                                        System.out.println(mochila.getElixires());
                                        break;
                                    case 3:
                                        continue label;
                                }
                                int tipoItem = menuInventario();
                                assert bolsillo != null;
                                Item item = mochila.tomarItem(bolsillo.get(tipoItem-1).getItem());
                                item.usar(compa);
                                break;
                            case 6:
                                Texto.huirBatalla();
                                break;
                        }
                        flag3 = true; //flag para salir del bucle del label
                    }
                }
                turno++;
            }
            Texto.limpiarPantalla();
            Texto.printMenuStatus(enemigo, compa);
            System.out.println(Texto.printLog(log));
            Texto.declararVencedor(compa);
        }

    public boolean esMasRapido(){      //clase que compara la velocidad del compa con la velocidad del enemigo
        boolean flag = compa.getVelocidad() > enemigo.getVelocidad();   //por defecto devuelve False si el enemigo es más rapido
        //siempre que devuelva true será porque el compa es más rápido
        return flag;
    }

    private int botEnemy(){  //bot actúa semi aleatorio
        /* COMANDOS DEL BOT:
        0 : Habilidad 1 //ataque básicoS
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

    private int menuCombate(){      //

        int input = -1; //variable de control
        boolean flag = false;

        do{
            try {
                while(input != 1 && input != 2 && input != 3 && input != 4 && input != 5 && input != 6){
                    Texto.imprimirMenuCombate();
                    Scanner scan = new Scanner(System.in);
                    input = scan.nextInt();
                    flag = true;
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("Usted ha ingresado un valor no válido. Por favor, seleccione un numero de la lista");
                flag = false;
            }
        } while (!flag);
        return input;
    }

    private int menuMochila() {
        int input = -1; //variable de control
        boolean flag = false;

        do{
            try {
                while(input != 1 && input != 2 && input != 3){
                    Texto.imprimirMenuMochila();
                    Scanner scan = new Scanner(System.in);
                    input = scan.nextInt();
                    flag = true;
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("Usted ha ingresado un valor no válido. Por favor, seleccione un numero de la lista");
                flag = false;
            }
        } while (!flag);
        return input;
    }

    private int menuInventario(){
        int input = -1; //variable de control
        boolean flag = false;

        do{
            try {
                while(input != 1 && input != 2 && input != 3 && input != 4 && input != 5 && input != 6){
                    Texto.imprimirMenuInventario(entrenador.mochila);
                    Scanner scan = new Scanner(System.in);
                    input = scan.nextInt();
                    flag = true;
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("Usted ha ingresado un valor no válido. Por favor, seleccione un numero de la lista");
                flag = false;
            }
        } while (!flag);
        return input;
    }

    private int menuHabilidades(){

        int input = -1; //variable de control
        boolean flag = false;

        do {
            try {
                while(input != 1 && input != 2 && input != 3 && input != 4 && input != 5){
                    Texto.printMenuSkills(compa);
                    Scanner scan = new Scanner(System.in);
                    input = scan.nextInt();
                    flag = true;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Usted ha ingresado un valor no válido. Por favor, seleccione un numero de la lista");
            }
        } while (!flag);

        return input;
    }
}
/*
*
*
* */

/*FORMA I
* //MENU HABILIDADES
* int input = -1; //variable de control
        boolean flag = false;
        Scanner scan=new Scanner(System.in);
        do {
            while (!scan.hasNextInt()) {
                Texto.printMenuSkills(compa);
                scan.next();
            }
            input = scan.nextInt();
            if(input>0&&input<=4)
            {
                flag=true;
            }
        } while (!flag);
        return input;
* //MENU COMBATE
*       int input = -1; //variable de control
        boolean flag = false;
        Scanner scan = new Scanner(System.in);
        do{
            while(!scan.hasNextInt()) {
                Texto.imprimirMenuCombate();
                scan.next();
            }
            input = scan.nextInt();
            if(input>0&&input<=4)
            {
                flag=true;
            }
        } while (!flag);
        return input;
* */