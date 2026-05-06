import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Palabra> palabras = CargadorCSV.cargarPalabras();
        Scanner sc = new Scanner(System.in);

        int op;

        do {
        System.out.println("╔═════════════════════════════════════════════════╗");
        System.out.println("║             MENU  JUEGO  AHORCADO               ║");
        System.out.println("║   Bienvenido, seleccione una opción del menú    ║");
        System.out.println("╠═════════════════════════════════════════════════╣");
        System.out.println("║ 1. Jugar                                        ║");
        System.out.println("║ 2. Instrucciones                                ║");
        System.out.println("║ 3. Records                                      ║");
        System.out.println("║ 4. Salir                                        ║");
        System.out.println("╚═════════════════════════════════════════════════╝");
        System.out.println("Palabras cargadas: " + palabras.size());
        System.out.print("Opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("Entrada inválida");
                sc.next();
            }       
            op = sc.nextInt();

            switch (op) {

                    case 1:

                        System.out.print("\nIngresa tu nombre: ");
                        String nombre = sc.next();

                        boolean modoDios = Juego.verificarEasterEgg(nombre);

                        if (modoDios) {

                            System.out.println("\n MODO DIOS ACTIVADO \n");

                            System.out.println(
                        " ███╗   ███╗ ██████╗ ██████╗  ██████╗     ██████╗ ██╗ ██████╗ ███████╗\n" +
                        " ████╗ ████║██╔═══██╗██╔══██╗██╔═══██╗    ██╔══██╗██║██╔═══██╗██╔════╝\n" +
                        " ██╔████╔██║██║   ██║██║  ██║██║   ██║    ██║  ██║██║██║   ██║███████╗\n" +
                        " ██║╚██╔╝██║██║   ██║██║  ██║██║   ██║    ██║  ██║██║██║   ██║╚════██║\n" +
                        " ██║ ╚═╝ ██║╚██████╔╝██████╔╝╚██████╔╝    ██████╔╝██║╚██████╔╝███████║\n" +
                        " ╚═╝     ╚═╝ ╚═════╝ ╚═════╝  ╚═════╝     ╚═════╝ ╚═╝ ╚═════╝ ╚══════╝\n"
                            );

                            System.out.println("\n Categoría secreta desbloqueada: SECRETOS\n");
}

                        // Mostrar categorías
                        System.out.println("CATEGORÍAS:");
                        System.out.println("ANIMALES | TECNOLOGIA | PAISES | COLOMBIA | PROGRAMACION");

                        if (modoDios) {
                            System.out.println("SECRETOS (¡Solo para el modo Dios!)");
                        }

                        System.out.print("\nElige: ");
                        String cat = sc.next();

                        // Validar categoría si NO es modo Dios
                        if (!modoDios && cat.equalsIgnoreCase("SECRETOS")) {
                            System.out.println("Categoría bloqueada");
                            break;
                        }

                        // Jugar
                        Juego.jugar(palabras, cat, modoDios, nombre);

                        break;

                case 2:
                    System.out.println("\nAdivina la palabra antes de 6 errores.");
                    break;

                case 3:
                    RecordManager.mostrarTop();
                    break;

                case 4:
                    System.out.println("Adiós!");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (op != 4);
    }
}