/**
 * Linea.java
 */
package Dominio;

/**
 *
 * @author Alejandro Galindo, Francisco Felix
 */
public class Linea extends FormaJuego {
    
    private String posicion;

    public Linea(int width, int height, int x, int y) {
        super(width, height, x, y);
    }
    
    public Linea(Jugador jugador, int width, int height, int x, int y) {
        super(jugador, width, height, x, y);
    }

    public Linea(String posicion, int width, int height, int x, int y) {
        super(width, height, x, y);
        this.posicion = posicion;
    }

    public Linea(String posicion, Jugador jugador, int width, int height, int x, int y) {
        super(jugador, width, height, x, y);
        this.posicion = posicion;
    }

    public Linea(String posicion, Jugador jugador, int indice, int width, int height, int x, int y) {
        super(jugador, indice, width, height, x, y);
        this.posicion = posicion;
    }

    public Linea(String posicion, Jugador jugador, int indice) {
        super(jugador, indice, 0, 0, 0, 0);
        this.posicion = posicion;
    }
    
    
}