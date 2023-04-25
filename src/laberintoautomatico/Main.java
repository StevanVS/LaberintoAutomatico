package laberintoautomatico;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Laberinto laberinto = new Laberinto("src/Laberinto.txt");

        Algoritmo a = new Algoritmo(laberinto, false, 500);
        
        a.iniciarAlgoritmo();
    }
}
