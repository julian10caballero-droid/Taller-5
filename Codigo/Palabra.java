public class Palabra {
    String categoria;
    String palabra;
    String pista;

    public Palabra(String categoria, String palabra, String pista) {
        this.categoria = categoria;
        this.palabra = palabra;
        this.pista = pista;
    }

    public String getCategoria() { return categoria; }
    public String getPalabra() { return palabra; }
    public String getPista() { return pista; }
}