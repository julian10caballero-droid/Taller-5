import java.io.*;
import java.util.*;

public class RecordManager {

    static String archivo = "records.txt";

    public static void guardarRecord(String nombre, int puntaje) {

        try {
            File file = new File(archivo);

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter bw = new BufferedWriter(
                new FileWriter(file, true)
            );

            bw.write(nombre + "," + puntaje);
            bw.newLine();

            bw.close();

        } catch (Exception e) {
            System.out.println("Error guardando record");
        }
    }

    public static List<Record> leerRecords() {

        List<Record> lista = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(
                new FileReader(archivo)
            );

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                lista.add(new Record(
                    partes[0],
                    Integer.parseInt(partes[1])
                ));
            }

            br.close();

        } catch (Exception e) {
            System.out.println("No hay records aún");
        }

        return lista;
    }

    public static void mostrarTop() {

        List<Record> lista = leerRecords();

        lista.sort((a, b) -> b.puntaje - a.puntaje);

        System.out.println("\nTOP RECORDS ");

        int i = 1;
        for (Record r : lista) {
            System.out.println(i + ". " + r.nombre + " - " + r.puntaje);
            if (i++ == 5) break;
        }
    }
}