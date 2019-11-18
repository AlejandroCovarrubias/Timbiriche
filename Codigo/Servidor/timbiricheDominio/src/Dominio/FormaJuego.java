/**
 * FormaJuego.java
 */
package Dominio;

/**
 *
 * @author Alejandro Galindo, Francisco Felix, Cesar Acactitla
 */
public class FormaJuego extends Forma{
    
    private Jugador jugador;

    public FormaJuego(int width, int height, int x, int y) {
        super(width, height, x, y);
    }
    
    public FormaJuego(int width, int height, int x, int y, Jugador jugador) {
        super(width, height, x, y);
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }   
}