import java.util.Arrays;
import java.util.*;

public class Juego {

    public static void jugar(List<Palabra> palabras, String categoria, boolean modoDios, String nombre) {

        List<Palabra> filtradas = new ArrayList<>();

        for (Palabra p : palabras) {
            if (p.getCategoria().equalsIgnoreCase(categoria)) {
                filtradas.add(p);
            }
        }

        if (filtradas.isEmpty()) {
            System.out.println("Categoría inválida");
            return;
        }

        Palabra seleccion = filtradas.get((int)(Math.random() * filtradas.size()));
        String palabra = seleccion.getPalabra();

        char[] estado = new char[palabra.length()];
        Arrays.fill(estado, '_');

        int errores = 0;
        Scanner sc = new Scanner(System.in);
        List<Character> usadas = new ArrayList<>();

        while (errores < 6 && !estaCompleta(estado)) {

            mostrarAhorcado(errores);
            mostrarPalabra(estado);

            System.out.println("Pista: " + seleccion.getPista());
            System.out.println("Letras usadas: " + usadas);

            System.out.print("Letra: ");
            char letra = sc.next().toLowerCase().charAt(0);

            if (usadas.contains(letra)) {
                System.out.println("Ya usaste esa letra");
                continue;
            }

            usadas.add(letra);

            if (!validarLetra(letra, palabra, estado)) {
                errores++;
            }
        }

        if (estaCompleta(estado)) {

            int puntaje = 6 - errores;

            RecordManager.guardarRecord(nombre, puntaje);

            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║               GANASTE!!              ║");
            System.out.println("╚══════════════════════════════════════╝");
                      System.out.println( "   .oOOOOOOo.\r\n" + //
                                        "   oO'        'Oo\r\n" + //
                                        "  O'  O      O  'O\r\n" + //
                                        " O                O\r\n" + //
                                        " O        >       O\r\n" + //
                                        " O  Oo,      ,oO  O\r\n" + //
                                        "  O. 'OOOOOOOO' .O\r\n" + //
                                        "   Yb.        .dP\r\n" + //
                                        "     YOOOOOOP'");
                } else {
        
            mostrarAhorcado(6);
            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println(" ║  PERDISTE... La palabra era: " + palabra + "    ║");
            System.out.println("╚══════════════════════════════════════════════╝");
                        System.out.println( "        .-000000.   \r\n" + // 
                                            "     .0°         °0.  \r\n" + //
                                            "     O   O      O   O  \r\n" + // 
                                            "    :           `    :\r\n" + //
                                            "    |                |   \r\n" + //
                                            "    :    .000000.    :\r\n" + //
                                            "     O  O        O  O\r\n" + //
                                            "      '.          .'\r\n" + //
                                            "        '-......-'" );
        }
    }

    public static boolean validarLetra(char letra, String palabra, char[] estado) {
        boolean ok = false;

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                estado[i] = letra;
                ok = true;
            }
        }

        return ok;
    }

    public static boolean estaCompleta(char[] estado) {
        for (char c : estado) {
            if (c == '_') return false;
        }
        return true;
    }

    public static void mostrarPalabra(char[] estado) {
        for (char c : estado) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void mostrarAhorcado(int e) {

        String[] a = {
            " +---+\n |   |\n     |\n     |\n     |\n     |\n=========",
            " +---+\n |   |\n O   |\n     |\n     |\n     |\n=========",
            " +---+\n |   |\n O   |\n |   |\n     |\n     |\n=========",
            " +---+\n |   |\n O   |\n/|   |\n     |\n     |\n=========",
            " +---+\n |   |\n O   |\n/|\\  |\n     |\n     |\n=========",
            " +---+\n |   |\n O   |\n/|\\  |\n/    |\n     |\n=========",
            " +---+\n |   |\n O   |\n/|\\  |\n/ \\  |\n     |\n========="
        };

        System.out.println(a[e]);
    }
    
    public static boolean verificarEasterEgg(String nombre) {
    return nombre.equalsIgnoreCase("XACARANA");
}
}