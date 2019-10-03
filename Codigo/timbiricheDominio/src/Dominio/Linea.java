/**
 * Linea.java
 */
package Dominio;

/**
 *
 * @author Alejandro Galindo, Francisco Felix, Cesar Acactitla
 */
public class Linea extends FormaJuego {
    
    private boolean conectado;

    public Linea(int width, int height, int x, int y) {
        super(width, height, x, y);
    }
    
    public Linea(int width, int height, int x, int y, Jugador jugador) {
        super(width, height, x, y, jugador);
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }
}