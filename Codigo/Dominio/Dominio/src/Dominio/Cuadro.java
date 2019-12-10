/**
 * Cuadro.java
 */
package Dominio;

/**
 *
 * @author Alejandro Galindo, Francisco Felix
 */
public class Cuadro extends FormaJuego {

    private Linea superior, inferior, izquierda, derecha;

    public Cuadro(int indice) {
        super(null, indice, 0, 0, 0, 0);
    }

    public Cuadro(Jugador jugador, int indice) {
        super(jugador, indice, 0, 0, 0, 0);
    }

    public Cuadro(Linea superior, Linea inferior, Linea izquierda, Linea derecha, Jugador jugador, int indice) {
        super(jugador, indice, 0, 0, 0, 0);
        this.superior = superior;
        this.inferior = inferior;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public Cuadro(Linea superior, Linea inferior, Linea izquierda, Linea derecha, Jugador jugador, int indice, int width, int height, int x, int y) {
        super(jugador, indice, width, height, x, y);
        this.superior = superior;
        this.inferior = inferior;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public char obtenerInicial() {
        return this.getJugador().getNombre().charAt(0);
    }

    public boolean tieneLinea(Linea lineaBuscada) {
        return superior.equals(lineaBuscada) || inferior.equals(lineaBuscada)
                || izquierda.equals(lineaBuscada) || derecha.equals(lineaBuscada);
    }

    public boolean estaCompleto() {
        return superior.getJugador() != null && inferior.getJugador() != null
                && izquierda.getJugador() != null && derecha.getJugador() != null;
    }

    @Override
    public String toString() {
        return "Cuadro{" + "jugador=" + super.getJugador() + "indice" + super.getIndice() + '}';
    }

}
