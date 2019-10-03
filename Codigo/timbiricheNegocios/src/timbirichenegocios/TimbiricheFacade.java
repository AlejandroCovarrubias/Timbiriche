/**
 * TimbiricheFacade.java
 */
package timbirichenegocios;

import Dominio.FormaJuego;
import Dominio.Jugador;
import Dominio.Linea;
import Dominio.Marcador;
import Dominio.Sala;
import Dominio.Tablero;
import java.util.List;

/**
 *
 * @author Alejandro Galindo
 */
public class TimbiricheFacade implements ITimbiriche{
    private ControlJuego control = new ControlJuego();

    @Override
    public Sala crearSala(Marcador marcador, int tamanio) {
        return control.crearSala(marcador, tamanio);
    }

    @Override
    public Sala actualizarSala(Sala sala) {
        //
        return null;
    }

    @Override
    public Jugador[] buscarJugadores(Sala sala) {
        //Busca jugadores para una sala en especifico?
        return control.buscarJugadores(sala);
    }

    @Override
    public String agregarLinea(Linea linea, Jugador jugador) {
        return control.agregarLinea(linea, jugador);
    }

    @Override
    public void buscarMovimiento(Tablero tablero, Marcador marcador, int turno) {
        control.buscarMovimiento(tablero, marcador, turno);
    }

    @Override
    public int cantidadDeLineasConJugador(Tablero tablero) {
        return control.cantidadDeLineasConJugador(tablero);
    }
}