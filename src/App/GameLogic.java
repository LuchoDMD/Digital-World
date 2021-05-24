package App;

import java.util.Scanner;

public class GameLogic {

    static Scanner scanner = new Scanner(System.in);
    static Partner partner;
    public static boolean estaCorriendo;

    // Arreglo de encuentros aleatorios

    public static String[] encuentros = {"Batalla", "Batalla", "Batalla", "Descansar", "Descansar"};

    // Arreglo de nombres de enemigos

    public static String[] enemigos = {"Devimon", "Etemon", "Kimeramon", "Daemon", "Ogremon"};

    // Arreglo para los niveles del juego

    public static int lugar = 0, acto = 1;
    public static String[] lugares = {"Pradera", "Bosque", "Montaña", "Castillo"};

    // Metodo para obtener el ingreso de datos del usuario

    public static int leerInput (String consola, int eleccionDeUsuario) {
        int input;
        do {
            System.out.print(consola);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Por favor, ingrese un numero entero!");
            }
        } while (input < 1 || input > eleccionDeUsuario);
        return input;
    }

    // Metodo para simular la limpieza de la consola

    public static void limpiarConsola () {
        for (int i=0; i<50; i++) {
            System.out.println();
        }
    }

    // Metodo para usar separadores de tamaño n

    public static void imprimirSeparacion (int n) {
        for (int i=0; i<n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // Metodo para imprimir un encabezado en la consola

    public static void imprimirEncabezado (String titulo) {
        imprimirSeparacion(30);
        System.out.println(titulo);
        imprimirSeparacion(30);
    }

    // Metodo para detener el juego hasta que el usuario ingrese algo por consola
    // Una improvisacion del system("pause")

    public static void systemPause () {
        System.out.println("Ingrese una tecla para continuar...");
        scanner.next();
    }

    // Metodo para iniciar el juego

    public static void comenzarJuego() {
        boolean nombreSeteado = false;
        String nombre;

        limpiarConsola();
        imprimirSeparacion(40);
        imprimirSeparacion(30);
        System.out.println("DIGIMON ADVENTURES!");
        System.out.println("Copyright Los Usted++ Team.");
        imprimirSeparacion(30);
        imprimirSeparacion(40);
        systemPause();

        do {
            limpiarConsola();
            imprimirEncabezado("Cual es el nombre de su Digimon?: ");
            nombre = scanner.next();

            limpiarConsola();
            imprimirEncabezado("El nombre de su personaje es: " + nombre + ". \nEs correcto?");
            System.out.println("1) Si!");
            System.out.println("2) No. Quiero cambiarlo!");
            int input = leerInput("---> ", 2);

            if (input == 1) {
                nombreSeteado = true;
            }
        } while (!nombreSeteado);

        // Imprimimos la historia principal

        Historia.imprimirIntroduccion();

        // Creamos un nuevo objeto de tipo Partner
        partner = new Partner(nombre, 100, 0);

        // Imprimimos el nivel 1

        Historia.imprimirIntroNivel1();

        // Seteamos el booleano estaCorriendo a true para verificar si el juego esta corriendo
        estaCorriendo = true;

        // Bucle del juego
        bucleJuego();

    }

    // Metodo para verificar en que nivel se encuentra el personaje

    public static void chequearNivel() {
        if (partner.xp >= 10 && acto == 1) {
            acto = 2;
            lugar = 1;
            Historia.imprimirSalidaNivel1();
            partner.elegirTecnicas();
            Historia.imprimirIntroNivel2();
            enemigos[0] = "1";
            enemigos[1] = "2";
            enemigos[2] = "3";
            enemigos[3] = "4";
            enemigos[4] = "5";

            encuentros[0] = "Batalla";
            encuentros[1] = "Batalla";
            encuentros[2] = "Batalla";
            encuentros[3] = "Descansar";
            encuentros[4] = "Tienda";
        } else if (partner.xp >= 50 && acto == 2) {
            acto = 3;
            lugar = 2;
            Historia.imprimirSalidaNivel2();
            partner.elegirTecnicas();
            Historia.imprimirIntroNivel3();
            enemigos[0] = "1";
            enemigos[1] = "2";
            enemigos[2] = "3";
            enemigos[3] = "4";
            enemigos[4] = "5";

            encuentros[0] = "Batalla";
            encuentros[1] = "Batalla";
            encuentros[2] = "Batalla";
            encuentros[3] = "Batalla";
            encuentros[4] = "Tienda";
            partner.hp = partner.maxHp;
        } else if (partner.xp >= 100 && acto == 3) {
            acto = 4;
            lugar = 3;
            Historia.imprimirSalidaNivel3();
            partner.elegirTecnicas();
            Historia.imprimirIntroNivel4();
            partner.hp = partner.maxHp;
            //batallaFinal();
            Historia.imprimirFinalJuego(partner);
        }
    }

    // Metodo para calcular un encuentro aleatorio
    // Batalla, descanso o comprar en la tienda

    public static void encuentroAleatorio() {
        int encuentro = (int) (Math.random() * encuentros.length);

        if (encuentros[encuentro].equals("Batalla")) {
            batallaAleatoria();
        } else if (encuentros[encuentro].equals("Descanso")) {
            //tomarDescanso();
        } else {
            //comprarEnTienda();
        }
    }

    // Metodo para continuar la aventura

    public static void continuarAventura() {

        chequearNivel();

        if (acto != 4) {
            encuentroAleatorio();
        }
    }

    // Metodo para imprimir la información del personaje

    public static void imprimirInfoDigimon() {
        limpiarConsola();
        imprimirEncabezado("INFORMACION DEL DIGIMON:");
        System.out.println("\nNombre: " + partner.nombre + "\nHP: " + partner.hp + "/" + partner.maxHp);
        imprimirSeparacion(20);
        System.out.println("Experiencia: " + partner.xp);
        imprimirSeparacion(20);

        if (partner.cantTecnicasOfensivas > 0) {
            System.out.println("Tecnicas ofensivas: " + partner.tecnicaOfensiva[partner.cantTecnicasOfensivas - 1]);
        }

        if (partner.cantTecnicasDefensivas > 0) {
            System.out.println("Tecnicas defensivas: " + partner.tecnicaDefensiva[partner.cantTecnicasDefensivas - 1]);
        }
        systemPause();
    }

    // Metodo para generar una batalla aleatoria

    public static void batallaAleatoria() {
        limpiarConsola();
        imprimirEncabezado("Te has encontrado con un Digimon enemigo. Preparate para la batalla!");
        systemPause();
        batalla(new Enemigo(enemigos[(int)(Math.random() * enemigos.length)], partner.xp));

    }

    // Metodo para generar una batalla

    public static void batalla (Enemigo enemigo) {
        while (true) {
            limpiarConsola();
            imprimirEncabezado(enemigo.nombre + "\nHP: " + enemigo.hp + "/" + enemigo.maxHp);
            imprimirEncabezado(partner.nombre + "\nHP: " + partner.hp + "/" + partner.maxHp);
            System.out.println("Elije una accion:");
            imprimirSeparacion(20);
            System.out.println("1) Luchar \n2) Usar una pocion \n3) Huir");
            int input = leerInput("-> ", 3);

            if (input == 1) {
                int dmg = partner.atacar() - enemigo.defender();
                int dmgTook = enemigo.atacar() - partner.defender();

                if (dmgTook < 0) {
                    dmg -= dmgTook/2;
                    dmgTook = 0;
                }

                if (dmg < 0) {
                    dmg = 0;
                    partner.hp -= dmgTook;
                    enemigo.hp -= dmg;
                    limpiarConsola();
                    imprimirEncabezado("BATALLA");
                    System.out.println("Hiciste " + dmg + " de daño a " + enemigo.nombre + "!");
                    imprimirSeparacion(20);
                    System.out.println("El " + enemigo.nombre + " te hizo " + dmgTook + " de daño!");
                    systemPause();
                    if (partner.hp <= 0) {
                        jugadorEliminado();
                        break;
                    } else if (enemigo.hp <= 0) {
                        limpiarConsola();
                        imprimirEncabezado("Derrotaste a " + enemigo.nombre + "!");
                        partner.xp += enemigo.xp;
                        System.out.println("Ganaste " + enemigo.xp + " de experiencia!");
                        systemPause();
                        break;
                    }
                } else if (input == 2) {
                    // Metodo para usar una pocion
                } else {
                    limpiarConsola();

                    // El personaje tiene un 35% de probabilidades de escapar del combate, sino, recibe daño
                    if (acto != 4) {
                        if (Math.random() * 10 + 1 <= 3.5) {
                            imprimirEncabezado("Pudiste escapar de " + enemigo.nombre + "!");
                            systemPause();
                            break;
                        } else {
                            imprimirEncabezado("No pudiste escapar");
                            dmgTook = enemigo.atacar();
                            System.out.println("En el apuro recibiste 0" + dmgTook + " de daño!");
                            systemPause();
                            if (partner.hp <= 0) {
                                jugadorEliminado();
                            }
                        }
                    } else {
                        imprimirEncabezado("No puedes escapar del enemigo!!!!");
                        systemPause();
                    }

                }
            }
        }
    }

    // Metodo para imprimir el menu principal

    public static void imprimirMenuPrincipal() {
        limpiarConsola();
        imprimirEncabezado(lugares[lugar]);
        System.out.println("Elija una opcion: ");
        imprimirSeparacion(20);
        System.out.println("1) Continuar aventura.");
        System.out.println("2) Informacion del Digimon.");
        System.out.println("3) Salir del juego.");
    }

    // Metodo para imprimir el mensaje de muerte del jugador

    public static void jugadorEliminado() {
        limpiarConsola();
        imprimirEncabezado("Moriste...");
        imprimirEncabezado("Ganaste " + partner.xp + " de experiencia en tu aventura. Intenta ganar mas la proxima vez");
    }

    // Bucle principal del juego

    public static void bucleJuego() {
        while (estaCorriendo) {
            imprimirMenuPrincipal();
            int input = leerInput("---> ", 3);
            if (input == 1) {
                continuarAventura();
            } else if (input == 2) {
                imprimirInfoDigimon();
            } else {
                estaCorriendo = false;
            }
        }
    }
}