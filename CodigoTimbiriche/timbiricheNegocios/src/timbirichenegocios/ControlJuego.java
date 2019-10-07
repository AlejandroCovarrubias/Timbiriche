/**
 * ControlJuego.java
 */
package timbirichenegocios;

import Dominio.Cuadro;
import Dominio.Jugador;
import Dominio.Linea;
import Dominio.Marcador;
import Dominio.Tablero;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro Galindo, Francisco Felix, Cesar Acactitla
 */
class ControlJuego {
    public String agregarLinea(Linea linea, Jugador jugador) {
        if (linea.getJugador() == null) {
            linea.setJugador(jugador);
        } else {
            return "Escoge una linea que no haya sido marcada anteriormente";
        }
        return "";
    }

    public void buscarMovimiento(Tablero tablero, Marcador marcador, int turno) {
        //Escucha? a algo? para ver si alguien hizo un movimiento

        //Genera movimiento al azar, de momento
        List<Linea> lineasHorizontales = tablero.getLineasHorizontales();
        List<Linea> lineasVerticales = tablero.getLineasVerticales();
        Linea lineaIndex = null;

        int rnd = (int) (Math.random() * 2 + 1);

        if (rnd == 1) {
            while (lineaIndex == null) {
                rnd = (int) (Math.random() * lineasHorizontales.size() + 1);
                Linea linea = lineasHorizontales.get(rnd - 1);

                if (linea.getJugador() == null) {
                    linea.setJugador(marcador.getJugadores().get(turno));
                    lineaIndex = linea;
                }
            }
        } else {
            while (lineaIndex == null) {
                rnd = (int) (Math.random() * lineasVerticales.size() + 1);
                Linea linea = lineasVerticales.get(rnd - 1);

                if (linea.getJugador() == null) {
                    linea.setJugador(marcador.getJugadores().get(turno));
                    lineaIndex = linea;
                }
            }
        }
        
        verificarMovimiento(tablero.getCuadros(), lineaIndex, marcador.getJugadores().get(turno));
    }

    public int cantidadDeLineasConJugador(Tablero tablero) {
        int lineasVerticales = 0, lineasHorizontales = 0;

        for (Linea lineaHorizontal : tablero.getLineasHorizontales()) {
            if (lineaHorizontal.getJugador() != null) {
                lineasHorizontales++;
            }
        }

        for (Linea lineaVertical : tablero.getLineasVerticales()) {
            if (lineaVertical.getJugador() != null) {
                lineasVerticales++;
            }
        }

        return lineasVerticales + lineasHorizontales;
    }

    public void verificarMovimiento(List<Cuadro> cuadros, Linea linea, Jugador jugador) {
        List<Cuadro> cuadrosTemporal = new ArrayList<>();

        for (Cuadro cuadro : cuadros) {
            if (cuadro.tieneLinea(linea)) {
                if(cuadro.getJugador() == null){
                    cuadrosTemporal.add(cuadro);
                }
            }
        }

        for (Cuadro cuadro : cuadrosTemporal) {
            if (cuadro.estaCompleto()) {
                cuadro.setJugador(jugador);
                jugador.setPuntaje(jugador.getPuntaje() + 1);
            }
        }
    }
    
    public void turnarJugadores(Marcador marcador){
        marcador.turnar();
    }
}