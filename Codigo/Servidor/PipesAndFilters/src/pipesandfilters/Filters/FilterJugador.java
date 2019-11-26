/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Filters;

import Dominio.Jugador;
import DominioDTO.JugadorDTO;
import pipesandfilters.Pipes.PipeJugador;

/**
 *
 * @author Alejandro Galindo
 */
public class FilterJugador implements Filter<JugadorDTO, Jugador, PipeJugador> {

    @Override
    public void procesar(JugadorDTO objeto) {
        Jugador jugador = new Jugador(objeto.getNombreJugador(), objeto.getRutaAvatar());
        PipeJugador pj = new PipeJugador();
        pj.pasar(jugador);
    }
}
