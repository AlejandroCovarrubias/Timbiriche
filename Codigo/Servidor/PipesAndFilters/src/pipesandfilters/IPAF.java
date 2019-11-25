/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import DominioDTO.*;
import java.util.List;

/**
 *
 * @author Alejandro Galindo
 */
public interface IPAF {
    void crearSala(List<JugadorDTO> jugadores);
    void asignarLinea(LineaDTO linea);
    void asignarCuadro(CuadroDTO cuadro);
    void retirarJugador(JugadorDTO jugador);
}