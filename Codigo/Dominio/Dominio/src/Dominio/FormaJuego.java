/**
 * FormaJuego.java
 */
package Dominio;

/**
 *
 * @author Alejandro Galindo, Francisco Felix
 */
public class FormaJuego extends Forma {

    private Jugador jugador;
    private int indice;

    public FormaJuego(int width, int height, int x, int y) {
        super(width, height, x, y);
    }

    public FormaJuego(Jugador jugador, int width, int height, int x, int y) {
        super(width, height, x, y);
        this.jugador = jugador;
    }

    public FormaJuego(Jugador jugador, int indice, int width, int height, int x, int y) {
        super(width, height, x, y);
        this.jugador = jugador;
        this.indice = indice;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    @Override
    public String toString() {
        return "FormaJuego{" + "jugador=" + jugador + ", indice=" + indice + '}';
    }

}
