package laberintoautomatico;

public class Colores {

    public static final String RESET = "\033[0m";

    public static final String ROJO = "\033[31m";
    public static final String VERDE = "\033[32m";
    public static final String AMARILLO = "\033[33m";
    public static final String AZUL = "\033[34m";
    public static final String MORADO = "\033[35m";
    public static final String CYAN = "\033[36m";
    public static final String BLANCO = "\033[37m";
    public static final String NEGRO = "\033[1;37m";

    public static final String ROJO_OSCURO = "\033[2;31m";
    public static final String VERDE_OSCURO = "\033[2;32m";
    public static final String AMARILLO_OSCURO = "\033[2;33m";
    public static final String AZUL_OSCURO = "\033[2;34m";
    public static final String MORADO_OSCURO = "\033[2;35m";
    public static final String CYAN_OSCURO = "\033[2;36m";

    public static final String[] COLORES_LETRAS = {
        ROJO, VERDE, AMARILLO, AZUL, MORADO, CYAN, BLANCO, NEGRO, ROJO_OSCURO,
        VERDE_OSCURO, AMARILLO_OSCURO, AZUL_OSCURO, MORADO_OSCURO, CYAN_OSCURO};

    public static final String FONDO_ROJO = "\033[41m";
    public static final String FONDO_VERDE = "\033[42m";
    public static final String FONDO_AMARILLO = "\033[43m";
    public static final String FONDO_AZUL = "\033[44m";
    public static final String FONDO_MORADO = "\033[45m";
    public static final String FONDO_CYAN = "\033[46m";
    public static final String FONDO_BLANCO = "\033[47m";

    public static final String[] COLORES_FONDO = {
        FONDO_ROJO, FONDO_VERDE, FONDO_AMARILLO, FONDO_AZUL, FONDO_MORADO,
        FONDO_CYAN, FONDO_BLANCO};
}
