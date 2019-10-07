/**
 * TimbiricheFacade.java
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
 * @author Alejandro Galindo
 */
public class TimbiricheFacade implements ITimbiriche{
    private ControlJuego controlJuego = new ControlJuego();
    private ControlSala controlSala = new ControlSala();

    @Override
    public Sala crearSala(Marcador marcador, int tamanio) {
        return controlSala.crearSala(marcador, tamanio);
    }

    @Override
    public Sala actualizarSala(Sala sala) {
        //
        return null;
    }

    @Override
    public Jugador[] buscarJugadores(Sala sala) {
        //Busca jugadores para una sala en especifico?
        return controlSala.buscarJugadores(sala);
    }

    @Override
    public String agregarLinea(Linea linea, Jugador jugador) {
        return controlJuego.agregarLinea(linea, jugador);
    }

    @Override
    public void buscarMovimiento(Tablero tablero, Marcador marcador, int turno) {
        controlJuego.buscarMovimiento(tablero, marcador, turno);
    }

    @Override
    public int cantidadDeLineasConJugador(Tablero tablero) {
        return controlJuego.cantidadDeLineasConJugador(tablero);
    }

    @Override
    public void verficarMovimiento(List<Cuadro> cuadros, Linea linea, Jugador jugador) {
        controlJuego.verificarMovimiento(cuadros, linea, jugador);
    }

    @Override
    public void turnarJugadores(Marcador marcador) {
        controlJuego.turnarJugadores(marcador);
    }
}