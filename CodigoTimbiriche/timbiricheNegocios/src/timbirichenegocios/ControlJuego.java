/**
 * ControlJuego.java
 */
package timbirichenegocios;

import Dominio.Cuadro;
import Dominio.Jugador;
import Dominio.Linea;
import Dominio.Marcador;
import Dominio.Sala;
import Dominio.Tablero;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro Galindo, Francisco Felix, Cesar Acactitla
 */
class ControlJuego {

    public Sala crearSala(Marcador marcador, int tamanio) {
        //Revisa que no exista otra sala igual creada por el mismo jugador?
        Sala sala = new Sala(marcador, tamanio);
        //Guarda una sala en algun lado? o la envia a otros nodos con sockets?
        return sala;
    }

    public Sala actualizarSala(Sala sala) {
        //Busca la sala en algun sitio? y la actualiza
        //La cambia por la nueva
        //la retorna?
        return sala;
    }

    public Jugador[] buscarJugadores(Sala sala) {
        //Escucha a un socket? para ver si la sala recibio una peticion
        //o si otro jugador quiere conectarse
        //Regresa las peticiones hechas a la sala?

        int nJugador = (int) (Math.random() * 4 + 1);

        String avatar = "";
        switch (nJugador) {
            case 1:
                avatar = "hamsterAtomico.png";
                break;
            case 2:
                avatar = "loboLobezno.png";
                break;
            case 3:
                avatar = "pollitoEnojado.png";
                break;
            case 4:
                avatar = "poroPorito.png";
                break;
            default:
                break;
        }

        Jugador jugador = new Jugador("Jugador" + nJugador, avatar);
        Jugador[] jugadores = new Jugador[1];
        jugadores[0] = jugador;
        return jugadores;
    }

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
                Linea linea = lineasHorizontales.get(rnd);

                if (linea.getJugador() == null) {
                    linea.setJugador(marcador.getJugadores().get(turno));
                }
            }
        } else {
            while (lineaIndex == null) {
                rnd = (int) (Math.random() * lineasVerticales.size() + 1);
                Linea linea = lineasVerticales.get(rnd);

                if (linea.getJugador() == null) {
                    linea.setJugador(marcador.getJugadores().get(turno));
                }
            }
        }
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
}