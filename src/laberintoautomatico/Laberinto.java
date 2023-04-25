package laberintoautomatico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Arrays;


public class Laberinto {

    private StringBuffer laberinto = new StringBuffer();

    private Robot[] bot = new Robot[0];
    private Meta[] salida = new Meta[0];

    private int laberintoAncho;
    private int laberintoAlto;
    
    private int botI;

    public Laberinto(String archivo) throws FileNotFoundException, IOException {

        BufferedReader br = new BufferedReader(new FileReader(archivo));

        String linea;
        while ((linea = br.readLine()) != null) {
            laberintoAncho = linea.length();
            //linea de arriba
            if (laberintoAlto == 0) {
                for (int i = 0; i < laberintoAncho; i++) {
                    laberinto.append('-');
                }
                laberintoAlto++;
            }

            for (int i = 0; i < laberintoAncho; i++) {

                char ch = linea.charAt(i);

                if ((ch == '^') || (ch == '>') || (ch == 'v') || (ch == '<')) {
                    bot = Arrays.copyOf(bot, bot.length + 1);
                    bot[bot.length - 1] = new Robot(i, laberintoAlto, bot.length - 1);
                    laberinto.append("-");
                }

                switch (ch) {
                    case '^':
                        bot[bot.length - 1].setOrientacion(0);
                        break;
                    case '>':
                        bot[bot.length - 1].setOrientacion(1);
                        break;
                    case 'v':
                        bot[bot.length - 1].setOrientacion(2);
                        break;
                    case '<':
                        bot[bot.length - 1].setOrientacion(3);
                        break;
                    case '=':
                        salida = Arrays.copyOf(salida, salida.length + 1);
                        salida[salida.length - 1] = new Meta(i, laberintoAlto);
                        laberinto.append(" ");
                        break;
                    default:
                        laberinto.append(ch);
                }
            }
            laberintoAlto++;
        }

        //linea de abajo
        for (int i = 0; i < laberintoAncho; i++) {
            laberinto.append('-');
        }
        laberintoAlto++;
    }

    public StringBuffer getLaberinto() {
        return laberinto;
    }

    public void setLaberinto(StringBuffer laberinto) {
        this.laberinto = laberinto;
    }

    public Robot[] getBot() {
        return bot;
    }

    public void setBot(Robot[] bot) {
        this.bot = bot;
    }

    public Meta[] getSalida() {
        return salida;
    }

    public void setSalida(Meta[] salida) {
        this.salida = salida;
    }

    public int getLaberintoAncho() {
        return laberintoAncho;
    }

    public void setLaberintoAncho(int laberintoAncho) {
        this.laberintoAncho = laberintoAncho;
    }

    public int getLaberintoAlto() {
        return laberintoAlto;
    }

    public void setLaberintoAlto(int laberintoAlto) {
        this.laberintoAlto = laberintoAlto;
    }

    public int getIndex(int x, int y) {
        return (y * laberintoAncho) + x;
    }

    private boolean comprobarSalida(int x, int y) {
        for (Meta meta : salida) {
            if (getIndex(x, y) == meta.getIndex(laberintoAncho)) {
                return true;
            }

        }
        return false;
    }

    private boolean comprobarBot(int x, int y) {
        
        for (int i = 0; i < bot.length; i++) {
            if (getIndex(x, y) == bot[i].getIndex(laberintoAncho)) {
                botI = i;
                return true;
            }
        }
        
        for (Robot robot : bot) {
            if (getIndex(x, y) == robot.getIndex(laberintoAncho)) {
                return true;
            }
        }
        return false;
    }

    public void mostrarLaberinto() {
        for (int y = 0; y < laberintoAlto; y++) {
            for (int x = 0; x < laberintoAncho; x++) {

                if (comprobarBot(x, y)) {
                    System.out.print(Colores.COLORES_LETRAS[botI] + 
                            bot[botI].getChar() + Colores.RESET);
                } else if (comprobarSalida(x, y)) {
                    System.out.print("=");
                } else {
                    System.out.print(laberinto.charAt((y * laberintoAncho) + x));
                }

            }
            System.out.println();
        }
    }

}
