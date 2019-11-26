/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Filters;

import Dominio.Jugador;
import DominioDTO.JugadorDTO;
import java.util.ArrayList;
import java.util.List;
import pipesandfilters.Pipes.PipeJugadores;

/**
 *
 * @author Alejandro Galindo
 */
public class FilterJugadores implements Filter<List<JugadorDTO>, List<Jugador>, PipeJugadores>{

    @Override
    public void procesar(List<JugadorDTO> objeto) {
        List<Jugador> jugadores = new ArrayList<>();
        for (JugadorDTO jugadorDTO : objeto) {
            Jugador jugador = new Jugador(jugadorDTO.getNombreJugador(), 
                    jugadorDTO.getRutaAvatar());
            jugadores.add(jugador);
        }
        PipeJugadores pj = new PipeJugadores();
        pj.pasar(jugadores);
    }
}