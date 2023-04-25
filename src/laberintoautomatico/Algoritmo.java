package laberintoautomatico;

/**
 * Para minicar toto.
 *
 * @author Stevan
 */
public class Algoritmo {

    private Laberinto laberinto;

    private boolean direccionGiroDerecha;
    private long intervaloTiempo;

    public Algoritmo(Laberinto laberinto, boolean giroPorDerecha, long tiempo) {
        this.laberinto = laberinto;
        this.direccionGiroDerecha = giroPorDerecha;
        this.intervaloTiempo = tiempo;
    }

    public void iniciarAlgoritmo() throws InterruptedException {

        int botGanador = 0;
        boolean terminar = false;

        mostrarLimpiarLaberinto();

        do {

            for (int i = 0; i < laberinto.getBot().length; i++) {

                if (laberinto.getBot()[i].isMoverseEnfrente()) {
                    moverRobot(i);
                    laberinto.getBot()[i].setMoverseEnfrente(false);
                } else if (direccionGiroDerecha) {
                    laberinto.getBot()[i].setMoverseEnfrente(girarRobotPorDerecha(i));
                } else {
                    laberinto.getBot()[i].setMoverseEnfrente(girarRobotPorIzquierda(i));
                }

                int robotIndex = laberinto.getBot()[i].getIndex(laberinto.getLaberintoAncho());
                for (Meta salida : laberinto.getSalida()) {
                    int metaIndex = salida.getIndex(laberinto.getLaberintoAncho());

                    if (robotIndex == metaIndex) {
                        botGanador = i;
                        terminar = true;
                        break;
                    }
                }
            }

        } while (!terminar);

        System.out.println("GANADOR:" + Colores.COLORES_LETRAS[botGanador]
                + " Robot " + botGanador + '\n');

        for (int i = 0; i < laberinto.getBot().length; i++) {
            System.out.println(Colores.COLORES_LETRAS[i] + "Robot " + i);
            System.out.println("Numero de movimientos: " + laberinto.getBot()[i].getMovimientos());
            System.out.println("Numero de giros: " + laberinto.getBot()[i].getGiros());
            System.out.println();
        }
    }

    private void moverRobot(int i) throws InterruptedException {

        int robotX = laberinto.getBot()[i].getX();
        int robotY = laberinto.getBot()[i].getY();

        switch (laberinto.getBot()[i].getOrientacion()) {
            case 0:// '^'
                moverY(i, robotY, -1);
                break;
            case 1:// '>'
                moverX(i, robotX, +1);
                break;
            case 2:// 'v'
                moverY(i, robotY, +1);
                break;
            case 3:// '<'
                moverX(i, robotX, -1);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void moverX(int i, int robotX, int diferenciaX) throws InterruptedException {
        laberinto.getBot()[i].setX(robotX + diferenciaX);
        laberinto.getBot()[i].setMovimientos(laberinto.getBot()[i].getMovimientos() + 1);
        mostrarLimpiarLaberinto();
    }

    private void moverY(int i, int robotY, int diferenciaY) throws InterruptedException {
        laberinto.getBot()[i].setY(robotY + diferenciaY);
        laberinto.getBot()[i].setMovimientos(laberinto.getBot()[i].getMovimientos() + 1);
        mostrarLimpiarLaberinto();
    }

    private boolean comprobarDireccion(int i, int diferenciaX, int diferenciaY) {
        String tabla = laberinto.getLaberinto().toString();
        int robotX = laberinto.getBot()[i].getX();
        int robotY = laberinto.getBot()[i].getY();
        return ' ' == tabla.charAt(laberinto.getIndex(
                robotX + diferenciaX, robotY + diferenciaY));
    }

    private boolean girarRobotPorDerecha(int i) throws InterruptedException {

        switch (laberinto.getBot()[i].getOrientacion()) {
            case 0:// '^'
                if (comprobarDireccion(i, +1, 0)) {
                    girarDerecha(i);
                    return true;
                } else if (comprobarDireccion(i, 0, -1)) {
                    moverRobot(i);
                    return false;
                } else {
                    girarIzquierda(i);
                    return comprobarDireccion(i, -1, 0);
                }
            case 1:// '>'
                if (comprobarDireccion(i, 0, +1)) {
                    girarDerecha(i);
                    return true;
                } else if (comprobarDireccion(i, +1, 0)) {
                    moverRobot(i);
                    return false;
                } else {
                    girarIzquierda(i);
                    return comprobarDireccion(i, 0, -1);
                }
            case 2:// 'v'
                if (comprobarDireccion(i, -1, 0)) {
                    girarDerecha(i);
                    return true;
                } else if (comprobarDireccion(i, 0, +1)) {
                    moverRobot(i);
                    return false;
                } else {
                    girarIzquierda(i);
                    return comprobarDireccion(i, +1, 0);
                }
            case 3:// '<'
                if (comprobarDireccion(i, 0, -1)) {
                    girarDerecha(i);
                    return true;
                } else if (comprobarDireccion(i, -1, 0)) {
                    moverRobot(i);
                    return false;
                } else {
                    girarIzquierda(i);
                    return comprobarDireccion(i, 0, +1);
                }
            default:
                throw new AssertionError();
        }
    }

    private boolean girarRobotPorIzquierda(int i) throws InterruptedException {

        switch (laberinto.getBot()[i].getOrientacion()) {
            case 0:// '^'
                if (comprobarDireccion(i, -1, 0)) {
                    girarIzquierda(i);
                    return true;
                } else if (comprobarDireccion(i, 0, -1)) {
                    moverRobot(i);
                    return false;
                } else {
                    girarDerecha(i);
                    return comprobarDireccion(i, +1, 0);
                }
            case 1:// '>'
                if (comprobarDireccion(i, 0, -1)) {
                    girarIzquierda(i);
                    return true;
                } else if (comprobarDireccion(i, +1, 0)) {
                    moverRobot(i);
                    return false;
                } else {
                    girarDerecha(i);
                    return comprobarDireccion(i, 0, +1);
                }
            case 2:// 'v'
                if (comprobarDireccion(i, +1, 0)) {
                    girarIzquierda(i);
                    return true;
                } else if (comprobarDireccion(i, 0, +1)) {
                    moverRobot(i);
                    return false;
                } else {
                    girarDerecha(i);
                    return comprobarDireccion(i, -1, 0);
                }
            case 3:// '<'
                if (comprobarDireccion(i, 0, +1)) {
                    girarIzquierda(i);
                    return true;
                } else if (comprobarDireccion(i, -1, 0)) {
                    moverRobot(i);
                    return false;
                } else {
                    girarDerecha(i);
                    return comprobarDireccion(i, 0, -1);
                }
            default:
                throw new AssertionError();
        }
    }

    private void girarDerecha(int i) throws InterruptedException {
        laberinto.getBot()[i].girarDerecha();
        laberinto.getBot()[i].setGiros(laberinto.getBot()[i].getGiros() + 1);
        mostrarLimpiarLaberinto();
    }

    private void girarIzquierda(int i) throws InterruptedException {
        laberinto.getBot()[i].girarIzquierda();
        laberinto.getBot()[i].setGiros(laberinto.getBot()[i].getGiros() + 1);
        mostrarLimpiarLaberinto();
    }

    private void mostrarLimpiarLaberinto() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }

        laberinto.mostrarLaberinto();

        Thread.sleep(intervaloTiempo);

    }

    public boolean isDireccionGiroDerecha() {
        return direccionGiroDerecha;
    }

    public void setDireccionGiroDerecha(boolean direccionGiroDerecha) {
        this.direccionGiroDerecha = direccionGiroDerecha;
    }

    public long getIntervaloTiempo() {
        return intervaloTiempo;
    }

    public void setIntervaloTiempo(long intervaloTiempo) {
        this.intervaloTiempo = intervaloTiempo;
    }

    public Laberinto getLaberinto() {
        return laberinto;
    }

    public void setLaberinto(Laberinto laberinto) {
        this.laberinto = laberinto;
    }

}
