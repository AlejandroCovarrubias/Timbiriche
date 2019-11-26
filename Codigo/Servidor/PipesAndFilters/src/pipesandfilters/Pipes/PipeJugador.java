/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Pipes;

import Dominio.Jugador;
import pipesandfilters.SinkRepo;

/**
 *
 * @author Alejandro Galindo
 */
public class PipeJugador implements Pipe<Jugador, SinkRepo> {

    @Override
    public void pasar(Jugador objeto) {
        SinkRepo sr = SinkRepo.getInstance();
        sr.retirarJugador(objeto);
        
    }
    
}
