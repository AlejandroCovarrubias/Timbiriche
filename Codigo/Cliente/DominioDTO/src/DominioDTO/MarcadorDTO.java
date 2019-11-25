/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DominioDTO;

import java.util.List;

/**
 *
 * @author Alejandro Galindo
 */
public class MarcadorDTO {
    private List<JugadorDTO> jugadores;
    private JugadorDTO siguiente;

    public MarcadorDTO(List<JugadorDTO> jugadores) {
        this.jugadores = jugadores;
        this.siguiente = jugadores.get(0);
    }

    public List<JugadorDTO> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorDTO> jugadores) {
        this.jugadores = jugadores;
    }

    public JugadorDTO getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(JugadorDTO siguiente) {
        this.siguiente = siguiente;
    }
}
