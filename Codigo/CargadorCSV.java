import java.io.*;
import java.util.*;

public class CargadorCSV {

    public static List<Palabra> cargarPalabras() {
        List<Palabra> lista = new ArrayList<>();
        
                try {
                     BufferedReader br = new BufferedReader(
                        new FileReader("C:\\Users\\Usuario\\Documents\\Logica Programación\\Taller 6\\src\\palabras.csv")
                        );

                String linea = br.readLine(); // saltar encabezado

                while ((linea = br.readLine()) != null) {

                    linea = linea.replace("\"", "");

                    String[] partes = linea.split(",");

                    if (partes.length < 3) continue;

                    lista.add(new Palabra(
                        partes[0].trim(),
                        partes[1].trim(),
                        partes[2].trim()
                    ));
                }

                br.close();

            } catch (Exception e) {
                System.out.println("Error leyendo CSV");
            }

        return lista;
    }
}