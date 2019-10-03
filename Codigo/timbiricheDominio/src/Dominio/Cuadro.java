/**
 * Cuadro.java
 */
package Dominio;

/**
 *
 * @author Alejandro Galindo, Francisco Felix, Cesar Acactitla
 */
public class Cuadro extends FormaJuego {

    private Linea[] lineasHorizontal;
    private Linea[] lineasVertical;

    public Cuadro(Linea[] lineasHorizontal, Linea[] lineasVertical, int width, int height, int x, int y, Jugador jugador) {
        super(width, height, x, y, jugador);
        this.lineasHorizontal = lineasHorizontal;
        this.lineasVertical = lineasVertical;
    }

    public Linea[] getLineasHorizontal() {
        return lineasHorizontal;
    }

    public void setLineasHorizontal(Linea[] lineasHorizontal) {
        this.lineasHorizontal = lineasHorizontal;
    }

    public Linea[] getLineasVertical() {
        return lineasVertical;
    }

    public void setLineasVertical(Linea[] lineasVertical) {
        this.lineasVertical = lineasVertical;
    }    
}