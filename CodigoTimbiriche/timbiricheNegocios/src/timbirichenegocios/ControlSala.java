/**
 * ControlSala.java
 */
package timbirichenegocios;

import Dominio.Jugador;
import Dominio.Marcador;
import Dominio.Sala;

/**
 *
 * @author Alejandro Galindo, Francisco Felix, Cesar Acactitla
 */
public class ControlSala {

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
}