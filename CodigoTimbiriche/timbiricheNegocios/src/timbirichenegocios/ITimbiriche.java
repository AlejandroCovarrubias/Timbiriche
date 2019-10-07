/**
 * ITimbiriche.java
 */
package timbirichenegocios;

import Dominio.Cuadro;
import Dominio.Jugador;
import Dominio.Linea;
import Dominio.Marcador;
import Dominio.Sala;
import Dominio.Tablero;
import java.util.List;

/**
 *
 * @author Alejandro Galindo, Francisco Felix, Cesar Acactitla
 */
public interface ITimbiriche {
    Sala crearSala(Marcador marcador, int tamanio);
    Sala actualizarSala(Sala sala);
    Jugador[] buscarJugadores(Sala sala);
    String agregarLinea(Linea forma, Jugador jugador);
    void verficarMovimiento(List<Cuadro> cuadros, Linea linea, Jugador jugador);
    void buscarMovimiento(Tablero tablero, Marcador marcador, int turno);
    int cantidadDeLineasConJugador(Tablero tablero);
}