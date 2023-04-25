package laberintoautomatico;

public class Robot {
    
    private char[] bot = {'^', '>', 'v', '<'};
    
    private int x;
    private int y;
    
    private int orientacion;
    
    private boolean moverseEnfrente;
    
    private int movimientos;
    private int giros;
    
    private int colorIndex;

    public Robot() {

    }
    
    public Robot(int x, int y, int colorIndex){
        this.x = x;
        this.y = y;
        this.moverseEnfrente = false;
        this.movimientos = 0;
        this.giros = 0;
        this.colorIndex = colorIndex;
    }
    
    public Robot(int x, int y, int orientacion, int colorIndex) {
        this.x = x;
        this.y = y;
        this.orientacion = Integer.remainderUnsigned(orientacion, 4);
        this.moverseEnfrente = false;
        this.movimientos = 0;
        this.giros = 0;
        this.colorIndex = colorIndex;
    }

    public char[] getBot() {
        return bot;
    }

    public void setBot(char[] bot) {
        this.bot = bot;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(int orientacion) {
        this.orientacion = Integer.remainderUnsigned(orientacion, 4);
    }
    
    public int getMovimientos() {
        return movimientos;
    }
    
    public void setMovimientos(int movimientos) {
        this.movimientos = movimientos;
    }

    public int getGiros() {
        return giros;
    }

    public void setGiros(int giros) {
        this.giros = giros;
    }

    public int getColorIndex() {
        return colorIndex;
    }

    public void setColorIndex(int colorIndex) {
        this.colorIndex = colorIndex;
    }

    public boolean isMoverseEnfrente() {
        return moverseEnfrente;
    }

    public void setMoverseEnfrente(boolean moverseEnfrente) {
        this.moverseEnfrente = moverseEnfrente;
    }
    
    public char getChar(){
        return bot[Integer.remainderUnsigned(orientacion, 4)];
    }
    
    public int getIndex(int ancho){
        return (y * ancho) + x;
    }
    
    public void girarDerecha(){
        this.orientacion = Integer.remainderUnsigned(orientacion + 1, 4);
    }
    
    public void girarIzquierda(){
        this.orientacion = Integer.remainderUnsigned(orientacion - 1, 4);
    }
    
    public void mostrarPosicion(){
        System.out.println(x + " " + y);
    }
}
