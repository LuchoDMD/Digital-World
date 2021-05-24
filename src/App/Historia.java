package App;

public class Historia {

    public static void imprimirIntroduccion() {
        GameLogic.limpiarConsola();
        GameLogic.imprimirSeparacion(30);
        System.out.println("PROLOGO");
        GameLogic.imprimirSeparacion(30);
        System.out.println("Inicias tu aventura seleccionando a tu compañero Digimon y habiendolo bautizado con un hermoso nombre.");
        System.out.println("Tu deber como entrenador de Digimons es derrotar a todos tus enemigos para alzarte con la victoria");
        System.out.println("La aventura comienza ahora!");
        GameLogic.systemPause();
    }

    public static void imprimirIntroNivel1() {
        GameLogic.limpiarConsola();
        GameLogic.imprimirSeparacion(30);
        System.out.println("NIVEL 1 - INTRO");
        GameLogic.imprimirSeparacion(30);
        System.out.println("Entras al nivel 1 del calabozo donde te espera tu primer rival...");
        GameLogic.systemPause();
    }

    public static void imprimirSalidaNivel1() {
        GameLogic.limpiarConsola();
        GameLogic.imprimirSeparacion(30);
        System.out.println("NIVEL 1 - SALIDA EXITOSA!");
        GameLogic.imprimirSeparacion(30);
        System.out.println("Has logrado derrotar a tu primer rival, facil no? Tu proximo rival no sera tan sencillo...");
        GameLogic.systemPause();
    }

    public static void imprimirIntroNivel2() {
        GameLogic.limpiarConsola();
        GameLogic.imprimirSeparacion(30);
        System.out.println("NIVEL 2 - INTRO");
        GameLogic.imprimirSeparacion(30);
        System.out.println("Entras al nivel 2 del calabozo donde te espera tu segundo rival...");
        GameLogic.systemPause();
    }

    public static void imprimirSalidaNivel2() {
        GameLogic.limpiarConsola();
        GameLogic.imprimirSeparacion(30);
        System.out.println("NIVEL 2 - SALIDA EXITOSA!");
        GameLogic.imprimirSeparacion(30);
        System.out.println("Has logrado derrotar a tu segundo rival, pero solo has tenido demasiada suerte. Tu proximo rival sera tu perdicion...");
        GameLogic.systemPause();
    }

    public static void imprimirIntroNivel3() {
        GameLogic.limpiarConsola();
        GameLogic.imprimirSeparacion(30);
        System.out.println("NIVEL 3 - INTRO");
        GameLogic.imprimirSeparacion(30);
        System.out.println("Entras al nivel 3 deseando que esto termine pronto...");
        GameLogic.systemPause();
    }

    public static void imprimirSalidaNivel3() {
        GameLogic.limpiarConsola();
        GameLogic.imprimirSeparacion(30);
        System.out.println("NIVEL 3 - SALIDA EXITOSA");
        GameLogic.imprimirSeparacion(30);
        System.out.println("El nivel 3 tampoco pudo con tu Digimon, preparate para el siguiente nivel...");
        GameLogic.systemPause();
    }

    public static void imprimirIntroNivel4() {
        GameLogic.limpiarConsola();
        GameLogic.imprimirSeparacion(30);
        System.out.println("NIVEL 4 - INTRO");
        GameLogic.imprimirSeparacion(30);
        System.out.println("El nivel 4 te llena de esperanza porque visualizas un cartel que te dice que este es el lugar donde te espera el ultimo reto...");
        GameLogic.systemPause();
    }

    public static void imprimirSalidaNivel4() {
        GameLogic.limpiarConsola();
        GameLogic.imprimirSeparacion(30);
        System.out.println("NIVEL 4 - SALIDA EXITOSA");
        GameLogic.imprimirSeparacion(30);
        System.out.println("Casi dominas todo el juego, el nivel final pondra al limite tus habilidades como entrenador!");
        GameLogic.systemPause();
    }

    public static void imprimirFinalJuego(Partner partner) {
        GameLogic.limpiarConsola();
        GameLogic.imprimirSeparacion(30);
        System.out.println("FINAL DEL JUEGO");
        GameLogic.imprimirSeparacion(30);
        System.out.println("Felicitaciones" + partner.nombre + ". Lograste terminar el juego con vida!!!");
    }

}