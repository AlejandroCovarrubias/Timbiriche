/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Pipes;

import Dominio.Tablero;
import pipesandfilters.SinkRepo;

/**
 *
 * @author Alejandro Galindo
 */
public class PipeTablero implements Pipe<Tablero, SinkRepo>{

    @Override
    public void pasar(Tablero objeto) {
        SinkRepo sr = SinkRepo.getInstance();
        sr.asignarTablero(objeto);
    }
    
}
