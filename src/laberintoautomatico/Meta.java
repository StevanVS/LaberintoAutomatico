package laberintoautomatico;

public class Meta {
    
    private int x;
    private int y;

    public Meta() {

    }

    public Meta(int x, int y) {
        this.x = x;
        this.y = y;
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
    
    public int getIndex(int ancho){
        return (y * ancho) + x;
    }
    
    public void mostrarPosicion(){
        System.out.println(x + " " + y);
    }
}
