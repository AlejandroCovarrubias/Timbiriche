/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DominioDTO;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Alejandro Galindo
 */
public class MarcadorDTO implements Serializable{
    private List<JugadorDTO> jugadores;
    private int siguiente;

    public MarcadorDTO(List<JugadorDTO> jugadores) {
        this.jugadores = jugadores;
        this.siguiente = 0;
    }

    public MarcadorDTO(List<JugadorDTO> jugadores, int siguiente) {
        this.jugadores = jugadores;
        this.siguiente = siguiente;
    }

    public List<JugadorDTO> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorDTO> jugadores) {
        this.jugadores = jugadores;
    }

    public int getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(int siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "MarcadorDTO{" + "jugadores=" + jugadores + ", siguiente=" + siguiente + '}';
    }
}