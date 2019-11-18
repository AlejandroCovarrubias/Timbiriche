/**
 * Cuadro.java
 */
package Dominio;

/**
 *
 * @author Alejandro Galindo, Francisco Felix, Cesar Acactitla
 */
public class Cuadro extends FormaJuego {

    private Linea superior, inferior, izquierda, derecha;

    public Cuadro(Linea superior, Linea inferior, Linea izquierda, 
            Linea derecha, int width, int height, int x, int y) {
        super(width, height, x, y);
        this.superior = superior;
        this.inferior = inferior;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }
    
    public char obtenerInicial(){
        return this.getJugador().getNombre().charAt(0);
    }
    
    public boolean tieneLinea(Linea lineaBuscada){
        return superior.equals(lineaBuscada) || inferior.equals(lineaBuscada) ||
                izquierda.equals(lineaBuscada) || derecha.equals(lineaBuscada);
    }
    
    public boolean estaCompleto(){
        return superior.getJugador() != null && inferior.getJugador() != null && 
                izquierda.getJugador() != null && derecha.getJugador() != null;
    }
}