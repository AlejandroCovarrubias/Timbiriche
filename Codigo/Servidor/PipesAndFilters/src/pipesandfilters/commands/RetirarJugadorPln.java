/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.commands;

import DominioDTO.JugadorDTO;
import pipesandfilters.Pipes.PipeJugadorDTO;

/**
 *
 * @author Alejandro Galindo
 */
class RetirarJugadorPln implements IPAFPipeline {
    
    private JugadorDTO jugador;

    public RetirarJugadorPln(JugadorDTO jugador) {
        this.jugador = jugador;
    }

    @Override
    public void ejecutar() {
        PipeJugadorDTO pj = new PipeJugadorDTO();
        pj.pasar(jugador);
    }
    
}
